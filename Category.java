package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Category")
public class Category {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int cat_Id;
	@NotEmpty(message="name cannot be empty")
	private String cat_name;
	private String description;
	
	
	public int getCat_Id() {
		return cat_Id;
	}
	public void setCat_Id(int cat_Id) {
		this.cat_Id = cat_Id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
