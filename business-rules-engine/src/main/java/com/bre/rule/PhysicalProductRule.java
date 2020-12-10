package com.bre.rule;

import com.bre.entities.Payment;
import com.bre.service.ShippingService;

/**
 * generates a duplicate packing slip for royalty department
 * 
 * @author ashish
 *
 */
public class PhysicalProductRule implements Rule {

	private ShippingService shippingService;

	public PhysicalProductRule(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	@Override
	public boolean accepts(Payment payment) {
		return payment.getItem().getName().equals("Book");
	}

	@Override
	public void executeRuleOn(Payment payment) {
		shippingService.generateDuplicatePackingSlip(payment);
	}

}
