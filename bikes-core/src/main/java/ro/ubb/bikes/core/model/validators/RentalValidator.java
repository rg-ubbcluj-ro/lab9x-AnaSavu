package ro.ubb.bikes.core.model.validators;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Rental;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.Optional;

@Component
public class RentalValidator implements Validator<Rental>{
    /**
     * Validates the Rental entity
     * A rental is valid if:
     * - id: not null/empty, an Long > 0
     * - daysRented: > 0
     * - bike: > 0 and not null
     * - client: > 0 and not null
     *
     * @param entity must be Rental
     * @throws ValidatorException if the Rental is not valid
     */

    @Override
    public void validate(Rental entity) throws ValidatorException {
//        //id
//        Optional<Long> optionalID = Optional.of(entity.getId());
//        optionalID.filter(x -> x <= 0).ifPresent(e -> { throw new ValidatorException("ID must be greater than 0!"); });

        //days
        Optional<Integer> optionalDaysRented = Optional.of(entity.getDaysRented());
        optionalDaysRented.filter(x -> x <= 0)
                .ifPresent(e -> { throw new ValidatorException("DaysRented must be greater than 0!"); });

        //bikeid
        Optional<Long> optionalBikeID = Optional.of(entity.getBikeID());
        optionalBikeID.filter(x -> x <= 0).ifPresent(e -> { throw new ValidatorException("BikeID must be greater than 0!"); });

        //clientid
        Optional<Long> optionalClientID = Optional.of(entity.getClientID());
        optionalClientID.filter(x -> x <= 0).ifPresent(e -> { throw new ValidatorException("ClientID must be greater than 0!"); });

        //employeeID
        Optional<Long> optionalEmployeeID = Optional.of(entity.getEmployeeID());
        optionalEmployeeID.filter(x -> x<= 0).ifPresent(e -> {throw  new ValidatorException("EmployeeID must be greater than 0!");});

        //shopID
        Optional<Long> optionalShopID = Optional.of(entity.getShopID());
        optionalShopID.filter(x -> x<= 0).ifPresent(e -> {throw  new ValidatorException("ShopID must be greater than 0!");});

    }
}
