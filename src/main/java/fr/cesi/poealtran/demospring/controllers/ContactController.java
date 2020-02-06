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

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        return new ResponseEntity<>(this.contactService.findContactById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Contact> postContact(@RequestBody Contact c) {
        return new ResponseEntity<>(this.contactService.saveContact(c),
                HttpStatus.OK);
    }

    // we can see @PutMapping("/{id}")
    @PutMapping("")
    public ResponseEntity<Contact> putContact(@RequestBody Contact c) {
        // if we don't specify an id, it will create a new contact
        // if we don't want to allow creation on PUT
        // we need to check if contact exist before update (to avoid creation)
        if(this.contactService.existsContactById(c.getId()))
            return new ResponseEntity<>(this.contactService.saveContact(c),
                HttpStatus.OK);
        else
            return new ResponseEntity<>(c,
                    HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactById(@PathVariable Long id) {
        this.contactService.deleteContactById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    // simple way
    /*
    @DeleteMapping("/{id}")
    public void deleteContactById(@PathVariable Long id) {
        this.contactService.deleteContactById(id);
    }
    */

}
