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
	public ArrayList<User> getPrincipal(String p_principal, String p_credential);

	/**
	 * TODO: generate description
	 * 
	 * @param userName
	 * @return
	 */
	public void authenticatePrincipal(String userName);

	/**
	 * TODO: generate description
	 * 
	 * @return
	 */
	public Boolean isPrincipalUnlocked();

	/**
	 * TODO: generate description
	 * 
	 * @param p_contact
	 * @return
	 */
	public boolean savePrincipal(Contact p_contact);

	/**
	 * TODO: generate description
	 * 
	 * @param p_contact
	 */
	public void deletePrincipal(Contact p_contact);

	/**
	 * TODO: generate description
	 * 
	 * @param p_contact
	 * @return
	 */
	public boolean updatePrincipal(Contact p_contact);

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
