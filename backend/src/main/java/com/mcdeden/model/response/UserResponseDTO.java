package com.mcdeden.model.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class UserResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private LocalDate registrationDate;
	private LocalTime registrationTime;
	private String fullName;
	private String email;
	private String mobileNumber;
	private String status;
	
	public UserResponseDTO() {
		super();
	}
	
	public UserResponseDTO(String id, LocalDate registrationDate, LocalTime registrationTime, String fullName,
			String email, String mobileNumber, String status) {
		super();
		this.id = id;
		this.registrationDate = registrationDate;
		this.registrationTime = registrationTime;
		this.fullName = fullName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.status = status;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public LocalTime getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(LocalTime registrationTime) {
		this.registrationTime = registrationTime;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserResponseDTO [id=" + id + ", registrationDate=" + registrationDate + ", registrationTime="
				+ registrationTime + ", fullName=" + fullName + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", status=" + status + "]";
	}
	
}
