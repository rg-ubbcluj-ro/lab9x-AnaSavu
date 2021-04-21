package ro.ubb.bikes.core.repository;

import org.springframework.data.domain.Sort;
import ro.ubb.bikes.core.model.Client;

import java.util.List;

public interface ClientJpaRepository extends IRepository<Client, Long> {
    //methods from JPA:
    //findAll: returns List<Client>
    //findById: returns Optional<Client>, found entity or null
    //save: returns Client
    //deleteById: returns void
    //we don't have an update method -> findById, ifPresent, set wanted parameters

    List<Client> findByNameIsContaining(String name);
    List<Client> findByOrderByName();
    //List<Client> findByName(Sort sort);

}
