package de.hs.wim.springmessage.messagingexercise.invoicing;

import de.hs.wim.springmessage.messagingexercise.events.CustomerBlockEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;	

	public void blockCustomer(int customerId) {
		CustomerBlockEvent event= new CustomerBlockEvent(customerId);
		applicationEventPublisher.publishEvent(event);
	}

}
