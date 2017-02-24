/**
 * 
 */
package com.charlotte.carservice.Beans;

import java.sql.Date;

/**
 * @author Pritam
 *
 */
public class ServiceSlotBean {
	private int Booking_ref_no; 
	private float Time_slot;
	private String status;
	private String email;
	private String service_name;
	private Date Booking_date;
	private String Vin_no;
	private String empid;
	private int invoiceNo;
	private String carName;
	private String employeeName;
	private String brandName;
	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * @return the carName
	 */
	public String getCarName() {
		return carName;
	}
	/**
	 * @param carName the carName to set
	 */
	public void setCarName(String carName) {
		this.carName = carName;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the invoiceNo
	 */
	public int getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the service_name
	 */
	public String getService_name() {
		return service_name;
	}
	/**
	 * @param service_name the service_name to set
	 */
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	/**
	 * @return the booking_date
	 */
	public Date getBooking_date() {
		return Booking_date;
	}
	/**
	 * @param booking_date the booking_date to set
	 */
	public void setBooking_date(Date booking_date) {
		Booking_date = booking_date;
	}
	/**
	 * @return the vin_no
	 */
	public String getVin_no() {
		return Vin_no;
	}
	/**
	 * @param vin_no the vin_no to set
	 */
	public void setVin_no(String vin_no) {
		Vin_no = vin_no;
	}
	/**
	 * @return the empid
	 */
	public String getEmpid() {
		return empid;
	}
	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	/**
	 * @return the booking_ref_no
	 */
	public int getBooking_ref_no() {
		return Booking_ref_no;
	}
	/**
	 * @param booking_ref_no the booking_ref_no to set
	 */
	public void setBooking_ref_no(int booking_ref_no) {
		Booking_ref_no = booking_ref_no;
	}
	/**
	 * @return the time_slot
	 */
	public float getTime_slot() {
		return Time_slot;
	}
	/**
	 * @param time_slot the time_slot to set
	 */
	public void setTime_slot(float time_slot) {
		Time_slot = time_slot;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Booking_ref_no;
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
		ServiceSlotBean other = (ServiceSlotBean) obj;
		if (Booking_ref_no != other.Booking_ref_no)
			return false;
		return true;
	}
	
	
	
}
