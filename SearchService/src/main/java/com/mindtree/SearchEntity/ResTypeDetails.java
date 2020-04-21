package com.mindtree.SearchEntity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "res_type")
public class ResTypeDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ida")
	private Integer ida;
	
		
	@Column(name = "res_type")
	private String resType;
	
	@Column(name = "res_food")
	private String resFood;
	
	@Column(name = "res_cost")
	private float resCost;
	
	@Column(name = "delivery_ratings")
	private Integer deliveryRatings;
	
	
	@JsonIgnore
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name = "res_id",referencedColumnName = "res_id",insertable =false,updatable=false,nullable=false,unique=true)
	private ResDetails resDetails;

	


	public Integer getIda() {
		return ida;
	}

	public void setIda(Integer ida) {
		this.ida = ida;
	}

	public ResDetails getResDetails() {
		return resDetails;
	}

	public void setResDetails(ResDetails resDetails) {
		this.resDetails = resDetails;
	}

	

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getResFood() {
		return resFood;
	}

	public void setResFood(String resFood) {
		this.resFood = resFood;
	}

	public float getResCost() {
		return resCost;
	}

	public void setResCost(float resCost) {
		this.resCost = resCost;
	}

	public Integer getDeliveryRatings() {
		return deliveryRatings;
	}

	public void setDeliveryRatings(Integer deliveryRatings) {
		this.deliveryRatings = deliveryRatings;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
