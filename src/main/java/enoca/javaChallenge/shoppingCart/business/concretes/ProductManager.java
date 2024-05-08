package enoca.javaChallenge.shoppingCart.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import enoca.javaChallenge.shoppingCart.business.abstracts.IProductService;
import enoca.javaChallenge.shoppingCart.business.businessRules.abstracts.IProductRules;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.core.utilities.mappers.IModelMapperService;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.ProductRepository;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.productRequestDtos.ProductAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.productRequestDtos.ProductUpdateRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.productResponseDtos.ProductResponseDto;
import enoca.javaChallenge.shoppingCart.models.entities.Product;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements IProductService {

	private final ProductRepository productRepository;
	private final IModelMapperService modelMapperService;
	private final IProductRules productRules;

	@Override
	public Response<ProductResponseDto> add(ProductAddRequestDto addRequestDto) {

		try {
			this.productRules.ProductNameMustBeUnique(addRequestDto.getName());
			this.productRules.ProductPriceCanNotBeNegative(addRequestDto.getPrice());
			this.productRules.ProductStockCanNotBeNegative(addRequestDto.getStock());
			Product product = this.modelMapperService.forRequest().map(addRequestDto, Product.class);
			this.productRepository.save(product);
			ProductResponseDto data = this.modelMapperService.forResponse().map(product, ProductResponseDto.class);

			Response<ProductResponseDto> response = new Response<ProductResponseDto>();
			response.setData(data);
			response.setMessage("Ürün eklendi.");
			response.setStatusCode(HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			Response<ProductResponseDto> response = new Response<ProductResponseDto>();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response;
		}

	}

	@Override
	public Response<ProductResponseDto> update(ProductUpdateRequestDto updateRequestDto) {

		try {
			this.productRules.UpdateRequestProductNameIsNotSameCurrentProductName(updateRequestDto.getName());
			this.productRules.ProductPriceCanNotBeNegative(updateRequestDto.getPrice());
			this.productRules.ProductStockCanNotBeNegative(updateRequestDto.getStock());
			Product product = this.modelMapperService.forRequest().map(updateRequestDto, Product.class);
			this.productRepository.save(product);
			ProductResponseDto data = this.modelMapperService.forResponse().map(product, ProductResponseDto.class);

			Response<ProductResponseDto> response = new Response<ProductResponseDto>();
			response.setData(data);
			response.setMessage("Ürün güncellendi.");
			response.setStatusCode(HttpStatus.OK);
			return response;
		} catch (Exception e) {
			Response<ProductResponseDto> response = new Response<ProductResponseDto>();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response;
		}

	}

	@Override
	public Response<ProductResponseDto> delete(int id) {

		try {
			Product product = this.productRepository.getById(id);
			this.productRules.ProductIsPresent(product);
			productRepository.delete(product);
			ProductResponseDto data = this.modelMapperService.forResponse().map(product, ProductResponseDto.class);

			Response<ProductResponseDto> response = new Response<ProductResponseDto>();
			response.setData(data);
			response.setMessage("Ürün silindi.");
			response.setStatusCode(HttpStatus.OK);
			return response;
		} catch (Exception e) {
			Response<ProductResponseDto> response = new Response<ProductResponseDto>();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response;
		}

	}

	@Override
	public Response<List<ProductResponseDto>> getAll() {

		List<Product> products = this.productRepository.findAll();
		List<ProductResponseDto> data = products.stream()
				.map(x -> this.modelMapperService.forResponse().map(x, ProductResponseDto.class))
				.collect(Collectors.toList());

		Response<List<ProductResponseDto>> response = new Response<List<ProductResponseDto>>();
		response.setData(data);
		response.setStatusCode(HttpStatus.OK);
		return response;
	}

	@Override
	public Response<ProductResponseDto> get(int id) {

		try {
			Product product = this.productRepository.getById(id);
			this.productRules.ProductIsPresent(product);
			ProductResponseDto data = this.modelMapperService.forResponse().map(product, ProductResponseDto.class);

			Response<ProductResponseDto> response = new Response<ProductResponseDto>();
			response.setData(data);
			response.setStatusCode(HttpStatus.OK);
			return response;

		} catch (Exception e) {
			Response<ProductResponseDto> response = new Response<ProductResponseDto>();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response;
		}
	}

}
