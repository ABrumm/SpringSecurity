package com.brumma.dao;

import java.util.ArrayList;

import com.brumma.model.Contact;
import com.brumma.model.User;

public interface UserDaoI {

	/**
	 * TODO: generate description
	 * 
	 * @return
	 */
	public ArrayList<User> getuserList();

	/**
	 * TODO: generate description
	 * 
	 * @param userName
	 * @return
	 */
	public void authenticatePrincipial(String userName);

	/**
	 * TODO: generate description
	 * 
	 * @return
	 */
	public Boolean isPrincipialUnlocked();

	/**
	 * TODO: generate description
	 * 
	 * @param p_contact
	 * @return
	 */
	public boolean savePrincipial(Contact p_contact);

	/**
	 * TODO: generate description
	 * 
	 * @param p_contact
	 */
	public void deletePrincipial(Contact p_contact);

	/**
	 * TODO: generate description
	 * 
	 * @param p_contact
	 * @return
	 */
	public boolean updatePrincipial(Contact p_contact);

	/**
	 * TODO: generate description
	 * 
	 * @param p_email
	 * @return
	 */
	public boolean validateEmail(String p_email);

	/**
	 * TODO: generate description
	 * 
	 * @param p_phone
	 * @return
	 */
	public boolean validatePhone(String p_phone);

}
