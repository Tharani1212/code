package com.data.bind;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SearchEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean distance;
	
	private boolean type;
	
	private boolean budget;
	
	private boolean rating;
	
    private Integer distances;
	
	private String types;
	
	private float budgets;
	
	private Integer ratings;

	public boolean isDistance() {
		return distance;
	}

	public void setDistance(boolean distance) {
		this.distance = distance;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public boolean isBudget() {
		return budget;
	}

	public void setBudget(boolean budget) {
		this.budget = budget;
	}

	

	public Integer getDistances() {
		return distances;
	}

	public void setDistances(Integer distances) {
		this.distances = distances;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public float getBudgets() {
		return budgets;
	}

	public void setBudgets(float budgets) {
		this.budgets = budgets;
	}

	public boolean isRating() {
		return rating;
	}

	public void setRating(boolean rating) {
		this.rating = rating;
	}

	public Integer getRatings() {
		return ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	
	
	

}
