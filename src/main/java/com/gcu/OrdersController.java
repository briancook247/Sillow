package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.PropertyBusinessServiceInterface;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
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


    @GetMapping("/delete/{nameOfProperty}")
    public String deleteProduct(@PathVariable(value="nameOfProperty")String nameOfProperty, Model model)
    {
        List<PropertyModel> properties = propertyService.getProperties();
        PropertyModel property = properties.stream().filter(p -> p.getNameOfProperty()==nameOfProperty).findFirst().get();
        properties.remove(property);
        return "redirect:/orders/";
    }

  

}