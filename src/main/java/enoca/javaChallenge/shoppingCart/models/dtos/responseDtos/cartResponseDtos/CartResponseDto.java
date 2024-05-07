package enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.cartResponseDtos;

import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.productResponseDtos.ProductResponseForCartDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {

	private int id;
	private int productCount;
	private double totalPrice;
	private ProductResponseForCartDto product;
	private String customerFirst_Name;
}
