package enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.orderResponseDtos;

import java.time.LocalDateTime;
import java.util.List;

import enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.cartResponseDtos.CartResponseForOrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

	private int id;
	private LocalDateTime createdDate;
	private LocalDateTime closingDate;
	private boolean isActive;
	private String customerEmail;
	private double totalAmount;
	private List<CartResponseForOrderDto> carts;
}
