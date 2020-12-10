package com.bre.ruleengine;

import java.util.Arrays;
import java.util.List;

import com.bre.entities.MemberShipItem;
import com.bre.entities.Payment;
import com.bre.rule.ActivateMembershipRule;
import com.bre.rule.BookProductRule;
import com.bre.rule.MembershipEmailTriggerRule;
import com.bre.rule.PhysicalProductRule;
import com.bre.rule.Rule;
import com.bre.rule.UpgradeMembershipRule;
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

	/**
	 * initializes the RULEs
	 * 
	 * @return
	 */
	private List<Rule> initializeAndGetRuleBase() {
		Rule bookRule = new BookProductRule(shippingService);
		Rule productRule = new PhysicalProductRule(shippingService);
		Rule activateMembershipRule = new ActivateMembershipRule(membershipService);
		Rule membershipEmailTriggerRule = new MembershipEmailTriggerRule(membershipService);
		Rule upgradeMembershipRule = new UpgradeMembershipRule(membershipService);
		return Arrays.asList(bookRule, productRule, activateMembershipRule, membershipEmailTriggerRule,
				upgradeMembershipRule);
	}

	public void process(Payment payment) {
		for (Rule rule : availableRules) {
			if (rule.accepts(payment)) {
				rule.executeRuleOn(payment);
			}
		}
	}
}
