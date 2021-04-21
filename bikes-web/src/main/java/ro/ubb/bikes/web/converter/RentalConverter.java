package ro.ubb.bikes.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Rental;
import ro.ubb.bikes.web.dto.RentalDto;

@Component
public class RentalConverter extends BaseConverter<Rental, RentalDto> {
    @Override
    public Rental convertDtoToModel(RentalDto dto) {
        var model = new Rental();
        model.setId(dto.getId());
        model.setDaysRented(dto.getDaysRented());
        model.setBikeID(dto.getBikeID());
        model.setClientID(dto.getClientID());
        model.setEmployeeID(dto.getEmployeeID());

        return model;
    }

    @Override
    public RentalDto convertModelToDto(Rental rental) {
        RentalDto rentalDto = new RentalDto(rental.getDaysRented(), rental.getBikeID(), rental.getClientID(), rental.getEmployeeID());
        rentalDto.setId(rental.getId());

        return rentalDto;
    }
}
