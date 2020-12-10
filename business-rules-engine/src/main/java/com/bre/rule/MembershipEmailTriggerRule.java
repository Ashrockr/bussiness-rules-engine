package com.bre.rule;

import com.bre.entities.MemberShipItem;
import com.bre.entities.Payment;
import com.bre.entities.User;
import com.bre.service.MembershipService;

/**
 * email the user about their membership
 * 
 * @author ashish
 *
 */
public class MembershipEmailTriggerRule implements Rule {

	private MembershipService membershipService;

	public MembershipEmailTriggerRule(MembershipService membershipService) {
		this.membershipService = membershipService;
	}

	@Override
	public boolean accepts(Payment payment) {
		return payment.getItem() instanceof MemberShipItem;
	}

	@Override
	public void executeRuleOn(Payment payment) {
		membershipService.sendMembershipUpgradeEmail(payment.getUser(),
				((MemberShipItem) payment.getItem()).getMembershipType());
	}

}
