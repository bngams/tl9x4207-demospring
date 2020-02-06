package fr.cesi.poealtran.demospring.repositories;

import fr.cesi.poealtran.demospring.entities.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// @Repository <=> @Component <=> @Bean (Bean Spring)
@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    // Query Methods => methods to JPQL then SQL
    // SELECT c FROM Contact WHERE c.name = ?1
    // SELECT * FROM contact WHERE lastname = ?1
    public Contact findByName(String name);

    // @Query => write JPQL or SQL query
    @Query(value = "SELECT * FROM contacts WHERE lastname LIKE %?1%",
        nativeQuery = true)
    public Contact findWithName(String name);
}
