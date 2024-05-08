package enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.productResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseForOrderDto {

	private String name;
	private double price;
}
