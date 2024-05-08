package enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.cartRequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartAddRequestDto {

	private int customerId;
	private int productId;
	private int orderId;
	private int productCount;	
}
