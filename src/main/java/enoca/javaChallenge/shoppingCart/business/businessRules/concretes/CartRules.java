package enoca.javaChallenge.shoppingCart.business.businessRules.concretes;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;

import enoca.javaChallenge.shoppingCart.business.businessRules.abstracts.ICartRules;
import enoca.javaChallenge.shoppingCart.core.crossCuttingConcerns.exceptions.BusinessException;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.OrderRepository;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.ProductRepository;
import enoca.javaChallenge.shoppingCart.models.entities.Cart;
import enoca.javaChallenge.shoppingCart.models.entities.Order;
import enoca.javaChallenge.shoppingCart.models.entities.Product;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartRules implements ICartRules {

	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;

	@Override
	public void ProductCanNotAddToCartIfStockIs0(int id) throws BusinessException {

		Product product = this.productRepository.getById(id);
		if (product.getStock() == 0) {
			throw new BusinessException("Ürün stokta mevcut değildir. Lütfen daha sonra tekrar deneyiniz.");
		}

	}

	@Override
	public void OrderIsPresent(int id) throws BusinessException {

		Order order = this.orderRepository.getById(id);
		if (order == null) {
			throw new BusinessException(
					"İşlem yapmak istediğiniz sipariş bulunamadı. İşlem yapmak için önce sipariş oluşturun.");
		}
	}

	@Override
	public void ProductIsPresent(int id) throws BusinessException {

		Product product = this.productRepository.getById(id);
		if (product != null) {
			ProductCanNotAddToCartIfStockIs0(id);
		} else {
			throw new BusinessException(MessageFormat
					.format("Girilen id({0}) değerine ait ürün bulunamadı. Lütfen geçerli bir ürün id giriniz.", id));
		}
	}

	@Override
	public void ProductCountCanNotBeNegative(int count) throws BusinessException {

		if (count <= 0) {
			throw new BusinessException(MessageFormat
					.format("Ürün miktarı en az 1 olmalıdır. Lütfen geçerli ürün miktarı giriniz. ({0})", count));
		}
	}

	@Override
	public void CartIsPresent(Cart cart) throws BusinessException {
		if (cart == null) {
			throw new BusinessException("Sepet bulunamadı!");
		}
	}

	@Override
	public void OrderCanNotBeChangedIfHasBeenClosed(int orderId) throws BusinessException {

		Order order = this.orderRepository.getById(orderId);
		if (order.getClosingDate() != null && order.isActive() == false) {
			throw new BusinessException(MessageFormat.format(
					"İşlem yapmak istediğiniz sipariş kapatılmıştır ({0}). Lütfen aktif bir sipariş seçiniz.",
					orderId));
		}
	}

}
