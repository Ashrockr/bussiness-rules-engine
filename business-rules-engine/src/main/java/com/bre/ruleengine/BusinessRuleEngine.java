package com.bre.ruleengine;

import java.util.List;

import com.bre.entities.Payment;
import com.bre.rule.Rule;
import com.bre.service.MembershipService;
import com.bre.service.ShippingService;

public class BusinessRuleEngine {

	private final List<Rule> availableRules;
	private final ShippingService shippingService;
	private final MembershipService membershipService;

	public BusinessRuleEngine(ShippingService shippingService, MembershipService membershipService) {
		this.shippingService = shippingService;
		this.membershipService = membershipService;
		availableRules = initializeAndGetRuleBase();
	}

	private List<Rule> initializeAndGetRuleBase() {
		// TODO Auto-generated method stub
		return null;
	}

	public void process(Payment payment) {
		for (Rule rule : availableRules) {
			if (rule.accepts(payment)) {
				rule.executeRuleOn(payment);
			}
		}
	}
}
