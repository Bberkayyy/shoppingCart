package enoca.javaChallenge.shoppingCart.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import enoca.javaChallenge.shoppingCart.models.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	@Query("From Cart where customer.id=:customerId")
	List<Cart> getByCustomer(int customerId);
}
