package com.brumma.dao.impl;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Service;

import com.brumma.dao.ContactDAO;
import com.brumma.model.Contact;
import com.brumma.util.HibernateUtil;

@Service
@ViewScoped
public class ContactDAOImpl implements ContactDAO{

	public ArrayList<Contact> getuserList()
	  {
	    return (ArrayList)HibernateUtil.getSession().createQuery("FROM Contact").getResultList();
	  }
	  
	  public boolean saveUser(Contact p_contact)
	  {
	    if ((!p_contact.getFirstname().isEmpty()) && (!p_contact.getLastname().isEmpty()) && 
	      (validatePhone(p_contact.getPhone())) && 
	      (!p_contact.getEmail().isEmpty()) && (validateEmail(p_contact.getEmail())))
	    {
	      HibernateUtil.getSession().beginTransaction();
	      HibernateUtil.getSession().save(p_contact);
	      HibernateUtil.getSession().getTransaction().commit();
	      return true;
	    }
	    return false;
	  }
	  
	  public void deleteUser(Contact p_contact)
	  {
	    HibernateUtil.getSession().beginTransaction();
	    HibernateUtil.getSession().delete(p_contact);
	    HibernateUtil.getSession().getTransaction().commit();
	  }
	  
	  public boolean updateUser(Contact p_contact)
	  {
	    if ((!p_contact.getFirstname().isEmpty()) && (!p_contact.getLastname().isEmpty()) && 
	      (validatePhone(p_contact.getPhone())) && 
	      (!p_contact.getEmail().isEmpty()) && (validateEmail(p_contact.getEmail())))
	    {
	      HibernateUtil.getSession().beginTransaction();
	      HibernateUtil.getSession().update(p_contact);
	      HibernateUtil.getSession().getTransaction().commit();
	      
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean validateEmail(String p_email)
	  {
	    Pattern l_emailPattern = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
	    if (l_emailPattern.matcher(p_email).find()) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean validatePhone(String p_phone)
	  {
	    Pattern l_phonePattern = Pattern.compile("^[0-9\\+]{1,}[0-9\\-]{3,15}$");
	    if (l_phonePattern.matcher(p_phone).find()) {
	      return true;
	    }
	    return false;
	  }

}
