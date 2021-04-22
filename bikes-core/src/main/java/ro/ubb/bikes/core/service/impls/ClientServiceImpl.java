package ro.ubb.bikes.core.service.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.bikes.core.model.Client;
import ro.ubb.bikes.core.model.Rental;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;
import ro.ubb.bikes.core.model.validators.ClientValidator;
import ro.ubb.bikes.core.repository.ClientJpaRepository;
import ro.ubb.bikes.core.repository.RentalJpaRepository;
import ro.ubb.bikes.core.service.interfaces.ClientService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    public static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientJpaRepository clientJpaRepository;

    @Autowired
    private RentalJpaRepository rentalJpaRepository;

    @Autowired
    private ClientValidator clientValidator;

    @Override
    public Client add(Client entity) throws ValidatorException {
        log.trace("add - method entered: client={}", entity);

        clientValidator.validate(entity);
        Client savedClient = clientJpaRepository.save(entity);

        log.trace("add - method finished: client={}", savedClient);
        return savedClient;
    }

    @Override
    public Client delete(Long id) throws ValidatorException {
        log.trace("delete - method entered: id={}", id);

        Optional<Client> optionalClient = clientJpaRepository.findById(id);
        optionalClient.ifPresentOrElse(
                (client) -> {
                    clientJpaRepository.deleteById(client.getId());
                    log.debug("delete - deleted: client={}", client);
                },
                () -> {
                    throw new ValidatorException("DELETE - Client ID not in database");
                }
        );

        log.trace("delete - method finished");
        return optionalClient.get();
    }

    @Override
    @Transactional
    public Client update(Client entity) throws ValidatorException {
        log.trace("update - method entered: client={}", entity);
        clientValidator.validate(entity);

        Client currentClient = clientJpaRepository.findById(entity.getId()).orElseThrow(() -> new ValidatorException("UPDATE - Client not in database"));
        log.trace("update - before update: client={}", currentClient);

        currentClient.setName(entity.getName());
        currentClient.setAge(entity.getAge());
        currentClient.setPhoneNumber(entity.getPhoneNumber());
        log.debug("update - updated: client={}", currentClient);

        log.trace("update - method finished");
        return entity;
    }

    @Override
    public List<Client> getAll() {
        log.trace("getAll --- method entered");

        List<Client> clients = clientJpaRepository.findAll();

        log.trace("getAll: result={}", clients);

        return clients;
    }

    @Override
    public Client exist(Long id) throws ValidatorException {
        log.trace("exist - method entered: id={}", id);

        Client client = clientJpaRepository.findById(id).orElseThrow(() -> new ValidatorException("EXIST - Client ID not in database"));

        log.trace("exist - method finished client found={}", client);

        return client;
    }

    @Override
    public List<Client> filter(String name) {
        log.trace("filterClient - method entered: givenString={}", name);

        List<Client> clients = clientJpaRepository.findByNameIsContaining(name);

        log.trace("filterClient - method finished filtered clients={}", clients);

        return clients;
    }

    @Override
    public List<Client> sort() {
        log.trace("sortClient - method entered");
        Sort sort=Sort.by("name").descending();
        List<Client> clients = clientJpaRepository.findAll(sort);
        log.trace("reportClient - method finished client:{}", clients);

        return clients;
    }
}
