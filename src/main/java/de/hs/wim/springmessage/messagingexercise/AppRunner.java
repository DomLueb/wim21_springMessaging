package de.hs.wim.springmessage.messagingexercise;

import de.hs.wim.springmessage.messagingexercise.customer.CustomerService;
import de.hs.wim.springmessage.messagingexercise.invoicing.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
	private final CustomerService customerService;
	private final InvoiceService invoiceService;
	
	@Autowired
	public AppRunner(CustomerService customerService, InvoiceService invoiceService) {
		this.customerService= customerService;
		this.invoiceService= invoiceService;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Welcome to the Spring universe");
		this.customerService.changeLastnameOfCustomer(100, "Meyer");
		logger.info("\n");
		this.invoiceService.blockCustomer(103);
		
		logger.info("Ready for new tasks.");
	}

}
