package ro.ubb.bikes.core.model.validators;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Client;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.Optional;

@Component
public class ClientValidator implements Validator<Client> {

    /**
     * Validates the Client entity.
     * A client is valid if:
     * - id: Long > 0
     * - name: not empty
     * - age: Integer > 0
     * - phoneNumber: not empty
     *
     * @param entity must be Client
     * @throws ValidatorException if the Client is not valid
     */

    @Override
    public void validate(Client entity) throws ValidatorException {
//        //id
//        Optional<Long> optionalID = Optional.of(entity.getId());
//        optionalID.filter(x -> x <= 0).ifPresent(e -> { throw new ValidatorException("ID must be greater than 0!"); });

        //name
        Optional<String> optionalName = Optional.of(entity.getName());
        optionalName.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("Name must be a non-empty String!"); });

        //age
        Optional<Integer> optionalAge = Optional.of(entity.getAge());
        optionalAge.filter(x -> x <= 0).ifPresent(e -> { throw new ValidatorException("Age must be greater than 0!"); });

        //phone
        Optional<String> optionalPhoneNumber = Optional.of(entity.getPhoneNumber());
        optionalPhoneNumber.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("PhoneNumber must be a non-empty String!"); });
    }
}
