package enoca.javaChallenge.shoppingCart.business.businessRules.abstracts;

import enoca.javaChallenge.shoppingCart.core.crossCuttingConcerns.exceptions.BusinessException;
import enoca.javaChallenge.shoppingCart.models.entities.Cart;

public interface ICartRules {

	void ProductCanNotAddToCartIfStockIs0 (int id) throws BusinessException;
	void OrderIsPresent(int id) throws BusinessException;
	void ProductIsPresent(int id) throws BusinessException;
	void CustomerIsPresent(int id) throws BusinessException;
	void ProductCountCanNotBeNegative(int count) throws BusinessException;
	void CartIsPresent(Cart cart) throws BusinessException;
}
