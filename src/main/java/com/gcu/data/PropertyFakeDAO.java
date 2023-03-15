package com.gcu.data;
import java.util.List;

import com.gcu.data.PropertyDataAccessInterface;
import com.gcu.model.PropertyModel;
import java.util.ArrayList;

public class PropertyFakeDAO implements PropertyDataAccessInterface 
{
    private List<PropertyModel> properties = new ArrayList<PropertyModel>();

    @Override
    public int addOne(PropertyModel newProperty) 
    {
        boolean success = properties.add(newProperty);
        System.out.println("I added one item. Now there are " + properties.size() + " items in the list.");
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<PropertyModel> getProperties() 
    {
        return properties;
    }

    @Override
    public List<PropertyModel> searchProperties(String searchTerm) 
    {
        List<PropertyModel> foundItems = new ArrayList<PropertyModel>();
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getNameOfProperty().toLowerCase().contains(searchTerm.toLowerCase())) {
                foundItems.add(properties.get(i));
            }
        }
        System.out.println("I searched for " + searchTerm + " and found " + foundItems.size() + " items.");
        return foundItems;
    }
    
}