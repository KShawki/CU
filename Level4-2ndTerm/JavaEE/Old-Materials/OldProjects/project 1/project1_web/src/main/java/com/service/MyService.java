package com.service;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.ejbs.Admin;
import com.ejbs.Customer;
import com.ejbs.Item;
import com.ejbs.Order;
@Stateless
@Path("/Adminservice")
//@PermitAll
public class MyService{ 
	@PersistenceContext
	private EntityManager entitymanager;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("registerAdmin")
	public String register(Admin a) //shaghala
	{
		try 
		{
			entitymanager.persist(a);
			return "Success";
		}
			catch (Exception e)
		{
			throw new EJBException(e);
		}
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("loginAdmin/{a}")
	public String loginAsAdmin(@PathParam("a")Admin a)//shaghala
	{
		Admin x = entitymanager.find(Admin.class,a);
		if (x!=null)
			return entitymanager.find(Admin.class,a)+" logged in successfully.";
		else
			return "Invalid Admin";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) 
	@Path("newItem")
	public String CreateAnItem(Item i)//shaghala
	{
		try 
			{
				entitymanager.persist(i);
				return "Success";
			} 
		catch (Exception e)
			{
				throw new EJBException(e);
			}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("viewOrder/{customerId}")
	public List<Order> ViewOrdersByCustomerId(@PathParam("customerId")int customerId)//shaghala
	{
		TypedQuery<Order> query2 = entitymanager.createQuery("SELECT order FROM ORDER order where Customer.id =:id ", Order.class);
		query2.setParameter("id", customerId);
		List<Order> orders = query2.getResultList();
		return orders;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("viewAll")
	public List<Admin> viewAllOrders()//shaghala
	{
		TypedQuery<Admin> query = entitymanager.createQuery("SELECT order FROM ADMIN order", Admin.class);
		List<Admin> orders =query.getResultList();
		return orders;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("blockCustomer/{customer}")
	public String blockCustomer(@PathParam("customer")Customer customer)//shaghala
	{
		try 
		{
			entitymanager.remove(customer);
			return "Customer: "+customer+" blocked successfully";
		} 
			catch (Exception e)
		{
			throw new EJBException(e);
		}
	}
	
	@RolesAllowed("admin")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("roleAdmin/{admin}")
	public String getRoleOfCurrentUser(@PathParam("admin")Admin admin)//shaghala
	
	{
		return "Role of current user is an admin"; 
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("registerCustomer")
	public String register(Customer c)//shaghala
	{
		try {
			entitymanager.persist(c);
			return "Success";
		} 
		catch (Exception e)
		{
			throw new EJBException(e);
		}
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("loginCustomer/{customer}")
	public String loginAsCustomer(@PathParam("customer")Customer customer)//shaghala
	{
		Customer x = entitymanager.find(Customer.class,customer);
		if (x!=null)
			return entitymanager.find(Customer.class,customer)+" logged in successfully.";
		else
			return "Invalid Customer";
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("newOrder")
	public String createOrder(ArrayList<Item>items, Order o) //error
	{
		if(entitymanager.find(Item.class,items) != null) {
		try {
			entitymanager.persist(o);
			return "Order with name: "+entitymanager.find(Order.class, o)+" created successfully.";
		} catch (Exception e)
		{
			throw new EJBException(e);
		}
		}
		else
			return"Item not found";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("viewOrderId/{ID}")
	public List<Order> viewOrderById(@PathParam("ID")int ID)//--
	{

		TypedQuery<Order> query2 = entitymanager.createQuery("SELECT order FROM ORDER order where Customer.id =id", Order.class);
		query2.setParameter("id", ID);
		List<Order> orders = query2.getResultList();
		return orders;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("viewAllByCustomers")
	public List<Customer> viewAllCustomersOrders(Customer customer)//shaghala
	{
		TypedQuery<Customer> query = entitymanager.createQuery("SELECT order FROM ORDER order", Customer.class);
		List<Customer> orders =query.getResultList();
		return orders;
	}
	
	@RolesAllowed("customer")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("roleCustomer/{customer}")
	public String getRoleOfCurrentUser(@PathParam("customer")Customer customer)//shaghala
	{
		return "Role of current user is a customer";
	}

	
}
