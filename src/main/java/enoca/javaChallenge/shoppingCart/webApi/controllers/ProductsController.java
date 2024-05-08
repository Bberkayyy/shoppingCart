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

import enoca.javaChallenge.shoppingCart.business.abstracts.IProductService;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.productRequestDtos.ProductAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.productRequestDtos.ProductUpdateRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.productResponseDtos.ProductResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products/")
public class ProductsController {

	private IProductService productService;

	@GetMapping(value = "getall", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<List<ProductResponseDto>> getAll() {
		return productService.getAll();
	}

	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Response<ProductResponseDto> add(@Valid @RequestBody ProductAddRequestDto addRequestDto) {
		return productService.add(addRequestDto);
	}

	@GetMapping(value = "getbyid", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<ProductResponseDto> getById(int id) {
		return productService.get(id);
	}

	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<ProductResponseDto> update(@Valid @RequestBody ProductUpdateRequestDto updateRequestDto) {
		return productService.update(updateRequestDto);
	}

	@DeleteMapping(value = "delete", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Response<ProductResponseDto> delete(int id) {
		return productService.delete(id);
	}
}
