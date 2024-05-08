package enoca.javaChallenge.shoppingCart.business.businessRules.abstracts;

import enoca.javaChallenge.shoppingCart.core.crossCuttingConcerns.exceptions.BusinessException;
import enoca.javaChallenge.shoppingCart.models.entities.Product;

public interface IProductRules {

	void ProductNameMustBeUnique(String productName) throws BusinessException;
	void ProductIsPresent(Product product) throws BusinessException;
	void ProductPriceCanNotBeNegative(double price) throws BusinessException;
	void ProductStockCanNotBeNegative(int stock) throws BusinessException;
	void UpdateRequestProductNameIsNotSameCurrentProductName(String productNameToBeUpdate) throws BusinessException;
}
