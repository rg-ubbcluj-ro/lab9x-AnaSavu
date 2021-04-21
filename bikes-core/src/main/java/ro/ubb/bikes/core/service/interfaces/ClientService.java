package ro.ubb.bikes.core.service.interfaces;

import org.springframework.stereotype.Service;
import ro.ubb.bikes.core.model.Client;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.List;
import java.util.Set;

public interface ClientService extends ServiceCommon<Long, Client> {

    @Override
    Client add(Client entity) throws ValidatorException;

    @Override
    Client delete(Long id) throws ValidatorException;

    @Override
    Client update(Client entity) throws ValidatorException;

    @Override
    List<Client> getAll();

    @Override
    Client exist(Long id) throws ValidatorException;

    List<Client> filter(String givenString);

    List<Client> sort();
}
