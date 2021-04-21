package ro.ubb.bikes.core.service.interfaces;

import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.List;
import java.util.Set;

public interface BikeService extends ServiceCommon<Long, Bike> {

    @Override
    Bike add(Bike entity) throws ValidatorException;

    @Override
    Bike delete(Long id) throws ValidatorException;

    @Override
    Bike update(Bike entity) throws ValidatorException;

    @Override
    List<Bike> getAll();

    @Override
    Bike exist(Long id) throws ValidatorException;

    List<Bike> filter(int price);

    List<Bike> sort();
}
