package com.ejbs;

import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Stateless
@LocalBean
@Entity
public class Item {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  String name;
  
  
  @ManyToOne
  @JoinColumn(name="adminID")
  private Admin admin;
 
  
  @ManyToOne
  @JoinColumn(name="orderID")
  private Order order;
  
  
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

}