package enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.productRequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequestDto {

	private int id;
	private String name;
	private int stock;
	private double price;
}
