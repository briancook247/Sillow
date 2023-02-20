package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gcu.business.ValidLogins;
import com.gcu.business.PropertyBusinessService;
import com.gcu.business.PropertyBusinessServiceInterface;
import com.gcu.business.SecurityServiceInterface;

// Class to handle dependency injection
@Configuration
public class SpringConfig
{
    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService()
    {
        return new ValidLogins();
    }

    @Bean(name="propertyBusinessService")
    public PropertyBusinessServiceInterface getPropertyBusiness()
    {
        return new PropertyBusinessService();
    }
}