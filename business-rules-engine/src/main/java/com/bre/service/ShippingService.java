package com.bre.service;

import com.bre.entities.Payment;

public interface ShippingService {

	/**
	 * generates the packing slip for shipping of the provided Payment
	 * 
	 * @param payment for whom packing slip is to be generated
	 */
	public void generatePackingSlip(Payment payment);
	
	/**
	 * generates the duplicate packing slip for royalty department
	 * @param payment
	 */
	public void generateDuplicatePackingSlip(Payment payment);
	

}
