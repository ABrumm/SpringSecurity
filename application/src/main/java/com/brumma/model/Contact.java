package com.brumma.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Contact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact implements Serializable
{
    private static final long serialVersionUID = 5248119553847927173L;

    private int contact_id;

    @XmlElement(name = "firstname")
    private String firstname;

    @XmlElement(name = "lastname")
    private String lastname;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "adress")
    private String adress;

    @XmlElement(name = "phone")
    private String phone;

    private User m_user;
    
    public Contact()
    {
    }

    public Contact( String p_firstName, String p_lastName, String p_email, String p_phone, String p_adress )
    {
        this.firstname = p_firstName;
        this.lastname = p_lastName;
        this.email = p_email;
        this.phone = p_phone;
        this.adress = p_adress;
    }

    public String getFirstname()
    {
        return this.firstname;
    }

    public void setFirstname( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return this.lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getAdress()
    {
        return this.adress;
    }

    public void setAdress( String adress )
    {
        this.adress = adress;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public int getContact_id()
    {
        return this.contact_id;
    }

    public void setContact_id( int contact_id )
    {
        this.contact_id = contact_id;
    }

    public User getUser()
    {
        return m_user;
    }

    public void setUser( User m_user )
    {
        this.m_user = m_user;
    }
}
