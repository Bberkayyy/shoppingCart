package enoca.javaChallenge.shoppingCart.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import enoca.javaChallenge.shoppingCart.models.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

//	@Query("From Cart where customer.id=:customerId")
//	List<Cart> getByCustomer(int customerId);
	
	Cart getByProduct_IdAndOrder_Id(int productId, int orderId);
}
