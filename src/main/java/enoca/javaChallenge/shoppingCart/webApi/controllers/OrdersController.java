package enoca.javaChallenge.shoppingCart.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enoca.javaChallenge.shoppingCart.business.abstracts.IOrderService;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.orderRequestDtos.PlaceOrderRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.orderResponseDtos.OrderResponseDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orders/")
@AllArgsConstructor
public class OrdersController {

	private final IOrderService orderService;

	@GetMapping("getall")
	public Response<List<OrderResponseDto>> getAll() {
		return this.orderService.getAll();
	}

	@PostMapping("placeOrder")
	public Response<OrderResponseDto> placeOrder(PlaceOrderRequestDto requestDto) {
		return this.orderService.placeOrder(requestDto);
	}

	@GetMapping("isActiveToFalse")
	public Response<OrderResponseDto> isActiveToFalse(int id) {
		return this.orderService.isActiveToFalse(id);
	}

	@GetMapping("isActiveToTrue")
	public Response<OrderResponseDto> isActiveToTrue(int id) {
		return this.orderService.isActiveToTrue(id);
	}

	@GetMapping("getbyid")
	public Response<OrderResponseDto> get(int id) {
		return this.orderService.get(id);
	}

	@GetMapping("getByCustomerId")
	public Response<List<OrderResponseDto>> getByCustomerId(int customerId) {
		return this.orderService.getByCustomer(customerId);
	}
	@GetMapping("getByCustomerIdAndIsActiveFalse")
	public Response<List<OrderResponseDto>> getByCustomerAndIsActiveFalse(int customerId){
		return this.orderService.getByCustomerAndIsActiveFalse(customerId);
	}
}
