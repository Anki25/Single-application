package com.niit.model;

import javax.persistence.Entity;

import com.niit.model.Supplier;
import com.niit.model.Category;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import java.util.Set;

import javax.persistence.CascadeType;

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
	@Transient
	private MultipartFile img;
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
	
	@ManyToMany(cascade=CascadeType.ALL) 
	@JoinTable(name="sup_pro", joinColumns=@JoinColumn(name="sup_id"), inverseJoinColumns=@JoinColumn(name="sup_Id"))
	//@JoinColumn(name="sup_Id", nullable=false ,updatable=false )
	private Set<Supplier> supplier;
	
	
	public Set<Supplier> getSupplier() {
		return supplier;
	}
	public void setSupplier(Set<Supplier> supplier) {
		this.supplier = supplier;	
	}
	
	private int sup_id;
	
	public Set<Supplier> getSup_Id() {
		return supplier;
	}
	public void setSup_Id(Set<Supplier> sup_Id) {
		this.supplier = sup_Id;
	}
	
		
	public int getSup_id() {
		return sup_id;
	}
	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}   
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cat_Id", insertable=false ,updatable=false )
	private Category category;
	
		
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;		
		}
	
    private int cat_Id;
	public int getCat_Id() {
		return cat_Id;
	}
	public void setCat_Id(int cat_Id) {
		this.cat_Id = cat_Id;
	}
	
		
	
	
		}
	
	


