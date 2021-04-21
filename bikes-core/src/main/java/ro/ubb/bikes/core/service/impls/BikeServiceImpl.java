package ro.ubb.bikes.core.service.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.core.model.Rental;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;
import ro.ubb.bikes.core.model.validators.BikeValidator;
import ro.ubb.bikes.core.repository.BikeJpaRepository;
import ro.ubb.bikes.core.repository.RentalJpaRepository;
import ro.ubb.bikes.core.service.interfaces.BikeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BikeServiceImpl implements BikeService {
    public static final Logger log = LoggerFactory.getLogger(BikeServiceImpl.class);

    @Autowired
    private BikeJpaRepository bikeJpaRepository;

    @Autowired
    private RentalJpaRepository rentalJpaRepository;

    @Autowired
    private BikeValidator bikeValidator;

    @Override
    public Bike add(Bike entity) throws ValidatorException {
        log.trace("add - method entered: bike={}", entity);

        bikeValidator.validate(entity);
        Bike savedBike = bikeJpaRepository.save(entity);

        log.trace("add - method finished: bike={}", savedBike);
        return savedBike;
    }

    @Override
    public Bike delete(Long id) throws ValidatorException {
        log.trace("delete - method entered: id={}", id);

        Optional<Bike> optionalBike = bikeJpaRepository.findById(id);
        optionalBike.ifPresentOrElse(
        (bike) -> {
            bikeJpaRepository.deleteById(bike.getId());
            log.debug("delete - deleted: bike={}", bike);
        },
        () -> {
            throw new ValidatorException("DELETE - Bike ID not in database");
        }
        );

        log.trace("delete - method finished");
        return optionalBike.get();
    }

    @Override
    @Transactional
    public Bike update(Bike entity) throws ValidatorException {
        log.trace("update - method entered: bike={}", entity);
        bikeValidator.validate(entity);

        Bike currentBike = bikeJpaRepository.findById(entity.getId()).orElseThrow(() -> new ValidatorException("UPDATE - Bike not in database"));
        log.trace("update - before update: bike={}", currentBike);

        currentBike.setSerialNumber(entity.getSerialNumber());
        currentBike.setManufacturer(entity.getManufacturer());
        currentBike.setColor(entity.getColor());
        currentBike.setPrice(entity.getPrice());
        log.debug("update - updated: bike={}", currentBike);

        log.trace("update - method finished");
        return entity;
    }

    @Override
    public List<Bike> getAll() {
        log.trace("getAll --- method entered");
        List<Bike> bikes = bikeJpaRepository.findAll();
        log.trace("getAll: result={}", bikes);
        return bikes;
    }

    @Override
    public Bike exist(Long id) throws ValidatorException {
        log.trace("exist - method entered: id={}", id);
        Bike bike = bikeJpaRepository.findById(id).orElseThrow(() -> new ValidatorException("EXIST - Bike ID not in database"));
        log.trace("exist - method finished: bike found={}", bike);
        return bike;
    }

    @Override
    public List<Bike> filter(int price) {
        log.trace("filter - method entered: price={}", price);
        List<Bike> bikes = bikeJpaRepository.findByPriceLessThan(price);
        log.trace("filter: result={}", bikes);
        return bikes;
    }

    @Override
    public List<Bike> sort() {
        log.trace("sort - method entered");
        List<Bike> bikes = bikeJpaRepository.findByOrderBySerialNumber();
        log.trace("sort: result={}", bikes);
        return bikes;
    }
}
