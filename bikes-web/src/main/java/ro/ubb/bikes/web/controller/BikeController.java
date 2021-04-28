package ro.ubb.bikes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;
import ro.ubb.bikes.core.service.interfaces.BikeService;
import ro.ubb.bikes.web.converter.BikeConverter;
import ro.ubb.bikes.web.dto.BikeDto;
import ro.ubb.bikes.web.dto.BikesListDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BikeController {
    private static final Logger log = LoggerFactory.getLogger(BikeController.class);

    @Autowired
    private BikeService bikeService;

    @Autowired
    private BikeConverter bikeConverter;

    @RequestMapping(value = "/bikes", method = RequestMethod.POST)
    BikeDto addBike(@RequestBody BikeDto bikeDto) {
        log.trace("addBike: dto={}", bikeDto);

        var bike = bikeConverter.convertDtoToModel(bikeDto);
        var addedBike = bikeService.add(bike);
        var resultBike = bikeConverter.convertModelToDto(addedBike);

        log.trace("addBike: result={}", resultBike);
        return resultBike;
    }

    @RequestMapping(value = "/bikes/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteBike(@PathVariable Long id) {
        log.trace("deleteBike: id={}", id);
        bikeService.delete(id);
        log.trace("deleteBike - method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/bikes/{id}", method = RequestMethod.PUT)
    BikeDto updateBike(@PathVariable Long id, @RequestBody BikeDto bikeDto) {
        log.trace("updateBike: id={}, dto={}", id, bikeDto);

        var bike = bikeConverter.convertDtoToModel(bikeDto);
        var updatedBike = bikeService.update(bike);
        var resultBike = bikeConverter.convertModelToDto(updatedBike);

        log.trace("updateBike: result={}", resultBike);
        return resultBike;
    }

    @RequestMapping(value = "/bikes")
    List<BikeDto> getAllBikes() {
        return new ArrayList<>(
                bikeConverter.convertModelsToDtos(
                        bikeService.getAll()
                ));
    }

    @RequestMapping(value = "/bikes/filter", method = RequestMethod.GET)
    List<BikeDto> filterBikesByPrice(@RequestParam Integer price) {
        log.trace("filterBikesByPrice - method entered: price={}", price);

        List<Bike> bikes = bikeService.filter(price);
//        List<BikeDto> bikesDtos = bikeConverter.convertModelsToDtos(bikes);
//        BikesListDto result = new BikesListDto(bikesDtos);
        List<BikeDto> result = new ArrayList<>(bikeConverter.convertModelsToDtos(bikes));
        log.trace("filterBikesByPrice: result={}", result);
        return result;
    }

    @RequestMapping(value = "/bikes/sort", method = RequestMethod.GET)
    List<BikeDto> sortBikesBySerialNumber() {
        log.trace("sortBikesBySerialNumber - method entered");

        List<Bike> bikes = bikeService.sort();
        //List<BikeDto> bikesDtos = bikeConverter.convertModelsToDtos(bikes);
        //BikesListDto result = new BikesListDto(bikesDtos);
        List<BikeDto> result = new ArrayList<>(bikeConverter.convertModelsToDtos(bikes));
        log.trace("sortBikesBySerialNumber: result={}", result);
        return result;
    }
}
