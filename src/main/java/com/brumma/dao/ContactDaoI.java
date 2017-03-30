package com.brumma.dao;

import java.util.ArrayList;

import com.brumma.model.Contact;

public interface ContactDaoI
{
    /**
     * TODO: generate description
     * 
     * @return
     */
    public ArrayList<Contact> getuserList();

    /**
     * TODO: generate description
     * 
     * @param p_contact
     * @return
     */
    public boolean saveUser( Contact p_contact );

    /**
     * TODO: generate description
     * 
     * @param p_contact
     */
    public void deleteUser( Contact p_contact );

    /**
     * TODO: generate description
     * 
     * @param p_contact
     * @return
     */
    public boolean updateUser( Contact p_contact );

    /**
     * TODO: generate description
     * 
     * @param p_email
     * @return
     */
    public boolean validateEmail( String p_email );

    /**
     * TODO: generate description
     * 
     * @param p_phone
     * @return
     */
    public boolean validatePhone( String p_phone );
}
