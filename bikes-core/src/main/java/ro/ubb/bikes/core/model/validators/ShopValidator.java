package ro.ubb.bikes.core.model.validators;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Shop;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.Optional;

@Component
public class ShopValidator implements Validator<Shop> {
    @Override
    public void validate(Shop entity) throws ValidatorException {
        //name
        Optional<String> optionalName = Optional.of(entity.getName());
        optionalName.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("Name must be a non-empty String!"); });

        //city
        Optional<String> optionalCity = Optional.of(entity.getCity());
        optionalCity.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("City must be a non-empty String!"); });

    }
}
