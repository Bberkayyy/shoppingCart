package enoca.javaChallenge.shoppingCart.business.businessRules.abstracts;

import enoca.javaChallenge.shoppingCart.core.crossCuttingConcerns.exceptions.BusinessException;

public interface IOrderRules {

	void CustomerIsPresent(int customerId) throws BusinessException;
}
