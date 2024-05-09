package enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartUpdateRequestDto {

	private int id;
	private int productCount;
	private int productId;
	private int orderId;
}
