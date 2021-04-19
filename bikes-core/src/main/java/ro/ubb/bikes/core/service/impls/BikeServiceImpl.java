package ro.ubb.bikes.core.service.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.core.repository.BikeRepo;
import ro.ubb.bikes.core.service.interfaces.BikeService;

import java.util.List;
import java.util.Optional;

@Service
public class BikeServiceImpl implements BikeService {
    private static final Logger log = LoggerFactory.getLogger(BikeServiceImpl.class);

    @Autowired
    private BikeRepo bikeRepo;

    @Override
    public List<Bike> getAll() {
        log.trace("findAll --- method entered");

        List<Bike> bikes = bikeRepo.findAll();

        log.trace("getAll: bikes={}", bikes);

        return bikes;
    }

    @Transactional
    @Override
    public Bike update(Long bikeID, String serialNumber, String manufacturer, String color, int price) {
        log.trace("updateBike: serialNumber={}, manufacturer={}, color={}, price={}", serialNumber, manufacturer, color, price);

        Optional<Bike> bike = bikeRepo.findById(bikeID);

        bike.ifPresent(b->{
            b.setSerialNumber(serialNumber);
            b.setManufacturer(manufacturer);
            b.setColor(color);
            b.setPrice(price);
        });

        log.trace("updateBike: bike={}", bike.get());

        return bike.orElse(null);
    }
}
