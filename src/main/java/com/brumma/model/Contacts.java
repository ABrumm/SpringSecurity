package com.brumma.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Contacts")
public class Contacts
{
  @XmlElement(name="Contact")
  ArrayList<Contact> users = new ArrayList();
  
  public ArrayList<Contact> getUsers()
  {
    return this.users;
  }
  
  public void setUsers(ArrayList<Contact> users)
  {
    this.users = users;
  }
}
