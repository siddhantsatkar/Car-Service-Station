/**
 * 
 */
package com.charlotte.carservice.Beans;

/**
 * @author Pritam
 *
 */
public class InvoiceDetails {
	private String itemId;
	private String itemName;
	private int quantity;
	private float unitPrice;
	private float extendedPrice;
	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the unitPrice
	 */
	public float getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the extendedPrice
	 */
	public float getExtendedPrice() {
		return extendedPrice;
	}
	/**
	 * @param extendedPrice the extendedPrice to set
	 */
	public void setExtendedPrice(float extendedPrice) {
		this.extendedPrice = extendedPrice;
	}
	
	
	
}
