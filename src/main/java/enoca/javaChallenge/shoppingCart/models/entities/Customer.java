package enoca.javaChallenge.shoppingCart.models.entities;

import java.util.List;

import enoca.javaChallenge.shoppingCart.core.persistence.entityBaseModel.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
public class Customer extends Entity<Integer> {

	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;

	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	@OneToOne(mappedBy = "customer")
	private Cart cart;
}
