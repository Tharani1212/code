package com.mindtree.UserEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "res_details")
public class ResDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "res_id",nullable=false)
	private Integer resId;
	
	@Column(name = "res_name")
	private String resName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	
	
	private String details;

	
	private String detail;


	public Integer getResId() {
		return resId;
	}


	public void setResId(Integer resId) {
		this.resId = resId;
	}


	public String getResName() {
		return resName;
	}


	public void setResName(String resName) {
		this.resName = resName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	

	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	
	
	

}
