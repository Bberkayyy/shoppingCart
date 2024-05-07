package enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.productResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseForCartDto {

	private int id;
	private String name;
	private double price;
}
