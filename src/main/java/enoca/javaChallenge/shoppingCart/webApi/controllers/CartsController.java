package enoca.javaChallenge.shoppingCart.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enoca.javaChallenge.shoppingCart.business.abstracts.ICartService;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos.CartAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos.CartUpdateRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.cartResponseDtos.CartResponseDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/carts/")
@AllArgsConstructor
public class CartsController {

	private final ICartService cartService;

	@PutMapping("update")
	public Response<CartResponseDto> update(CartUpdateRequestDto updateRequestDto) {
		return this.cartService.update(updateRequestDto);
	}

	@GetMapping("getcustomerscart")
	public Response<List<CartResponseDto>> getCustomerCart(int customerId) {
		return this.cartService.getCustomerCart(customerId);
	}
	@PostMapping("addtocart")
	public Response<CartResponseDto> add(CartAddRequestDto addRequestDto){
		return this.cartService.add(addRequestDto);
	}
	@GetMapping("getall")
	public Response<List<CartResponseDto>> getAll(){
		return this.cartService.getAll();
	}
	@DeleteMapping("deletefromcart")
	public Response<CartResponseDto> deleteAllProduct(int id){
		return this.cartService.deleteAllProduct(id);
	}
	@GetMapping("decreseproductcount")
	public Response<CartResponseDto> decreseProductCount(int id){
		return this.cartService.decreseProductCount(id);
	}
}
