package enoca.javaChallenge.shoppingCart.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import enoca.javaChallenge.shoppingCart.business.abstracts.ICartService;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos.CartAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos.CartUpdateRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.cartResponseDtos.CartResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/carts/")
@AllArgsConstructor
public class CartsController {

	private final ICartService cartService;

	@PostMapping(value = "addtocart", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Response<CartResponseDto> add(@Valid @RequestBody CartAddRequestDto addRequestDto) {
		return this.cartService.add(addRequestDto);
	}

	@GetMapping(value = "getall", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<List<CartResponseDto>> getAll() {
		return this.cartService.getAll();
	}

	@DeleteMapping(value = "deletefromcart", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<CartResponseDto> deleteAllProduct(int id) {
		return this.cartService.deleteAllProduct(id);
	}

	@GetMapping(value = "decreaseproductcount", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<CartResponseDto> decreseProductCount(int id) {
		return this.cartService.decreaseProductCount(id);
	}

	@GetMapping(value = "increaseproductcount", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<CartResponseDto> increaseProductCount(int id) {
		return this.cartService.increaseProductCount(id);
	}
}
