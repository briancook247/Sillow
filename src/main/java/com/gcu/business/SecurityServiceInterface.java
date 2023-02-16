package com.gcu.business;
import com.gcu.model.LoginModel;

// interface to check authentication
public interface SecurityServiceInterface 
{
    public boolean isAuthenticated(LoginModel loginModel);
}
