package ro.ubb.bikes.core.repository;


import ro.ubb.bikes.core.model.Bike;

import java.util.List;

public interface BikeJpaRepository extends IRepository<Bike, Long> {
    //methods from JPA:
    //findAll: returns List<Bike>
    //findById: returns Optional<Bike>, found entity or null
    //save: returns Bike
    //deleteById: returns void
    //we don't have an update method -> findById, ifPresent, set wanted parameters

    List<Bike> findByPriceLessThan(Integer price);
    List<Bike> findByOrderBySerialNumber();
}
