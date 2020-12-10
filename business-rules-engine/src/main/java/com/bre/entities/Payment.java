package com.bre.entities;

public class Payment {

	private final User user;

	private final Item item;

	public Payment(User user, Item item) {
		this.user = user;
		this.item = item;
	}

	/**
	 * @return User who ordered the items
	 * 
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @return {@link Item} which is being bought
	 */
	public Item getItem() {
		return item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		}
		else if (!item.equals(other.item))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		}
		else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [user=" + user + ", item=" + item + "]";
	}
	
	
}
