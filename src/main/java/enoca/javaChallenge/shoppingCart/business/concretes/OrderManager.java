package enoca.javaChallenge.shoppingCart.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import enoca.javaChallenge.shoppingCart.business.abstracts.IOrderService;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.core.utilities.mappers.IModelMapperService;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.OrderRepository;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.orderRequestDtos.PlaceOrderRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.orderResponseDtos.OrderResponseDto;
import enoca.javaChallenge.shoppingCart.models.entities.Order;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderManager implements IOrderService {

	private final OrderRepository orderRepository;
	private final IModelMapperService modelMapperService;

	@Override
	public Response<OrderResponseDto> placeOrder(PlaceOrderRequestDto placeRequestDto) {

		Order order = this.modelMapperService.forRequest().map(placeRequestDto, Order.class);
		order.setCreatedDate(LocalDateTime.now());
		order.setActive(true);
		this.orderRepository.save(order);
		OrderResponseDto data = this.modelMapperService.forResponse().map(order, OrderResponseDto.class);

		Response<OrderResponseDto> response = new Response<OrderResponseDto>();
		response.setData(data);
		response.setStatusCode(HttpStatus.CREATED);
		return response;
	}

	@Override
	public Response<List<OrderResponseDto>> getAll() {

		List<Order> orders = this.orderRepository.findAll();
		List<OrderResponseDto> data = orders.stream()
				.map(x -> this.modelMapperService.forResponse().map(x, OrderResponseDto.class))
				.collect(Collectors.toList());

		Response<List<OrderResponseDto>> response = new Response<List<OrderResponseDto>>();
		response.setData(data);
		response.setStatusCode(HttpStatus.OK);
		return response;
	}

	@Override
	public Response<OrderResponseDto> isActiveToFalse(int id) {

		Order order = this.orderRepository.getById(id);
		order.setActive(false);
		order.setClosingDate(LocalDateTime.now());
		this.orderRepository.save(order);
		OrderResponseDto data = this.modelMapperService.forResponse().map(order, OrderResponseDto.class);

		Response<OrderResponseDto> response = new Response<OrderResponseDto>();
		response.setData(data);
		response.setMessage("Sipariş kapatıldı.");
		response.setStatusCode(HttpStatus.OK);
		return response;

	}

	@Override
	public Response<OrderResponseDto> isActiveToTrue(int id) {

		Order order = this.orderRepository.getById(id);
		order.setActive(true);
		order.setClosingDate(null);
		this.orderRepository.save(order);
		OrderResponseDto data = this.modelMapperService.forResponse().map(order, OrderResponseDto.class);

		Response<OrderResponseDto> response = new Response<OrderResponseDto>();
		response.setData(data);
		response.setMessage("Sipariş tekrar aktif edildi.");
		response.setStatusCode(HttpStatus.OK);
		return response;
	}

	@Override
	public Response<OrderResponseDto> get(int id) {

		Order order = this.orderRepository.getById(id);
		OrderResponseDto data = this.modelMapperService.forResponse().map(order, OrderResponseDto.class);

		Response<OrderResponseDto> response = new Response<OrderResponseDto>();
		response.setData(data);
		response.setStatusCode(HttpStatus.OK);
		return null;
	}

	@Override
	public Response<List<OrderResponseDto>> getByCustomer(int customerId) {

		List<Order> orders = this.orderRepository.getByCustomer(customerId);
		List<OrderResponseDto> data = orders.stream()
				.map(x -> this.modelMapperService.forResponse().map(x, OrderResponseDto.class))
				.collect(Collectors.toList());
		
		Response<List<OrderResponseDto>> response = new Response<List<OrderResponseDto>>();
		response.setData(data);
		response.setStatusCode(HttpStatus.OK);
		return response;
	}

	@Override
	public Response<List<OrderResponseDto>> getByCustomerAndIsActiveFalse(int customerId) {

		List<Order> orders = this.orderRepository.getByCustomerAndIsActive(customerId);
		List<OrderResponseDto> data = orders.stream()
				.map(x -> this.modelMapperService.forResponse().map(x, OrderResponseDto.class))
				.collect(Collectors.toList());
		
		Response<List<OrderResponseDto>> response = new Response<List<OrderResponseDto>>();
		response.setData(data);
		response.setStatusCode(HttpStatus.OK);
		return response;
	}

}
