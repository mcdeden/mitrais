package com.mcdeden.model.request;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UserRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@NotBlank(message="Please enter valid indonesian phone number")
//	@Pattern(regexp = "^(^\\+62\\s?|^0)(\\d{3,4}-?){2}\\d{3,4}$",message = "Please enter valid indonesian phone number")
	private String mobileNumber;
	
	@NotBlank(message="Please enter valid first name")
	@Pattern(regexp = "^[A-Za-z\\s]*$",message = "Please enter valid first name")
	@Size(min=3, max=200, message="must be 3-200 characters long.")
	private String firstName;
	
	@NotBlank(message="Please enter valid last name")
	@Pattern(regexp = "^[A-Za-z\\s]*$",message = "Please enter valid last name")
	@Size(min=3, max=200, message="must be 3-200 characters long.")
	private String lastName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;
	
	private String genderId;
	
	@NotBlank(message="is required.")
	@Pattern(regexp = "^(.+)@(.+)$",message = "email format should be valid.")
	private String email;

	public UserRequestDTO() {
		super();
	}

	public UserRequestDTO(
			@NotBlank(message = "Please enter valid indonesian phone number") @Pattern(regexp = "^(^\\+62\\s?|^0)(\\d{3,4}-?){2}\\d{3,4}$", message = "Please enter valid indonesian phone number") String mobileNumber,
			@NotBlank(message = "Please enter valid first name") @Pattern(regexp = "^[A-Za-z\\s]*$", message = "Please enter valid first name") @Size(min = 3, max = 200, message = "must be 3-200 characters long.") String firstName,
			@NotBlank(message = "Please enter valid last name") @Pattern(regexp = "^[A-Za-z\\s]*$", message = "Please enter valid last name") @Size(min = 3, max = 200, message = "must be 3-200 characters long.") String lastName,
			LocalDate birthDate, String genderId,
			@NotBlank(message = "is required.") @Pattern(regexp = "^(.+)@(.+)$", message = "email format should be valid.") String email) {
		super();
		this.mobileNumber = mobileNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.genderId = genderId;
		this.email = email;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserRequestDTO [mobileNumber=" + mobileNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", genderId=" + genderId + ", email=" + email + "]";
	}

	
}
