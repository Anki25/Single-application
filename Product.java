package com.niit.model;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
@Component
public class Product {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int pro_Id;
	@NotEmpty(message="name cannot be empty")
	private String pro_name;
	@NotEmpty(message="description cannot be empty")
	private String description;
	@NotEmpty(message="price cannot be empty")
	@DecimalMin(value="100.00")
	private String price;
	@NotEmpty (message=" cannot be empty") 
	@Min(0)
	private String quantity;
	@Transient
	private MultipartFile image;
	public int getPro_Id() {
		return pro_Id;
	}
	public void setPro_Id(int pro_Id) {
		this.pro_Id = pro_Id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
		}
	
	


