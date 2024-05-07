package enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.orderResponseDtos;

import java.time.LocalDateTime;

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
	private String customerFirst_Name;
}
