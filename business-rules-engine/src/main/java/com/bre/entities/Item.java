package com.bre.entities;

/**
 * Class representing Item entity
 * 
 * @author ashish
 *
 */
public class Item {

	private final ItemType itemType;

	private final String name;

	private final double price;

	public Item(ItemType itemType, String name, double price) {
		super();
		this.itemType = itemType;
		this.name = name;
		this.price = price;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Item other = (Item) obj;
		if (itemType != other.itemType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [itemType=" + itemType + ", name=" + name + ", price=" + price + "]";
	}

}
