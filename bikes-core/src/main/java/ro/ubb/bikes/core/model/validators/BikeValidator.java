package ro.ubb.bikes.core.model.validators;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.Optional;

@Component
public class BikeValidator implements Validator<Bike> {
    /**
     * Validates the Bike entity.
     * A bike is valid if:
     * id: not null, >0
     * serialNumber: not null,not empty
     * manufacturer: not null,not empty
     * color: not null, not empty
     * price>0
     *
     * @param entity must be a Bike
     * @throws ValidatorException if bike not valid
     */

    @Override
    public void validate(Bike entity) throws ValidatorException {
//        //id
//        Optional<Long> optionalID = Optional.of(entity.getId());
//        optionalID.filter(x -> x <= 0).ifPresent(e -> { throw new ValidatorException("ID must be greater than 0!"); });

        //serialnumber
        Optional<String> optionalSerialNumber = Optional.of(entity.getSerialNumber());
        optionalSerialNumber.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("SerialNumber must be a non-empty String!"); });

        //manufacturer
        Optional<String> optionalManufacturer = Optional.of(entity.getManufacturer());
        optionalManufacturer.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("Manufacturer must be a non-empty String!"); });

        //color
        Optional<String> optionalColor = Optional.of(entity.getColor());
        optionalColor.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("Color must be a non-empty String!"); });

        //price
        Optional<Integer> optionalPrice = Optional.of(entity.getPrice());
        optionalPrice.filter(x -> x <= 0).ifPresent(e -> { throw new ValidatorException("Price must be greater than 0!"); });

    }

}
