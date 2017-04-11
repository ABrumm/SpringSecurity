package com.brumma.model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable
{

    private static final long serialVersionUID = -3831222815922769460L;

    private int userId;

    private String userName;

    private String userMail;

    private String userPassword;

    private String userActive;
    
    public String getUserName()
    {
        return userName;
    }

    public void setUserName( String userName )
    {
        this.userName = userName;
    }

    public String getUserMail()
    {
        return userMail;
    }

    public void setUserMail( String userMail )
    {
        this.userMail = userMail;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword( String userPassword )
    {
        this.userPassword = userPassword;
    }

    public String getUserActive()
    {
        return userActive;
    }

    public void setUserActive( String userActive )
    {
        this.userActive = userActive;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId( int userId )
    {
        this.userId = userId;
    }
}
