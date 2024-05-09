package enoca.javaChallenge.shoppingCart.business.businessRules.concretes;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import enoca.javaChallenge.shoppingCart.business.businessRules.abstracts.IOrderRules;
import enoca.javaChallenge.shoppingCart.core.crossCuttingConcerns.exceptions.BusinessException;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.CustomerRepository;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.OrderRepository;
import enoca.javaChallenge.shoppingCart.models.entities.Customer;
import enoca.javaChallenge.shoppingCart.models.entities.Order;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderRules implements IOrderRules {

	private final CustomerRepository customerRepository;
	private final OrderRepository orderRepository;

	@Override
	public void CustomerIsPresent(int customerId) throws BusinessException {

		Customer customer = this.customerRepository.getReferenceById(customerId);
		if (customer == null)
			throw new BusinessException(MessageFormat.format("Girilen id ({0}) değerine ait müşteri bulunamadı.",customerId));
	}

	@Override
	public void OrderListByCustomer(int customerId) throws BusinessException {

		List<Order> orders = this.orderRepository.getByCustomer(customerId);
		if (orders != null && !orders.isEmpty()) {
			for (Order order : orders)
				if (order.getClosingDate() == null) {
					throw new BusinessException(MessageFormat.format(
							"Kapatılmamış siparişiniz mevcut({0}). Yeni bir sipariş eklemek için siparişinizi kapatmanız gerekmektedir.",
							order.getId()));
				}
		}
	}

	@Override
	public void OrderIsPresent(int id) throws BusinessException {
		
		Order order = this.orderRepository.getReferenceById(id);
		if(order == null) {
			throw new BusinessException("Sipariş bulunamadı.");
		}
	}
}
