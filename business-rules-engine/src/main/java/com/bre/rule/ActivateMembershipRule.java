package com.bre.rule;

import com.bre.entities.MemberShipItem;
import com.bre.entities.Payment;
import com.bre.service.MembershipService;

/**
 * generates activate membership
 * 
 * @author ashish
 *
 */
public class ActivateMembershipRule implements Rule {

	private MembershipService membershipService;

	public ActivateMembershipRule(MembershipService membershipService) {
		this.membershipService = membershipService;
	}

	@Override
	public boolean accepts(Payment payment) {
		return payment.getItem() instanceof MemberShipItem;
	}

	@Override
	public void executeRuleOn(Payment payment) {
		membershipService.applyMembership(payment.getUser(), ((MemberShipItem) payment.getItem()).getMembershipType());
	}

}
