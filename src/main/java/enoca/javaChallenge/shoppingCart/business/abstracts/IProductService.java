package enoca.javaChallenge.shoppingCart.business.abstracts;

import java.util.List;

import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.productRequestDtos.ProductAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.productRequestDtos.ProductUpdateRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.productResponseDtos.ProductResponseDto;

public interface IProductService {

	Response<ProductResponseDto> add(ProductAddRequestDto addRequestDto);
	Response<ProductResponseDto> update (ProductUpdateRequestDto updateRequestDto);
	Response<ProductResponseDto> delete(int id);
	Response<List<ProductResponseDto>> getAll();
	Response<ProductResponseDto> get(int id);
}
