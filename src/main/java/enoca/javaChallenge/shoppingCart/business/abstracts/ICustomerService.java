package enoca.javaChallenge.shoppingCart.business.abstracts;

import java.util.List;

import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.customerRequestDtos.CustomerAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.customerResponseDtos.CustomerResponseDto;

public interface ICustomerService {

	Response<List<CustomerResponseDto>> getAll();
	Response<CustomerResponseDto> add(CustomerAddRequestDto addRequestDto);
	Response<CustomerResponseDto> delete(int id);
}
