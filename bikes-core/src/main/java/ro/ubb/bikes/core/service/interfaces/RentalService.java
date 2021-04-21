package ro.ubb.bikes.core.service.interfaces;

import ro.ubb.bikes.core.model.Rental;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.List;
import java.util.Set;

public interface RentalService extends ServiceCommon<Long, Rental> {

    @Override
    Rental add(Rental entity) throws ValidatorException;

    @Override
    Rental delete(Long id) throws ValidatorException;

    @Override
    Rental update(Rental entity) throws ValidatorException;

    @Override
    List<Rental> getAll();

    @Override
    Rental exist(Long id) throws ValidatorException;

    List<Rental> filter(int daysRented);

    List<Rental> sort();
}
