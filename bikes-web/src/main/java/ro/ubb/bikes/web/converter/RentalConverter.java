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
        model.setShopID(dto.getShopID());
        return model;
    }

    @Override
    public RentalDto convertModelToDto(Rental rental) {
        RentalDto rentalDto = new RentalDto(rental.getDaysRented(), rental.getBikeID(), rental.getClientID(), rental.getEmployeeID(), rental.getShopID());
        rentalDto.setId(rental.getId());

        return rentalDto;
    }
}
