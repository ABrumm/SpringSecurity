package com.brumma.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.brumma.dao.UserDaoI;
import com.brumma.model.Contact;
import com.brumma.model.User;
import com.brumma.security.DemoAuthenticationDetails;
import com.brumma.util.HibernateUtil;

public class UserDao implements UserDaoI
{

    @Override
    public ArrayList<User> getPrincipal( String p_principal, String p_credential )
    {
        List<?> l_principalList = new ArrayList<User>();
        Session l_session = HibernateUtil.getSession();
        l_session.beginTransaction();
        Query<?> sqlQuery = l_session.createQuery( "FROM User WHERE userName  = :param1 AND userPassword = :param2" );
        sqlQuery.setParameter( "param1", p_principal );
        sqlQuery.setParameter( "param2", p_credential );
        l_principalList = sqlQuery.getResultList();
        l_session.getTransaction().commit();
        l_session.close();
        return (ArrayList<User>) l_principalList;
    }

    @Override
    public void authenticatePrincipal( String userName )
    {
        // TODO Auto-generated method stub

    }

    public int getUserIdentity( DemoAuthenticationDetails p_authenticationDetails )
    {
        
        List<?> l_userList = new ArrayList<User>();
        Session l_session = HibernateUtil.getSession();
        l_session.beginTransaction();
        Query<?> sqlQuery = l_session.createQuery( "FROM User WHERE userName  = :param1 AND userPassword = :param2" );
        sqlQuery.setParameter( "param1", p_authenticationDetails.getUserName() );
        sqlQuery.setParameter( "param2", p_authenticationDetails.getUserPW() );
        l_userList = sqlQuery.getResultList();
        l_session.getTransaction().commit();
        l_session.close();
        
        p_authenticationDetails.setUserIdentity(  ((User) l_userList.get( 0 )).getUserId() );
        p_authenticationDetails.setLoggedUser( (User) l_userList.get( 0 ));
        
        return ((User) l_userList.get( 0 )).getUserId();

    }

    @Override
    public Boolean isPrincipalUnlocked()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean savePrincipal( Contact p_contact )
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void deletePrincipal( Contact p_contact )
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean updatePrincipal( Contact p_contact )
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validateEmail( String p_email )
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validatePhone( String p_phone )
    {
        // TODO Auto-generated method stub
        return false;
    }

}
