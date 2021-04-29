package ro.ubb.bikes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.core.model.Client;
import ro.ubb.bikes.core.service.interfaces.ClientService;
import ro.ubb.bikes.web.converter.ClientConverter;
import ro.ubb.bikes.web.dto.BikeDto;
import ro.ubb.bikes.web.dto.BikesListDto;
import ro.ubb.bikes.web.dto.ClientDto;
import ro.ubb.bikes.web.dto.ClientsListDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    ClientDto addClient(@RequestBody ClientDto clientDto) {
        log.trace("addClient: dto={}", clientDto);

        var client = clientConverter.convertDtoToModel(clientDto);
        var addedClient = clientService.add(client);
        var resultClient = clientConverter.convertModelToDto(addedClient);

        log.trace("addClient: result={}", resultClient);

        return resultClient;
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteClient(@PathVariable Long id) {
        log.trace("deleteClient: id={}", id);
        clientService.delete(id);
        log.trace("deleteClient - method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    ClientDto updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        log.trace("updateClient: id={}, dto={}", id, clientDto);

        var client = clientConverter.convertDtoToModel(clientDto);
        var updatedClient = clientService.update(client);
        var resultClient = clientConverter.convertModelToDto(updatedClient);

        log.trace("updateClient: result={}", resultClient);

        return resultClient;
    }

//    @RequestMapping(value = "/clients")
//    ClientsListDto getAllClients() {
//        return new ClientsListDto(
//                clientConverter.convertModelsToDtos(
//                        clientService.getAll()
//                ));
//    }

    @RequestMapping(value = "/clients")
    List<ClientDto> getAllClients() {
        return new ArrayList<>(
                clientConverter.convertModelsToDtos(
                        clientService.getAll()
                ));
    }

    @RequestMapping(value = "/clients/filter/{name}", method = RequestMethod.GET)
    List<ClientDto> filterClientsByName(@PathVariable String name) {
        log.trace("filterClientsByName - method entered: name={}", name);

        List<Client> clients = clientService.filter(name);
        List<ClientDto> result = new ArrayList<>(clientConverter.convertModelsToDtos(clients));
        log.trace("filterClientsByName: result={}", result);
        return result;
    }

    @RequestMapping(value = "/clients/sort", method = RequestMethod.GET)
    List<ClientDto> sortClients() {
        log.trace("sortClients - method entered");

        List<Client> clients = clientService.sort();
        List<ClientDto> result = new ArrayList<>(clientConverter.convertModelsToDtos(clients));
        log.trace("clientSort: result={}", result);
        return result;
    }


}
