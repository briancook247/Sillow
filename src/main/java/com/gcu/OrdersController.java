package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


}