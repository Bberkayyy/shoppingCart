package enoca.javaChallenge.shoppingCart.business.businessRules.abstracts;

import enoca.javaChallenge.shoppingCart.core.crossCuttingConcerns.exceptions.BusinessException;
import enoca.javaChallenge.shoppingCart.models.entities.Customer;

public interface ICustomerRules {

	void CustomerEmailMustBeUnique(String email) throws BusinessException;
	void CustomerIsPresent(Customer customer) throws BusinessException;
}
