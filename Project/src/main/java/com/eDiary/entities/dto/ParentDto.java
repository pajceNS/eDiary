package com.eDiary.entities.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ParentDto {

	@NotNull(message = "Username must be specified.")
	@Size(min = 5, max = 15, message = "Username must be between {min} and {max} characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username can contain only alphanumeric characters.")
	private String username;

	@NotNull(message = "Password must be specified.")
	@Size(min = 5, max = 15, message = "Password must be between {min} and {max} characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password can contain only alphanumeric characters.")
	private String password;

	@NotNull(message = "Confirmed password must be specified.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Confirmed password can contain only alphanumeric characters.")
	private String confirmedPassword;

	@NotNull(message = "First name must be specified.")
	@Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "First name can contain only uppercase and lowercase letters.")
	private String firstName;

	@NotNull(message = "Last name must be specified.")
	@Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Last name can contain only uppercase and lowercase letters.")
	private String lastName;

	@NotNull(message = "Email must be specified.")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email is not valid.")
	private String email;

	public ParentDto() {
		super();
	}

	public ParentDto(
			@NotNull(message = "Username must be specified.") @Size(min = 5, max = 15, message = "Username must be between {min} and {max} characters long.") @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username can contain only alphanumeric characters.") String username,
			@NotNull(message = "Password must be specified.") @Size(min = 5, max = 15, message = "Password must be between {min} and {max} characters long.") @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password can contain only alphanumeric characters.") String password,
			@NotNull(message = "Confirmed password must be specified.") @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Confirmed password can contain only alphanumeric characters.") String confirmedPassword,
			@NotNull(message = "First name must be specified.") @Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.") @Pattern(regexp = "^[a-zA-Z]*$", message = "First name can contain only uppercase and lowercase letters.") String firstName,
			@NotNull(message = "Last name must be specified.") @Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.") @Pattern(regexp = "^[a-zA-Z]*$", message = "Last name can contain only uppercase and lowercase letters.") String lastName,
			@NotNull(message = "Email must be specified.") @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email is not valid.") String email) {
		super();
		this.username = username;
		this.password = password;
		this.confirmedPassword = confirmedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
