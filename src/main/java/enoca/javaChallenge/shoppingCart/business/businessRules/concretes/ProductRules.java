package enoca.javaChallenge.shoppingCart.business.businessRules.concretes;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;

import enoca.javaChallenge.shoppingCart.business.businessRules.abstracts.IProductRules;
import enoca.javaChallenge.shoppingCart.core.crossCuttingConcerns.exceptions.BusinessException;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.ProductRepository;
import enoca.javaChallenge.shoppingCart.models.entities.Product;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductRules implements IProductRules {

	private final ProductRepository productRepository;

	@Override
	public void ProductNameMustBeUnique(String productName) throws BusinessException {

		Product product = this.productRepository.getByName(productName);
		if (product != null) {
			throw new BusinessException(MessageFormat.format("Ürün ismi benzersiz olmalıdır! ({0})", productName));
		}
	}

	@Override
	public void ProductIsPresent(Product product) throws BusinessException {

		if (product == null) {
			throw new BusinessException("Ürün bulunamadı.");
		}
	}

	@Override
	public void ProductPriceCanNotBeNegative(double price) throws BusinessException {

		if (price <= 0) {
			throw new BusinessException(MessageFormat.format("Lütfen geçerli bir ürün fiyatı giriniz. ({0})", price));
		}
	}

	@Override
	public void ProductStockCanNotBeNegative(int stock) throws BusinessException {

		if (stock < 0) {
			throw new BusinessException(MessageFormat.format("Ürün stoğu negatif değer olamaz! ({0})", stock));
		}
	}

	@Override
	public void UpdateRequestProductNameIsNotSameCurrentProductName(String productNameToBeUpdate)
			throws BusinessException {

		Product product = this.productRepository.getByName(productNameToBeUpdate);
		if (product == null) {
			ProductNameMustBeUnique(productNameToBeUpdate);
		}
	}

}
