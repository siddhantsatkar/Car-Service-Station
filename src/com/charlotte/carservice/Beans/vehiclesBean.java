package com.charlotte.carservice.Beans;

public class vehiclesBean {
public String Vin_no;
public String car_no;
public String car_type;
public String Brand_name;
public String Car_model;
public String Email_id;
//public 
public vehiclesBean(String vin_no, String car_no, String car_type, String brand_name, String car_model,
		String email_id) {
	
	Vin_no = vin_no;
	this.car_no = car_no;
	this.car_type = car_type;
	Brand_name = brand_name;
	Car_model = car_model;
	Email_id = email_id;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Vin_no == null) ? 0 : Vin_no.hashCode());
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	vehiclesBean other = (vehiclesBean) obj;
	if (Vin_no == null) {
		if (other.Vin_no != null)
			return false;
	} else if (!Vin_no.equals(other.Vin_no))
		return false;
	return true;
}
public vehiclesBean() {
	super();
	// TODO Auto-generated constructor stub
}
public String getVin_no() {
	return Vin_no;
}
public void setVin_no(String vin_no) {
	Vin_no = vin_no;
}
public String getCar_no() {
	return car_no;
}
public void setCar_no(String car_no) {
	this.car_no = car_no;
}
public String getCar_type() {
	return car_type;
}
public void setCar_type(String car_type) {
	this.car_type = car_type;
}
public String getBrand_name() {
	return Brand_name;
}
public void setBrand_name(String brand_name) {
	Brand_name = brand_name;
}
public String getCar_model() {
	return Car_model;
}
public void setCar_model(String car_model) {
	Car_model = car_model;
}
public String getEmail_id() {
	return Email_id;
}
public void setEmail_id(String email_id) {
	Email_id = email_id;
}
}
