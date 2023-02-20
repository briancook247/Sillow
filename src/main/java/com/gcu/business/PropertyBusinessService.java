package com.gcu.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gcu.model.PropertyModel;

public class PropertyBusinessService implements PropertyBusinessServiceInterface
{

    @Override
    public void test() {
        System.out.println("Test method in PropertyBusinessService is working.");
    }

    @Override
    public List<PropertyModel> getAllProperties() {
       List<PropertyModel> properties = new ArrayList<PropertyModel>();
       Date date = new Date();
       properties.add(new PropertyModel("Big House", "Phoenix", 7000, "bigphoto.jpg", "Really, really big house", 600000.00, date));
       properties.add(new PropertyModel("Small House", "Phoenix", 1200, "smallphoto.jpg", "Really, really small house", 80000.00, date));
       return properties;
    }

}