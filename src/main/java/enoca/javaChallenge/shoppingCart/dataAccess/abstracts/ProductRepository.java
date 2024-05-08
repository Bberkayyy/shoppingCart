package enoca.javaChallenge.shoppingCart.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import enoca.javaChallenge.shoppingCart.models.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product getByName(String name);
}
