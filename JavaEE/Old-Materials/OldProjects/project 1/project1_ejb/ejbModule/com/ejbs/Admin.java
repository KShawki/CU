package com.ejbs;

import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Stateless
@LocalBean
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String password;
	String role;
	
	@OneToMany(mappedBy="admin", fetch=FetchType.LAZY)
	  private Set<Item> item;
	@OneToMany(mappedBy="admin", fetch=FetchType.LAZY)
	 private Set<Customer> customer;
	@OneToMany(mappedBy="admin", fetch=FetchType.LAZY)
	 private Set<Order> order;
	 
	 public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}