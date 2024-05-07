package enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.productResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

	private int id;
	private String name;
	private int stock;
	private double price;
}
