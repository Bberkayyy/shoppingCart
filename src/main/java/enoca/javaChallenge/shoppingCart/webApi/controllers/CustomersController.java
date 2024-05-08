package enoca.javaChallenge.shoppingCart.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import enoca.javaChallenge.shoppingCart.business.abstracts.ICustomerService;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.customerRequestDtos.CustomerAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.customerResponseDtos.CustomerResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/customers/")
@AllArgsConstructor
public class CustomersController {

	private final ICustomerService customerService;

	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Response<CustomerResponseDto> add(@Valid @RequestBody CustomerAddRequestDto addRequestDto) {
		return this.customerService.add(addRequestDto);
	}

	@DeleteMapping(value = "delete", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<CustomerResponseDto> delete(int id) {
		return this.customerService.delete(id);
	}

	@GetMapping(value = "getall", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<List<CustomerResponseDto>> getAll() {
		return this.customerService.getAll();
	}
}
