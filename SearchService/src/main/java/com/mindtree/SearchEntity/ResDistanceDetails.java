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
@Table(name = "res_distance")
public class ResDistanceDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "d_id")
	private Integer dId;
	
	@Column(name = "res_dis")
	private Integer resDis;
	

	@JsonIgnore
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name = "res_id",referencedColumnName = "res_id",insertable =false,updatable=false,nullable=false,unique=true)
	private ResDetails resDetails;
	

	

	


	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public ResDetails getResDetails() {
		return resDetails;
	}

	public void setResDetails(ResDetails resDetails) {
		this.resDetails = resDetails;
	}

	public Integer getResDis() {
		return resDis;
	}

	public void setResDis(Integer resDis) {
		this.resDis = resDis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
