package ro.ubb.bikes.core.service.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.bikes.core.model.*;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;
import ro.ubb.bikes.core.model.validators.RentalValidator;
import ro.ubb.bikes.core.repository.*;
import ro.ubb.bikes.core.service.interfaces.RentalService;

import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {
    public static final Logger log = LoggerFactory.getLogger(RentalServiceImpl.class);
    @Autowired
    private BikeJpaRepository bikeJpaRepository;

    @Autowired
    private ClientJpaRepository clientJpaRepository;

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    private ShopJpaRepository shopJpaRepository;

    @Autowired
    private RentalJpaRepository rentalJpaRepository;

    @Autowired
    private RentalValidator rentalValidator;

    @Override
    public Rental add(Rental entity) throws ValidatorException {
        log.trace("add - method entered: rental={}", entity);

        Bike b1 = bikeJpaRepository.findById(entity.getBikeID()).orElseThrow(() -> new ValidatorException("EXIST - Bike ID not in database!"));
        Client c1 = clientJpaRepository.findById(entity.getClientID()).orElseThrow(() -> new ValidatorException("EXIST - Client ID not in database!"));
        Employee e1 = employeeJpaRepository.findById(entity.getEmployeeID()).orElseThrow(() -> new ValidatorException("EXIST - Employee ID not in database!"));
        Shop s1 = shopJpaRepository.findById(entity.getShopID()).orElseThrow(() -> new ValidatorException("EXIST - Shop ID not in database!"));
        rentalValidator.validate(entity);
        Rental rental = rentalJpaRepository.save(entity);

        log.trace("add - method finished: rental={}", rental);
        return rental;
    }

    @Override
    public Rental delete(Long id) throws ValidatorException {
        log.trace("delete - method entered: id={}", id);

        Optional<Rental> rental = rentalJpaRepository.findById(id);
        rental.ifPresentOrElse(
                (r1) -> {
                    rentalJpaRepository.deleteById(r1.getId());
                    log.debug("delete - deleted: rental={}", r1);
                },
                () -> {
                    throw new ValidatorException("DELETE - Rental ID not in database!");
                }
        );

        log.trace("delete - method finished");
        return rental.get();
    }

    @Override
    @Transactional
    public Rental update(Rental entity) throws ValidatorException {
        log.trace("update - method entered: rental={}", entity);

        rentalValidator.validate(entity);
        Rental rental = rentalJpaRepository.findById(entity.getId()).orElseThrow(() -> new ValidatorException("UPDATE - Rental not in database!"));

        log.trace("update - before update: rental={}", rental);
        Bike b1 = bikeJpaRepository.findById(entity.getBikeID()).orElseThrow(() -> new ValidatorException("EXIST - Bike ID not in database!"));
        Client c1 = clientJpaRepository.findById(entity.getClientID()).orElseThrow(() -> new ValidatorException("EXIST - Client ID not in database!"));
        Employee e1 = employeeJpaRepository.findById(entity.getEmployeeID()).orElseThrow(() -> new ValidatorException("EXIST - Employee ID not in database!"));
        Shop s1 = shopJpaRepository.findById(entity.getShopID()).orElseThrow(() -> new ValidatorException("EXIST - Shop ID not in database!"));
        rental.setDaysRented(entity.getDaysRented());
        rental.setBikeID(entity.getBikeID());
        rental.setClientID(entity.getClientID());
        rental.setEmployeeID(entity.getEmployeeID());
        rental.setShopID(entity.getShopID());
        log.debug("update - updated: rental={}", rental);

        log.trace("update - mehtod finished");
        return entity;
    }

    @Override
    public List<Rental> getAll() {
        log.trace("getAll - method entered");

        List<Rental> rentals = rentalJpaRepository.findAll();

        log.trace("getAll: rentals{}", rentals);
        return rentals;
    }

    @Override
    public Rental exist(Long id) throws ValidatorException {
        log.trace("exist - method enetered: id={}", id);

        Rental rental = rentalJpaRepository.findById(id).orElseThrow(() -> new ValidatorException("EXIST - Rental ID not in database!"));

        log.trace("exist - method finished: rental={}", rental);
        return rental;
    }

    @Override
    public List<Rental> filter(int daysRented) {
        log.trace("filter - method entered: daysRented={}", daysRented);

        List<Rental> rentals = rentalJpaRepository.findByDaysRentedGreaterThanEqual(daysRented);

        log.trace("filter: rentals={}", rentals);
        return rentals;
    }

    @Override
    public List<Rental> sort() {
        log.trace("sort - method entered");

        List<Rental> rentals = rentalJpaRepository.findByOrderByDaysRentedDesc();

        log.trace("sort: rentals={}", rentals);
        return rentals;
    }
}
