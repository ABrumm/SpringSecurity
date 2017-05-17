package com.brumma.model;

import java.io.Serializable;

public class Role implements Serializable
{

    private static final long serialVersionUID = -6380846909037721618L;
    
    private int roleId;
    
    private String rolename;

    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId( int roleId )
    {
        this.roleId = roleId;
    }

    public String getRolename()
    {
        return rolename;
    }

    public void setRolename( String rolename )
    {
        this.rolename = rolename;
    }

}
