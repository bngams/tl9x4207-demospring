package fr.cesi.poealtran.demospring.services;

import fr.cesi.poealtran.demospring.entities.Contact;
import fr.cesi.poealtran.demospring.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Contact> findContactById(Long id) {
        // use Optional
        return this.contactRepo.findById(id);
    }

    public Contact saveContact(Contact c) {
        return this.contactRepo.save(c);
    }

    public void deleteContactById(Long id) {
        this.contactRepo.deleteById(id);
    }

    public boolean existsContactById(Long id) {
        return this.contactRepo.existsById(id);
    }
}
