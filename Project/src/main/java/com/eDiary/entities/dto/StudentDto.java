package com.eDiary.entities.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StudentDto {
	@NotNull(message = "Username must be specified.")
	@Size(min = 5, max = 15, message = "Username must be between {min} and {max} characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username can contain only alphanumeric characters.")
	private String username;

	@NotNull(message = "Password must be specified.")
	@Size(min = 5, max = 15, message = "Password must be between {min} and {max} characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password can contain only alphanumeric characters.")
	private String password;

	@NotNull(message = "Confirmed password must be specified.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Confirmed password can contain only alphanumeric characters long.")
	private String confirmedPassword;

	@NotNull(message = "First name must be specified.")
	@Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "First name can contain only uppercase and lowercase letters.")
	private String firstName;

	@NotNull(message = "Last name must be specified.")
	@Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters.")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Last name can contain only uppercase and lowercase letters.")
	private String lastName;

	
	public StudentDto() {
		super();
	}

	public StudentDto(
			@NotNull(message = "Username must be specified.") @Size(min = 5, max = 15, message = "Username must be between {min} and {max} characters long.") @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username can contain only alphanumeric characters.") String username,
			@NotNull(message = "Password must be specified.") @Size(min = 5, max = 15, message = "Password must be between {min} and {max} characters long.") @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password can contain only alphanumeric characters.") String password,
			@NotNull(message = "Confirmed password must be specified.") @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Confirmed password can contain only alphanumeric characters.") String confirmedPassword,
			@NotNull(message = "First name must be specified.") @Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.") @Pattern(regexp = "^[a-zA-Z]*$", message = "First name can contain only uppercase and lowercase letters.") String firstName,
			@NotNull(message = "Last name must be specified.") @Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.") @Pattern(regexp = "^[a-zA-Z]*$", message = "Last name can contain only uppercase and lowercase letters.") String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.confirmedPassword = confirmedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
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
}
