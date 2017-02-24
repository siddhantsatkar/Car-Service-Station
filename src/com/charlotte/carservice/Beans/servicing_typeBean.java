package com.charlotte.carservice.Beans;

public class servicing_typeBean {
	public String service_name;
	public float Estimated_time;
	public float Estimated_price;
	public int Max_limit_per_day;
	public servicing_typeBean(String service_name, float estimated_time, float estimated_price, int max_limit_per_day) {
		
		this.service_name = service_name;
		Estimated_time = estimated_time;
		Estimated_price = estimated_price;
		Max_limit_per_day = max_limit_per_day;
	}
	public servicing_typeBean() {
		// TODO Auto-generated constructor stub
		super();
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public float getEstimated_time() {
		return Estimated_time;
	}
	public void setEstimated_time(float estimated_time) {
		Estimated_time = estimated_time;
	}
	public float getEstimated_price() {
		return Estimated_price;
	}
	public void setEstimated_price(float estimated_price) {
		Estimated_price = estimated_price;
	}
	public int getMax_limit_per_day() {
		return Max_limit_per_day;
	}
	public void setMax_limit_per_day(int max_limit_per_day) {
		Max_limit_per_day = max_limit_per_day;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((service_name == null) ? 0 : service_name.hashCode());
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
		servicing_typeBean other = (servicing_typeBean) obj;
		if (service_name == null) {
			if (other.service_name != null)
				return false;
		} else if (!service_name.equals(other.service_name))
			return false;
		return true;
	}
	
	
}
