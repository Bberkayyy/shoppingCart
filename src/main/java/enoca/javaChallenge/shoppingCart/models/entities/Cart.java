package enoca.javaChallenge.shoppingCart.models.entities;

import enoca.javaChallenge.shoppingCart.core.persistence.entityBaseModel.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "carts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
public class Cart extends Entity<Integer> {

	@Column(name="productCount")
	private int productCount;
	@Column(name="totalPrice")
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

}
