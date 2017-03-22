package com.brumma.common;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.brumma.dao.ContactDAO;
import com.brumma.model.Contact;
import com.brumma.model.Contacts;

public class InitialBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Contact user;
	private ArrayList<Contact> userList;
	private ContactDAO m_contactDAO;

	@PostConstruct
	public void initMethod() {
		this.user = new Contact();
		setUserList(m_contactDAO.getuserList());
	}

	public void resetUser() {
		this.user = new Contact();
	}

	public void saveNewUser() {
		if (m_contactDAO.saveUser(this.user)) {
			this.userList.add(this.user);
		}
	}

	public void deleteUser(Contact p_contact) {
		this.userList.remove(p_contact);
		m_contactDAO.deleteUser(p_contact);
	}

	public void updateUser(Contact p_contact) {
		int i = 0;
		for (Contact i_user : this.userList) {
			if (i_user.getContact_id() == p_contact.getContact_id()) {
				break;
			}
			i++;
		}
		if (m_contactDAO.updateUser(p_contact)) {
			this.userList.set(i, p_contact);
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile uFile = event.getFile();
		Contacts l_users = new Contacts();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] { Contacts.class });
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			l_users = (Contacts) unmarshaller.unmarshal(new InputStreamReader(uFile.getInputstream()));
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Contact i_user : l_users.getUsers()) {
			if (m_contactDAO.saveUser(i_user)) {
				this.userList.add(i_user);
			}
		}
	}

	public Contact getUser() {
		return this.user == null ? new Contact() : this.user;
	}

	public void setUser(Contact p_contact) {
		this.user = p_contact;
	}

	public ArrayList<Contact> getUserList() {
		return this.userList;
	}

	public void setUserList(ArrayList<Contact> userList) {
		this.userList = userList;
	}

	public void setContactDAO(ContactDAO m_contactDAO) {
		this.m_contactDAO = m_contactDAO;
	}
}
