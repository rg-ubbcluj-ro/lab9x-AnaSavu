package ro.ubb.bikes.core.model.validators;

import ro.ubb.bikes.core.model.exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
