package com.bre.service;

import com.bre.entities.MembershipType;
import com.bre.entities.User;

public interface MembershipService {

	/**
	 * Applies the provided {@link MembershipType} to the {@link User}
	 */
	public void applyMembershipe(User user, MembershipType membershipType);

	/**
	 * send an email to the user about the membership upgrade.
	 * 
	 */
	public void sendMembershipUpgradeEmail(User user);
}
