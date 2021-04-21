package ro.ubb.bikes.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.web.dto.BikeDto;

@Component
public class BikeConverter extends BaseConverter<Bike, BikeDto> {
    @Override
    public Bike convertDtoToModel(BikeDto dto) {
        var model = new Bike();
        model.setId(dto.getId());
        model.setSerialNumber(dto.getSerialNumber());
        model.setManufacturer(dto.getManufacturer());
        model.setColor(dto.getColor());
        model.setPrice(dto.getPrice());
        return model;
    }

    @Override
    public BikeDto convertModelToDto(Bike bike) {
        BikeDto dto = new BikeDto(bike.getSerialNumber(), bike.getManufacturer(), bike.getColor(), bike.getPrice());
        dto.setId(bike.getId());
        return dto;
    }
}
