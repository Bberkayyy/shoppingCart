package enoca.javaChallenge.shoppingCart.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import enoca.javaChallenge.shoppingCart.models.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
