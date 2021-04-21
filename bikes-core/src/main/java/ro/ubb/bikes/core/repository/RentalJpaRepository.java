package ro.ubb.bikes.core.repository;

import ro.ubb.bikes.core.model.Rental;

import java.util.List;

public interface RentalJpaRepository extends IRepository<Rental, Long> {
    List<Rental> findByDaysRentedGreaterThanEqual(int daysRented);
    List<Rental> findByOrderByDaysRentedDesc();
    //methods from JPA:
    //findAll: returns List<Rental>
    //findById: returns Optional<Rental>, found entity or null
    //save: returns Rental
    //deleteById: returns void
    //we don't have an update method -> findById, ifPresent, set wanted parameters
}
