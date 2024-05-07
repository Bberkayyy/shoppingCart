package enoca.javaChallenge.shoppingCart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.CartRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

	private final CartRepository cartRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
