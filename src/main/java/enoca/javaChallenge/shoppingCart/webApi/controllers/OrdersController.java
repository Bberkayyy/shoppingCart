package enoca.javaChallenge.shoppingCart.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import enoca.javaChallenge.shoppingCart.business.abstracts.IOrderService;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.orderRequestDtos.PlaceOrderRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.orderResponseDtos.OrderResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orders/")
@AllArgsConstructor
public class OrdersController {

	private final IOrderService orderService;

	@GetMapping(value = "getall", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<List<OrderResponseDto>> getAll() {
		return this.orderService.getAll();
	}
	@GetMapping(value = "getactiveorders", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<List<OrderResponseDto>> getAllByIsActiveTrue(){
		return this.orderService.getAllByIsActiveTrue();
	}

	@PostMapping(value = "placeOrder", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Response<OrderResponseDto> placeOrder(@Valid @RequestBody PlaceOrderRequestDto requestDto) {
		return this.orderService.placeOrder(requestDto);
	}

	@GetMapping(value = "isActiveToFalse", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<OrderResponseDto> isActiveToFalse(int id) {
		return this.orderService.isActiveToFalse(id);
	}

//	@GetMapping(value="isActiveToTrue")
//  @ResponseStatus(HttpStatus.OK)
//	public Response<OrderResponseDto> isActiveToTrue(@PathVariable int id) {
//		return this.orderService.isActiveToTrue(id);
//	}

	@GetMapping(value = "getbyid", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<OrderResponseDto> get(int id) {
		return this.orderService.get(id);
	}
	
	@DeleteMapping(value = "delete", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<OrderResponseDto> delete(int id) {
		return this.orderService.delete(id);
	}

	@GetMapping(value = "getByCustomerId", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<List<OrderResponseDto>> getByCustomerId(int customerId) {
		return this.orderService.getByCustomer(customerId);
	}

	@GetMapping(value = "getByCustomerOrderHistory", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<List<OrderResponseDto>> getByCustomerAndIsActiveFalse(int customerId) {
		return this.orderService.getByCustomerAndIsActiveFalse(customerId);
	}
}
