package ro.ubb.bikes.core.model.validators;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Employee;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.Optional;

@Component
public class EmployeeValidator implements Validator<Employee> {
    /**
     * Validates the Employee entity.
     * An employee is valid if:
     * id: Long > 0
     * name: not empty
     * position: can't be different from [cashier, manager, director]
     * workedHours -> Integer > 0, can't work more than 8 hours a day
     *
     * @param entity must be Employee
     * @throws ValidatorException if the Employee is not valid
     */

    @Override
    public void validate(Employee entity) throws ValidatorException {
//        //id
//        Optional<Long> optionalID = Optional.of(entity.getId());
//        optionalID.filter(x -> x <= 0)
//                .ifPresent(e -> { throw new ValidatorException("ID must be greater than 0!"); });

        //name
        Optional<String> optionalName = Optional.of(entity.getName());
        optionalName.filter(x -> x.equals(""))
                .ifPresent(e -> { throw new ValidatorException("Name must be a non-empty String!"); });

        //position
        Optional<String> optionalPosition = Optional.of(entity.getPosition());
        optionalPosition.filter(x -> x.equals("cashier") || x.equals("manager") || x.equals("director"))
                .orElseThrow(() -> new ValidatorException("Position must be cashier/manager/director!"));

        //hours
        Optional<Integer> optionalWorkedHours = Optional.of(entity.getWorkedHours());
        optionalWorkedHours.filter(x -> x <= 0 || x > 8)
                .ifPresent(e -> { throw new ValidatorException("WorkedHours must be greater than 0, less than 8!"); });
    }
}
