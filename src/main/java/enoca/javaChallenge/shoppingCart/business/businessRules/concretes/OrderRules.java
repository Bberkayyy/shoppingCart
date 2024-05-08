package enoca.javaChallenge.shoppingCart.business.businessRules.concretes;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;

import enoca.javaChallenge.shoppingCart.business.businessRules.abstracts.IOrderRules;
import enoca.javaChallenge.shoppingCart.core.crossCuttingConcerns.exceptions.BusinessException;
import enoca.javaChallenge.shoppingCart.dataAccess.abstracts.CustomerRepository;
import enoca.javaChallenge.shoppingCart.models.entities.Customer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderRules implements IOrderRules{

	private final CustomerRepository customerRepository;

	@Override
	public void CustomerIsPresent(int id) throws BusinessException {
		
		Customer customer = this.customerRepository.getReferenceById(id);
		if(customer == null) 
			throw new BusinessException("mesaj");
	}
}
//MessageFormat.format("Girilen id({0}) değerine ait müşteri bulunamadı. Lütfen geçerli bir müşteri id giriniz.", id)

