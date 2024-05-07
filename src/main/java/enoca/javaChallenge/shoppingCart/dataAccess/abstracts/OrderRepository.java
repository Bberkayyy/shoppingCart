package enoca.javaChallenge.shoppingCart.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import enoca.javaChallenge.shoppingCart.models.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("From Order where customer.id=:customerId")
	List<Order> getByCustomer(int customerId);
	
	@Query("From Order where customer.id=:customerId and isActive = false")
	List<Order> getByCustomerAndIsActive(int customerId);
}
