package com.example.demo.controllers;

import com.example.demo.entities.JewelleryItem;
import com.example.demo.implementations.JewelleryRepositoryService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class DemoAppController {
    private JewelleryRepositoryService service;

    public DemoAppController(JewelleryRepositoryService service) {
        super();
        this.service = service;
    }

    @GetMapping("/items")
    public String listItems (Model model) {
        model.addAttribute("items", service.getItems());
        return "items";
    }

    @GetMapping("/items/add")
    public String createItemForm (Model model) {
// create item object to hold item form data
        JewelleryItem item = new JewelleryItem();
        model.addAttribute("item", item);
        return "add_item";
    }
    @PostMapping("/items")
    public String saveItem(@ModelAttribute("item") JewelleryItem item) { service.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/items/edit/{id}")
    public String editItemForm(@PathVariable Integer id, Model model) {
        model.addAttribute("item", service.getItemById(id));
        return "edit_item";
    }

    @PostMapping("/items/{id}")
    public String updateItem(@PathVariable Integer id,
                                @ModelAttribute("item") JewelleryItem item,
                                Model model) {

        // get item from database by id
        JewelleryItem existingItem = service.getItemById(id);
        existingItem.setId(id);
        existingItem.setName(item.getName());
        existingItem.setType(item.getType());
        existingItem.setMaterial(item.getMaterial());
        existingItem.setCost(item.getCost());

        // save updated item object
        service.updateItem(existingItem);
        return "redirect:/items";
    }

    @GetMapping("/items/{id}")
    public String deleteItem(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        service.deleteItemById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Successfully deleted!");
        return "redirect:/items";
    }
}
