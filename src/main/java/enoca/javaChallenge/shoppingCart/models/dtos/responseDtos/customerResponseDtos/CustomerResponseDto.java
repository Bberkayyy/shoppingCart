package enoca.javaChallenge.shoppingCart.models.dtos.responseDtos.customerResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
}
