package io.project.mock.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement
@XmlType(propOrder = {"id","phone","address1","address2","postalCode","city","state","teritory","country"})
public class office {
	private int id;
	private String city;
	private String phone;
	private String address1;
	private String address2;
	private String state;
	private String country;
	private String postalCode;
	private String teritory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getTeritory() {
		return teritory;
	}
	public void setTeritory(String teritory) {
		this.teritory = teritory;
	}
	@Override
	public String toString() {
		return "officeRepository [id=" + id + ", city=" + city + ", phone=" + phone + ", address1=" + address1
				+ ", address2=" + address2 + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", teritory=" + teritory + "]";
	}
	

}
