package com.bre.rule;

import com.bre.entities.MemberShipItem;
import com.bre.entities.Payment;
import com.bre.service.MembershipService;

/**
 * Upgrades the user membership
 * 
 * @author ashish
 *
 */
public class UpgradeMembershipRule implements Rule {

	private MembershipService membershipService;

	public UpgradeMembershipRule(MembershipService membershipService) {
		this.membershipService = membershipService;
	}

	@Override
	public boolean accepts(Payment payment) {
		if (payment.getItem() instanceof MemberShipItem) {
			MemberShipItem memberShipItem = (MemberShipItem) payment.getItem();
			return memberShipItem.getMembershipType().compareTo(payment.getUser().getMembershipType()) > 0;

		}
		return false;
	}

	@Override
	public void executeRuleOn(Payment payment) {
		membershipService.applyMembership(payment.getUser(), ((MemberShipItem) payment.getItem()).getMembershipType());
	}

}
