package com.bre.rule;

import com.bre.entities.ItemType;
import com.bre.entities.Payment;
import com.bre.service.ShippingService;

/**
 * generates a packing slip for shipping
 * 
 * @author ashish
 *
 */
public class BookProductRule implements Rule {

	private ShippingService shippingService;

	public BookProductRule(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	@Override
	public boolean accepts(Payment payment) {
		return payment.getItem().getItemType() == ItemType.PHYSICAL;
	}

	@Override
	public void executeRuleOn(Payment payment) {
		shippingService.generatePackingSlip(payment);
	}

}
