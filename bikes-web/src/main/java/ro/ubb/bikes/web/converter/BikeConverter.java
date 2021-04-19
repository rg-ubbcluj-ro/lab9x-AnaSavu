package ro.ubb.bikes.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.web.dto.BikeDto;

@Component
public class BikeConverter extends BaseConverter<Bike, BikeDto>{
    private static final Logger log = LoggerFactory.getLogger(BikeConverter.class);

    @Override
    public Bike convertDtoToModel(BikeDto dto) {
        throw new RuntimeException("Not yet implemented!");
    }

    @Override
    public BikeDto convertModelToDto(Bike bike) {
        BikeDto bikeDto = new BikeDto(bike.getSerialNumber(),
                bike.getManufacturer(), bike.getColor(), bike.getPrice());
        bikeDto.setId(bike.getId());
        return bikeDto;
    }
}
