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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
int customerId;
String username;
String password;
String role;
ArrayList<Order> orders = new ArrayList<Order>();

@OneToMany(mappedBy="customer", fetch=FetchType.LAZY)
private Set<Order> order;
@ManyToOne
@JoinColumn(name="adminID")
private Admin admin;

public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public ArrayList<Order> getOrders() {
	return orders;
}
public void setOrders(ArrayList<Order> orders) {
	this.orders = orders;
}

}