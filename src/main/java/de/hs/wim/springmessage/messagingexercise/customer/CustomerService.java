package de.hs.wim.springmessage.messagingexercise.customer;

import de.hs.wim.springmessage.messagingexercise.events.CustomerBlockEvent;
import de.hs.wim.springmessage.messagingexercise.events.CustomerChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;	

	public void changeLastnameOfCustomer(int customerId, String newLastname) {
		logger.info("CustomerId {} changed lastname", customerId);
		
		CustomerChangeEvent event= new CustomerChangeEvent(customerId);
		this.applicationEventPublisher.publishEvent(event);
	}
	
	private void blockCustomer(int customerId) {
		logger.info("CustomerId {} blocked", customerId);
	}
	
	@EventListener
	private void onApplicationEvent(CustomerBlockEvent event) {
		this.blockCustomer(event.getCustomerId());
	}

}
