CREATE TABLE IF NOT EXISTS usercontacts (
	userID int(11) NOT NULL,
	contactID int(11) NOT NULL,
	PRIMARY KEY (userID, contactID),
	KEY fk_user (userID),
	KEY fk_contact (contactID),
	CONSTRAINT fk_user FOREIGN KEY (userID) REFERENCES userdata (userId),
	CONSTRAINT fk_contact FOREIGN KEY (contactID) REFERENCES contactdata (contact_id)
);