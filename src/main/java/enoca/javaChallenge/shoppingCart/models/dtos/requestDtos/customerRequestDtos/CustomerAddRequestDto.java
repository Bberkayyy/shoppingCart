package enoca.javaChallenge.shoppingCart.models.dtos.requestDtos.customerRequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddRequestDto {

	private String firstName;
	private String lastName;
	private String email;
}
