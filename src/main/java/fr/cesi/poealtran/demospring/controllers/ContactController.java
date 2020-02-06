package fr.cesi.poealtran.demospring.controllers;

import fr.cesi.poealtran.demospring.entities.Contact;
import fr.cesi.poealtran.demospring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController <=> @Component <=> @Bean
@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // URL /contacts
    @GetMapping("")
    public ResponseEntity<List<Contact>> getContacts() {
        return new ResponseEntity<>(this.contactService.findAllContacts(), HttpStatus.OK);
    }
//
//    @GetMapping("/{id})
//    public Contact getContactById(@PathVariable int id) {
//
//    }

    @PostMapping("")
    public ResponseEntity<Contact> postContact(@RequestBody Contact c) {
        return new ResponseEntity<>(this.contactService.saveContact(c),
                HttpStatus.CREATED);
    }

}
