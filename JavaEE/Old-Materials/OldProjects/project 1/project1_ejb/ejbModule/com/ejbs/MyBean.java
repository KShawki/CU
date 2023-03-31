package com.ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MyBean
 */
@Stateless
@LocalBean
public class MyBean {

   String message;
   public String getMsg()
   {
	   message = "hima";
	   return message;
   }

}
