/**
 * 
 */
package com.charlotte.carservice.Beans;

/**
 * @author Pritam
 *
 */
public class StockBean {
public String stock_id;
public int quantity;
public float price;
public String name;

public StockBean(String stock_id, int stockquantity, float price, String name) {
	this.stock_id = stock_id;
	this.quantity = stockquantity;
	this.price = price;
	this.name = name;
}

public String getStock_id() {
	return stock_id;
}
public void setStock_id(String stock_id) {
	this.stock_id = stock_id;
}
public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



}
