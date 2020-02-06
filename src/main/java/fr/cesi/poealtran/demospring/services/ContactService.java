package fr.cesi.poealtran.demospring.services;

import fr.cesi.poealtran.demospring.entities.Contact;
import fr.cesi.poealtran.demospring.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service <=> @Component <=> @Bean
@Service
public class ContactService {

    // DI better in constructor
    // @Autowired, @Inject, @Resource
    private ContactRepository contactRepo;

    // Dependency Injection
    @Autowired
    public ContactService(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    public List<Contact> findAllContacts() {
        // (CAST) Iterable<Contact>
        return (List<Contact>) contactRepo.findAll();
    }

    public Contact findContactById(Long id) {
        // call repository
        return null;
    }

    public Contact saveContact(Contact c) {
        return this.contactRepo.save(c);
    }
}
