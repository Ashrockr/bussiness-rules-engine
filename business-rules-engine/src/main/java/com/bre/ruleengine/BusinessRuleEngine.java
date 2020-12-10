package com.bre.ruleengine;

import java.util.Arrays;
import java.util.List;

import com.bre.entities.Payment;
import com.bre.rule.BookProductRule;
import com.bre.rule.PhysicalProductRule;
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
		Rule bookRule = new BookProductRule(shippingService);
		Rule productRule = new PhysicalProductRule(shippingService);
		return Arrays.asList(bookRule, productRule);
	}

	public void process(Payment payment) {
		for (Rule rule : availableRules) {
			if (rule.accepts(payment)) {
				rule.executeRuleOn(payment);
			}
		}
	}
}
