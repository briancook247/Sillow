package com.gcu.business;
import com.gcu.model.LoginModel;

// Class to define login values and check validation
public class ValidLogins implements SecurityServiceInterface
{
    @Override
    public boolean isAuthenticated(LoginModel loginModel)
    {
        String[][] validLogins = new String[][]
		{
			{"cartercampbell", "password"},
			{"briancook", "password"}
		};

        boolean success = false;
		for(int i = 0; i < validLogins.length; i++)
		{
			if(loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1]))
			{
				success = true;
			}
		}
			if(success)
			{
                // login success
				return true;
			}
			else
			{
                // login failed
				return false;
			}
    }
}
