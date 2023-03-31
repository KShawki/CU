package com.ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Set;
@Stateless
@LocalBean
@Entity
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int orderId;	
String orderName;

@OneToMany(mappedBy="order",fetch=FetchType.LAZY)
private Set<Item> item;
@ManyToOne
@JoinColumn(name="adminID")
private Admin admin;

@ManyToOne
@JoinColumn(name="customerID")
private Customer customer;

ArrayList<Item> items = new ArrayList<Item>();
public String getOrderName() {
	return orderName;
}

public void setOrderName(String orderName) {
	this.orderName = orderName;
}

public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public ArrayList<Item> getItems() {
	return items;
}
public void setItems(ArrayList<Item> items) {
	this.items = items;
}
}