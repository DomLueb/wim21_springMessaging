package de.hs.wim.springmessage.messagingexercise.events;

public class CustomerChangeEvent {
	private final int customerId;
	
	public CustomerChangeEvent(int customerId) {
		this.customerId= customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

}
