package enoca.javaChallenge.shoppingCart.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import enoca.javaChallenge.shoppingCart.business.abstracts.ICustomerService;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.core.utilities.mappers.IModelMapperService;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.CustomerRepository;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.customerRequestDtos.CustomerAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.customerResponseDtos.CustomerResponseDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.productResponseDtos.ProductResponseDto;
import enoca.javaChallenge.shoppingCart.models.entities.Customer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerManager implements ICustomerService {

	private final CustomerRepository customerRepository;
	private final IModelMapperService modelmapperService;

	@Override
	public Response<CustomerResponseDto> add(CustomerAddRequestDto addRequestDto) {

		Customer customer = this.modelmapperService.forRequest().map(addRequestDto, Customer.class);
		this.customerRepository.save(customer);
		CustomerResponseDto data = this.modelmapperService.forResponse().map(customer, CustomerResponseDto.class);

		Response<CustomerResponseDto> response = new Response<CustomerResponseDto>();
		response.setData(data);
		response.setMessage("Müşteri eklendi.");
		response.setStatusCode(HttpStatus.OK);
		return response;
	}

	@Override
	public Response<CustomerResponseDto> delete(int id) {

		Customer customer = this.customerRepository.getById(id);
		customerRepository.delete(customer);
		CustomerResponseDto data = this.modelmapperService.forResponse().map(customer, CustomerResponseDto.class);

		Response<CustomerResponseDto> response = new Response<CustomerResponseDto>();
		response.setData(data);
		response.setMessage("Müşteri silindi.");
		response.setStatusCode(HttpStatus.OK);
		return response;
	}

	@Override
	public Response<List<CustomerResponseDto>> getAll() {

		List<Customer> customers = this.customerRepository.findAll();
		List<CustomerResponseDto> data = customers.stream()
				.map(x -> this.modelmapperService.forResponse().map(x, CustomerResponseDto.class))
				.collect(Collectors.toList());

		Response<List<CustomerResponseDto>> response = new Response<List<CustomerResponseDto>>();
		response.setData(data);
		response.setStatusCode(HttpStatus.OK);
		return response;

	}

}
