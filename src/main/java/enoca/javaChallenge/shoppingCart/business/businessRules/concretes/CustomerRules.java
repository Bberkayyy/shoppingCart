package enoca.javaChallenge.shoppingCart.business.businessRules.concretes;

import org.springframework.stereotype.Service;

import enoca.javaChallenge.shoppingCart.business.businessRules.abstracts.ICustomerRules;
import enoca.javaChallenge.shoppingCart.core.crossCuttingConcerns.exceptions.BusinessException;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.CustomerRepository;
import enoca.javaChallenge.shoppingCart.models.entities.Customer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerRules implements ICustomerRules {

	private final CustomerRepository customerRepository;

	@Override
	public void CustomerEmailMustBeUnique(String email) throws BusinessException {

		Customer customer = this.customerRepository.getByEmail(email);
		if (customer != null) {
			throw new BusinessException("Girilen email hesabına ait kayıt bulunmaktadır. Lütfen farklı bir email adresi giriniz.");
		}
	}

	@Override
	public void CustomerIsPresent(Customer customer) throws BusinessException {

		if(customer==null) {
			throw new BusinessException("Müşteri bulunamadı.");
		}
	}

}
