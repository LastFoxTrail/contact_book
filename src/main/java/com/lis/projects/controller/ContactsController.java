package com.lis.projects.controller;

import com.lis.projects.dao.ContactDaoImpl;
import com.lis.projects.model.Contact;
import com.lis.projects.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
    @Autowired
    private ContactService service;

    @RequestMapping("/")
    public String getAll(Model model) {
        List<Contact> contactsList = service.get();
        model.addAttribute("contactsList", contactsList);

        return "contacts-list";
    }

    @RequestMapping("/new")
    public String addContact(Model model) {
        Contact contact = new Contact();
        model.addAttribute("newContact", contact);

        return "new-contact";
    }

    @RequestMapping("/save")
    public String saveContact(@ModelAttribute("newContact") @Valid Contact contact, BindingResult result) {

        if (result.hasErrors()) {
            return "new-contact";

        } else {

            if (contact.getId() == null) {
                service.save(contact);

            } else if (contact.getId() >= 0) {
                service.update(contact);
            }

            return "redirect:/contacts/";
        }
    }

    @RequestMapping("/update")
    public String updateContact(@RequestParam("updateContact") Long id, Model model) {
        Contact contact = service.getById(id);
        model.addAttribute("newContact", contact);

        return "new-contact";
    }

    @RequestMapping("/delete")
    public String deleteContact(@RequestParam("deleteContactId") Long id) {
        service.delete(id);

        return "redirect:/contacts/";
    }
}