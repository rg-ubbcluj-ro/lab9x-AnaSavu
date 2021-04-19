package ro.ubb.bikes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.core.service.interfaces.BikeService;
import ro.ubb.bikes.web.converter.BikeConverter;
import ro.ubb.bikes.web.dto.BikeDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BikeController {
    private static final Logger log = LoggerFactory.getLogger(BikeController.class);

    @Autowired
    private BikeService bikeService;

    @Autowired
    private BikeConverter bikeConverter;


    @RequestMapping(value = "/bikes", method = RequestMethod.GET)
    public List<BikeDto> getStudents() {
        log.trace("getBikes");

        List<Bike> bikes = bikeService.getAll();

        log.trace("getBikes: bikes={}", bikes);

        return new ArrayList<>(bikeConverter.convertModelsToDtos(bikes));
    }

    @RequestMapping(value = "/bikes/{bikeId}", method = RequestMethod.PUT)
    public BikeDto updateBike(
            @PathVariable final Long bikeId,
            @RequestBody final BikeDto bikeDto) {
        log.trace("updateBike: bikeId={}, bikeDtoMap={}", bikeId, bikeDto);

        Bike bike = bikeService.update(bikeId,
                bikeDto.getSerialNumber(), bikeDto.getManufacturer(),
                bikeDto.getColor(), bikeDto.getPrice());

        BikeDto result = bikeConverter.convertModelToDto(bike);

        log.trace("updateBike: result={}", result);

        return result;
    }
}
