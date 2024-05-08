package enoca.javaChallenge.shoppingCart.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import enoca.javaChallenge.shoppingCart.business.abstracts.ICartService;
import enoca.javaChallenge.shoppingCart.business.businessRules.abstracts.ICartRules;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.core.utilities.mappers.IModelMapperService;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.CartRepository;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.OrderRepository;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.ProductRepository;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos.CartAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos.CartUpdateRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.cartResponseDtos.CartResponseDto;
import enoca.javaChallenge.shoppingCart.models.entities.Cart;
import enoca.javaChallenge.shoppingCart.models.entities.Order;
import enoca.javaChallenge.shoppingCart.models.entities.Product;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartManager implements ICartService {

	private final CartRepository cartRepository;
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final IModelMapperService modelMapperService;
	private final ICartRules cartRules;

	@Override
	public Response<CartResponseDto> update(CartUpdateRequestDto updateRequestDto) {

		try {
			this.cartRules.CustomerIsPresent(updateRequestDto.getCustomerId());
			this.cartRules.OrderIsPresent(updateRequestDto.getOrderId());
			this.cartRules.ProductIsPresent(updateRequestDto.getProductId());
			this.cartRules.ProductCountCanNotBeNegative(updateRequestDto.getProductCount());
			Cart cart = this.modelMapperService.forRequest().map(updateRequestDto, Cart.class);
			Product product = this.productRepository.getById(updateRequestDto.getProductId());
			double totalPrice = (double) cart.getProductCount() * (double) product.getPrice();
			cart.setTotalPrice(totalPrice);
			this.cartRepository.save(cart);
			CartResponseDto data = this.modelMapperService.forResponse().map(cart, CartResponseDto.class);

			Response<CartResponseDto> response = new Response<CartResponseDto>();
			response.setData(data);
			response.setMessage("Sepet güncellendi.");
			response.setStatusCode(HttpStatus.OK);
			return response;
		} catch (Exception e) {
			Response<CartResponseDto> response = new Response<CartResponseDto>();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response;
		}

	}

	@Override
	public Response<List<CartResponseDto>> getCustomerCart(int customerId) {

		try {
			this.cartRules.CustomerIsPresent(customerId);
			List<Cart> carts = this.cartRepository.getByCustomer(customerId);
			List<CartResponseDto> data = carts.stream()
					.map(x -> this.modelMapperService.forResponse().map(x, CartResponseDto.class))
					.collect(Collectors.toList());

			Response<List<CartResponseDto>> response = new Response<List<CartResponseDto>>();
			response.setData(data);
			response.setStatusCode(HttpStatus.OK);
			return response;
		} catch (Exception e) {
			Response<List<CartResponseDto>> response = new Response<List<CartResponseDto>>();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response;
		}

	}

	@Override
	public Response<CartResponseDto> add(CartAddRequestDto addRequestDto) {

		try {
			this.cartRules.CustomerIsPresent(addRequestDto.getCustomerId());
			this.cartRules.OrderIsPresent(addRequestDto.getOrderId());
			this.cartRules.ProductIsPresent(addRequestDto.getProductId());
			this.cartRules.ProductCountCanNotBeNegative(addRequestDto.getProductCount());
			Cart cart = this.modelMapperService.forRequest().map(addRequestDto, Cart.class);
			Product product = this.productRepository.getById(addRequestDto.getProductId());
			Order order = this.orderRepository.getById(addRequestDto.getOrderId());
			double totalPrice = (double) cart.getProductCount() * (double) product.getPrice();
			cart.setTotalPrice(totalPrice);
			if (order != null) {
				order.getCarts().add(cart);
			}
			this.cartRepository.save(cart);

			Response<CartResponseDto> response = new Response<CartResponseDto>();
			response.setMessage("Ürün sepete eklendi.");
			response.setStatusCode(HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			Response<CartResponseDto> response = new Response<CartResponseDto>();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response;
		}

	}

	@Override
	public Response<List<CartResponseDto>> getAll() {

		List<Cart> carts = this.cartRepository.findAll();
		List<CartResponseDto> data = carts.stream()
				.map(x -> this.modelMapperService.forResponse().map(x, CartResponseDto.class))
				.collect(Collectors.toList());

		Response<List<CartResponseDto>> response = new Response<List<CartResponseDto>>();
		response.setData(data);
		response.setStatusCode(HttpStatus.OK);
		return response;
	}

	@Override
	public Response<CartResponseDto> deleteAllProduct(int id) {

		try {
			Cart cart = this.cartRepository.getById(id);
			this.cartRules.CartIsPresent(cart);
			this.cartRepository.delete(cart);
			Response<CartResponseDto> response = new Response<CartResponseDto>();
			response.setMessage("Ürün sepetten kaldırıldı.");
			return response;
		} catch (Exception e) {
			Response<CartResponseDto> response = new Response<CartResponseDto>();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response;
		}

	}

	@Override
	public Response<CartResponseDto> decreaseProductCount(int id) {

		try {
			Cart cart = this.cartRepository.getById(id);
			int newProductCount = cart.getProductCount() - 1;
			this.cartRules.ProductCountCanNotBeNegative(newProductCount);
			double newTotalPrice = cart.getTotalPrice() - cart.getProduct().getPrice();
			cart.setProductCount(newProductCount);
			cart.setTotalPrice(newTotalPrice);
			this.cartRepository.save(cart);

			Response<CartResponseDto> response = new Response<CartResponseDto>();
			response.setMessage("Ürün miktarı azaltıldı.");
			response.setStatusCode(HttpStatus.OK);
			return response;
		} catch (Exception e) {
			Response<CartResponseDto> response = new Response<CartResponseDto>();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response;
		}

	}

	@Override
	public Response<CartResponseDto> increaseProductCount(int id) {

		Cart cart = this.cartRepository.getById(id);
		int newProductCount = cart.getProductCount() + 1;
		double newTotalPrice = cart.getTotalPrice() + cart.getProduct().getPrice();
		cart.setProductCount(newProductCount);
		cart.setTotalPrice(newTotalPrice);
		this.cartRepository.save(cart);

		Response<CartResponseDto> response = new Response<CartResponseDto>();
		response.setMessage("Ürün miktarı arttırıldı.");
		response.setStatusCode(HttpStatus.OK);
		return response;
	}

}
