package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.PropertyBusinessServiceInterface;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gcu.model.PropertyModel;

@Controller
@RequestMapping("/orders")
public class OrdersController 
{
    @Autowired
    private PropertyBusinessServiceInterface propertyService;

    @GetMapping("/")
    public String showAllProperties(Model model)
    {
        List<PropertyModel> properties = propertyService.getProperties();
        model.addAttribute("title", "Available Properties");
        model.addAttribute("properties", properties);
        return "properties.html";
    }

    @GetMapping("/new")
    public String newProperty(Model model)
    {
        model.addAttribute("property", new PropertyModel());
        return "newProperty";
    }

    @PostMapping("/processNew")
    public String processNew(PropertyModel property)
    {
        propertyService.addOne(property);
        return "redirect:/orders/";
    }

    @PostMapping("/search")
    public String searchProduct(String searchTerm, Model model) 
    { 
    List<PropertyModel> properties;
    // Check for null search term
    if (searchTerm != null) {
        properties = propertyService.searchProperties(searchTerm.toLowerCase());
    } else {
        // Return all properties
        properties = propertyService.getProperties();
    }
    model.addAttribute("resultProperties", properties);
    return "searchResults";
    }


    @DeleteMapping("/delete/{nameOfProperty}")
    public String deleteProduct(@PathVariable(value="nameOfProperty")String nameOfProperty, Model model)
    {
        List<PropertyModel> properties = propertyService.getProperties();
        for(int i = 0; i < properties.size(); i++)
        {
            if(properties.get(i).getNameOfProperty().equals(nameOfProperty))
            {
                propertyService.deleteOne(nameOfProperty);
            }
        }
        return "redirect:/orders/";
    }

    @PutMapping("/")
    public String updateProperty(@RequestBody PropertyModel updateProperty)
    {
        propertyService.updateOne(updateProperty.getNameOfProperty(), updateProperty);
        return "redirect:/";
    }

  

}