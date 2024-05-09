package enoca.javaChallenge.shoppingCart.business.abstracts;

import java.util.List;

import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos.CartAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos.CartUpdateRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.cartResponseDtos.CartResponseDto;

public interface ICartService {

	Response<CartResponseDto> add(CartAddRequestDto addRequestDto);
//	Response<CartResponseDto> update (CartUpdateRequestDto updateRequestDto);
//	Response<List<CartResponseDto>> getCustomerCart(int customerId);
	Response<List<CartResponseDto>> getAll();
	Response<CartResponseDto> deleteAllProduct(int id);
	Response<CartResponseDto> decreaseProductCount(int id);
	Response<CartResponseDto> increaseProductCount(int id);
}
