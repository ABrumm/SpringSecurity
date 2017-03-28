package com.brumma.common;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.security.core.context.SecurityContextHolder;

import com.brumma.dao.ContactDaoI;
import com.brumma.model.Contact;
import com.brumma.model.Contacts;

public class InitialBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Locale currentLocale;
	private Contact user;
	private ArrayList<Contact> userList;
	private ContactDaoI contactService;
	private static Iterator<Locale> availableLocalesIT;
	private static Map<String, Locale> availableLocalesMap = new LinkedHashMap<String, Locale>();
	
	static {
		availableLocalesIT = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
		
		while(availableLocalesIT.hasNext()){
			Locale localeIt = availableLocalesIT.next();
			availableLocalesMap.put(localeIt.toString(),localeIt);
		}		
	}
	
	@PostConstruct
	public void initMethod() {
		
		currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		this.user = new Contact();
		setUserList(contactService.getuserList());
		
	}

	public void resetUser() {
		this.user = new Contact();
	}

	public void saveNewUser() {
		if (contactService.saveUser(this.user)) {
			this.userList.add(this.user);
		}
	}

	public void deleteUser(Contact p_contact) {
		this.userList.remove(p_contact);
		contactService.deleteUser(p_contact);
	}

	public void updateUser(Contact p_contact) {
		int i = 0;
		for (Contact i_user : this.userList) {
			if (i_user.getContact_id() == p_contact.getContact_id()) {
				break;
			}
			i++;
		}
		if (contactService.updateUser(p_contact)) {
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
			if (contactService.saveUser(i_user)) {
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

	public void setContactService(ContactDaoI p_contactService) {
		this.contactService = p_contactService;
	}

	public Locale getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(String p_currentLocale) {
		Locale l_locale = getAvailableLocalesMap().get(p_currentLocale);
		
		if( l_locale != null) {
			this.currentLocale = l_locale;	
			FacesContext.getCurrentInstance().getViewRoot().setLocale(l_locale);
		}
	}

	public Map<String, Locale> getAvailableLocalesMap() {
		return availableLocalesMap;
	}
}
