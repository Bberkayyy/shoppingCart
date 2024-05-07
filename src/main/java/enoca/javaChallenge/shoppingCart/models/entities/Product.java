package enoca.javaChallenge.shoppingCart.models.entities;



import enoca.javaChallenge.shoppingCart.core.persistence.entityBaseModel.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@jakarta.persistence.Entity
public class Product extends Entity<Integer>{

	@Column(name="name")
	private String name;
	@Column(name="stock")
	private int stock;
	@Column(name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
}
