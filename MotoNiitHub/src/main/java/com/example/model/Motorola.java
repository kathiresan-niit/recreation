package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Motorola implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	private Integer avail;
	private String pname;
	private String imgpath;
	private String description;
	private String category;
	private String subcategory;
	private Integer price;
	private transient MultipartFile f;

	public MultipartFile getF() {
		return f;
	}

	public void setF(MultipartFile f) {
		this.f = f;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getAvail() {
		return avail;
	}

	public void setAvail(Integer avail) {
		this.avail = avail;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public Motorola() {
		// TODO Auto-generated constructor stub
	}

	public Motorola(Integer pid, Integer avail, String pname, String imgpath, String description, String category,
			String subcategory) {
		super();
		this.pid = pid;
		this.avail = avail;
		this.pname = pname;
		this.imgpath = imgpath;
		this.description = description;
		this.category = category;
		this.subcategory = subcategory;
	}

	/*public void bindAndValidate(){
		
	}*/
	@Override
	public String toString() {
		return "Employee{" + "id=" + pid + ", name='" + pname + '\'' + ", avail=" + avail + ", cat=" + category + '}';
	}
    
    @OneToMany(cascade = CascadeType.ALL)//(mappedBy = "item")//, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<UserCart> cartItemList;

	public List<UserCart> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<UserCart> cartItemList) {
		this.cartItemList = cartItemList;
	}

    
}
