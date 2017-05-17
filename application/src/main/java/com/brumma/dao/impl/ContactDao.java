package com.brumma.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.brumma.dao.ContactDaoI;
import com.brumma.model.Contact;
import com.brumma.util.HibernateUtil;

public class ContactDao implements ContactDaoI
{
    
    /**
     * TODO: Methoddescription
     */
    public ArrayList<Contact> getuserList( int p_userIdentity )
    {
        List<?> l_contactList = new ArrayList<Contact>();
        Session l_session = HibernateUtil.getSession();
        l_session.beginTransaction();
        Query<?> sqlQuery = l_session.createQuery( "FROM Contact WHERE userId = :param1" );
        sqlQuery.setParameter( "param1", p_userIdentity );
        l_contactList = sqlQuery.getResultList();
        l_session.getTransaction().commit();
        l_session.close();
        return (ArrayList<Contact>) l_contactList;
    }

    /**
     * TODO: MethodDescription
     */
    public boolean saveUser( Contact p_contact )
    {
        if ( ( !p_contact.getFirstname().isEmpty() ) && ( !p_contact.getLastname().isEmpty() ) && ( validatePhone( p_contact.getPhone() ) )
        && ( !p_contact.getEmail().isEmpty() ) && ( validateEmail( p_contact.getEmail() ) ) )
        {
            Session l_session = HibernateUtil.getSession();
            l_session.beginTransaction();
            l_session.save( p_contact );
            l_session.getTransaction().commit();
            l_session.close();
            return true;
        }
        return false;
    }

    public void deleteUser( Contact p_contact )
    {
        HibernateUtil.createSession();
        Session l_session = HibernateUtil.getSession();
        l_session.beginTransaction();
        l_session.delete( p_contact );
        l_session.getTransaction().commit();
        l_session.close();
    }

    public boolean updateUser( Contact p_contact )
    {
        if ( ( !p_contact.getFirstname().isEmpty() ) && ( !p_contact.getLastname().isEmpty() ) && ( validatePhone( p_contact.getPhone() ) )
        && ( !p_contact.getEmail().isEmpty() ) && ( validateEmail( p_contact.getEmail() ) ) )
        {
            Session l_session = HibernateUtil.getSession();
            l_session.beginTransaction();
            l_session.update( p_contact );
            l_session.getTransaction().commit();
            l_session.close();

            return true;
        }
        return false;
    }

    public boolean validateEmail( String p_email )
    {
        Pattern l_emailPattern = Pattern.compile( "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$" );
        if ( l_emailPattern.matcher( p_email ).find() )
        {
            return true;
        }
        return false;
    }

    public boolean validatePhone( String p_phone )
    {
        Pattern l_phonePattern = Pattern.compile( "^[0-9\\+]{1,}[0-9\\-]{3,15}$" );
        if ( l_phonePattern.matcher( p_phone ).find() )
        {
            return true;
        }
        return false;
    }

}
