package enoca.javaChallenge.shoppingCart.models.entities;

import java.time.LocalDateTime;

import enoca.javaChallenge.shoppingCart.core.persistence.entityBaseModel.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
public class Order extends Entity<Integer>{

	@Column(name="createdDate")
	private LocalDateTime createdDate;
	@Column(name="closingDate")
	private LocalDateTime closingDate;
	@Column(name="isActive")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
}
