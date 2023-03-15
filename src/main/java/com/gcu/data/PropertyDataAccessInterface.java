package com.gcu.data;
import java.util.List;
import com.gcu.model.PropertyModel;

public interface PropertyDataAccessInterface 
{
    public List<PropertyModel> getProperties();
    public int addOne(PropertyModel newProperty);
    public List<PropertyModel> searchProperties(String searchTerm);
}