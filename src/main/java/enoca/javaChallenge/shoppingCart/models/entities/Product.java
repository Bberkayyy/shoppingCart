package enoca.javaChallenge.shoppingCart.models.entities;

import java.util.ArrayList;
import java.util.List;

import enoca.javaChallenge.shoppingCart.core.persistence.entityBaseModel.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@jakarta.persistence.Entity
public class Product extends Entity<Integer> {

	public Product(String name, int stock, double price) {
		super();
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.carts = new ArrayList<>();
	}

	@Column(name = "name")
	private String name;
	@Column(name = "stock")
	private int stock;
	@Column(name = "price")
	private double price;

	@OneToMany(mappedBy = "product")
	private List<Cart> carts;

}
