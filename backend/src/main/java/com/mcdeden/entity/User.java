package com.mcdeden.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private LocalDate registrationDate;
	private LocalTime registrationTime;	
	private String mobileNumber;
	private String firstName;
	private String lastName;	
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@OneToOne
	@JoinColumn(name="gender_id", nullable=true)
	private MasterGender gender;
	
	private String email;
	
	@OneToOne
	@JoinColumn(name="status_id", nullable=true)
	private MasterUserStatus status;

	public User() {
		super();
	}

	public User(String id, LocalDate registrationDate, LocalTime registrationTime, String mobileNumber,
			String firstName, String lastName, int birthDay, int birthMonth, int birthYear, LocalDate birthDate,
			MasterGender gender, String email, MasterUserStatus status) {
		super();
		this.id = id;
		this.registrationDate = registrationDate;
		this.registrationTime = registrationTime;
		this.mobileNumber = mobileNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public MasterGender getGender() {
		return gender;
	}

	public void setGender(MasterGender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MasterUserStatus getStatus() {
		return status;
	}

	public void setStatus(MasterUserStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", registrationDate=" + registrationDate + ", registrationTime=" + registrationTime
				+ ", mobileNumber=" + mobileNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDay=" + birthDay + ", birthMonth=" + birthMonth + ", birthYear=" + birthYear + ", birthDate="
				+ birthDate + ", gender=" + gender + ", email=" + email + ", status=" + status + "]";
	}

	
	
}
