package com.fr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -4062330487145699111L;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + "]";
	}

}
