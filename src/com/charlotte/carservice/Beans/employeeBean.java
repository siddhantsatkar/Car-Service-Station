package com.charlotte.carservice.Beans;

public class employeeBean {
public String empId;
public String name;
public String sevice_name;


public employeeBean(String empId, String name, String sevice_name) {
	
	this.empId = empId;
	this.name = name;
	this.sevice_name = sevice_name;
}
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSevice_name() {
	return sevice_name;
}
public void setSevice_name(String sevice_name) {
	this.sevice_name = sevice_name;
}

}
