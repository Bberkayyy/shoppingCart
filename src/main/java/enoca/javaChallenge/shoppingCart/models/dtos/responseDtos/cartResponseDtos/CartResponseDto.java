package enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.cartResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {

	private int id;
	private String productName;
	private int productCount;
	private double totalPrice;
	private String orderCustomerEmail;
}
