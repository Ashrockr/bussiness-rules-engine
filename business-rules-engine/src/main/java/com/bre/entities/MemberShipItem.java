package com.bre.entities;

/**
 * Class representing Membership
 * 
 * @author ashish
 *
 */
public class MemberShipItem extends Item {

	private MembershipType membershipType;

	public MemberShipItem(ItemType itemType, String name, double price, MembershipType membershipType) {
		super(itemType, name, price);
		this.setMembershipType(membershipType);
	}

	public MembershipType getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType;
	}

}
