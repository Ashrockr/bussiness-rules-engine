package com.bre.service;

import com.bre.entities.MembershipType;
import com.bre.entities.User;

public interface MembershipService {

	/**
	 * activates the Membership
	 * 
	 * @param user
	 */
	public void activateMembership(User user);

	/**
	 * Applies the provided {@link MembershipType} to the {@link User}
	 */
	public void applyMembership(User user, MembershipType membershipType);

	/**
	 * send an email to the user about the membership upgrade.
	 * 
	 * @param membershipType type of membership which use is upgarding to
	 * 
	 */
	public void sendMembershipUpgradeEmail(User user, MembershipType membershipType);
}
