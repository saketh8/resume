package com.zensar.tp.dto;

import com.zensar.tp.dto.RegisterUser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="info")
public class RegisterUser { 
	@ApiModelProperty(value="user ID")
	private int id;
	@ApiModelProperty(value="user first name")
	private String firstName;
	@ApiModelProperty(value="user last name")
	private String lastName;
	@ApiModelProperty(value="user name")
	private String userName;
	@ApiModelProperty(value="user password")
	private String password;
	@ApiModelProperty(value="user email")
	private String email;
	@ApiModelProperty(value="user phoneno.")
	private String phone; 
	public RegisterUser() {
		super();
	}
	public RegisterUser(String firstName, String lastName, String userName, String password, String email,
				String phone) {
			super();
			//this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.phone = phone;
	}
	public RegisterUser(int id,String firstName, String lastName, String userName, String password, String email,
			String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	//public RegisterUser(int id, String firstName, String lastName, String userName, String password, String email,
		//	String phone) {
		//super();
		//this.id = id;
		//this.firstName = firstName;
		//this.lastName = lastName;
		//this.userName = userName;
		//this.password = password;
		//this.email = email;
		//this.phone = phone;
	//}
	@Override
	  public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RegisterUser other = (RegisterUser) obj;
        return id == other.id;
    }
	@Override
	public String toString() {
		return "[id=" + id +",firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" + password +", email=" + email +",phone=" + phone +"]";
	}
	

}