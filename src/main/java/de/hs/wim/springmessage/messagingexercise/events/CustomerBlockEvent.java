package de.hs.wim.springmessage.messagingexercise.events;

public class CustomerBlockEvent {
	private final int customerId;
	
	public CustomerBlockEvent(int customerId) {
		this.customerId= customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

}
