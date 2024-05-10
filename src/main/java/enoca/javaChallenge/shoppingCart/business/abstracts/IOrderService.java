package enoca.javaChallenge.shoppingCart.business.abstracts;

import java.util.List;

import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.orderRequestDtos.PlaceOrderRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.orderResponseDtos.OrderResponseDto;

public interface IOrderService {

	Response<OrderResponseDto> placeOrder(PlaceOrderRequestDto placeRequestDto);

	Response<List<OrderResponseDto>> getAll();
	
	Response<List<OrderResponseDto>> getAllByIsActiveTrue();

	Response<OrderResponseDto> get(int id);

	Response<OrderResponseDto> delete(int id);

	Response<List<OrderResponseDto>> getByCustomerAndIsActiveFalse(int customerId);

	Response<List<OrderResponseDto>> getByCustomer(int customerId);

	Response<OrderResponseDto> isActiveToFalse(int id);

}
