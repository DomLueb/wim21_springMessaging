package de.hs.wim.springmessage.messagingexercise.shipping;

import de.hs.wim.springmessage.messagingexercise.events.CustomerBlockEvent;
import de.hs.wim.springmessage.messagingexercise.events.CustomerChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
	private static final Logger logger = LoggerFactory.getLogger(ShippingService.class);

	public void addShipping() {
		// TODO
	}
	
	private void changeCustomerInAllShippings(int customerId) {
		logger.info("All shippings for customer {} changed", customerId);
	}
	
	private void blockCustomerInAllShippings(int customerId) {
		logger.info("All shippings for customer {} blocking: START", customerId);
		for (int i=0; i<10; i++) {
			logger.info("      ...blocking");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		logger.info("All shippings for customer {} blocking: FINISHED", customerId);
	}
	
	@EventListener
	void onApplicationEvent(CustomerChangeEvent event) {
		this.changeCustomerInAllShippings(event.getCustomerId());
	}

	@Async
	@EventListener
	void onApplicationEvent(CustomerBlockEvent event) {
		this.blockCustomerInAllShippings(event.getCustomerId());
	}

}
