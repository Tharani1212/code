package com.mindtree.UserEntity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "user")
public class Users implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "User_id")
	private Integer userId;
	
	
	@Column(name = "User_name")
	private String userName;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Phone_number")
	private BigInteger phoneNumber;
	
	@NotNull
    @Size(min = 6, max = 14)
	@Column(name = "Password")
	private String password;
	
	
	@Column(name = "Role_id")
	private Integer roleId;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
