package enoca.javaChallenge.shoppingCart.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enoca.javaChallenge.shoppingCart.business.abstracts.IProductService;
import enoca.javaChallenge.shoppingCart.core.shared.Response;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.productRequestDtos.ProductAddRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.productRequestDtos.ProductUpdateRequestDto;
import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.productResponseDtos.ProductResponseDto;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products/")
public class ProductsController {

	private IProductService productService;

	@GetMapping("getall")
	public Response<List<ProductResponseDto>> getAll() {
		return productService.getAll();
	}

	@PostMapping("add")
	public Response<ProductResponseDto> add(ProductAddRequestDto addRequestDto) {
		return productService.add(addRequestDto);
	}
	@GetMapping("getbyid")
	public Response<ProductResponseDto> getById(int id){
		return productService.get(id);
	}
	@PutMapping("update")
	public Response<ProductResponseDto> update(ProductUpdateRequestDto updateRequestDto){
		return productService.update(updateRequestDto);
	}
	@DeleteMapping("delete")
	public Response<ProductResponseDto> delete(int id){
		return productService.delete(id);
	}
}
