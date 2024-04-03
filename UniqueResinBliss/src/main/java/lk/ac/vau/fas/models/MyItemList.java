package lk.ac.vau.fas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MyItems")
public class MyItemList {
	
	@Id//to indicate the primary key of the table
	private int id; 
	private String name;
	private String color;
	private String price;
	public MyItemList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyItemList(int id, String name, String color, String price) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

}
