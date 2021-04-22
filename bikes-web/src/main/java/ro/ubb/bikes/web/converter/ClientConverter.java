package ro.ubb.bikes.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Client;
import ro.ubb.bikes.web.dto.ClientDto;

@Component
public class ClientConverter extends BaseConverter<Client, ClientDto>{
    @Override
    public Client convertDtoToModel(ClientDto dto) {
        var model = new Client();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setAge(dto.getAge());
        model.setPhoneNumber(dto.getPhoneNumber());
        return model;
    }

    @Override
    public ClientDto convertModelToDto(Client client) {
        ClientDto dto = new ClientDto(client.getName(), client.getAge(), client.getPhoneNumber());
        dto.setId(client.getId());
        return dto;
    }
}
