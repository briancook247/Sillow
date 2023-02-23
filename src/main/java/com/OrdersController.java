package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.PropertyBusinessServiceInterface;
import java.util.List;
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
        List<PropertyModel> properties = propertyService.getAllProperties();
        model.addAttribute("title", "These are all our properties");
        model.addAttribute("properties", properties);
        return "properties.html";
    }
}