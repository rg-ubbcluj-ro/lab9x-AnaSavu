package ro.ubb.bikes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.bikes.core.model.Rental;
import ro.ubb.bikes.core.service.interfaces.RentalService;
import ro.ubb.bikes.web.converter.RentalConverter;
import ro.ubb.bikes.web.dto.RentalDto;
import ro.ubb.bikes.web.dto.RentalsListDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RentalController {
    private static final Logger log = LoggerFactory.getLogger(RentalController.class);

    @Autowired
    private RentalService rentalService;

    @Autowired
    private RentalConverter rentalConverter;

    @RequestMapping(value = "/rentals", method = RequestMethod.POST)
    RentalDto addRental(@RequestBody RentalDto rentalDto) {
        log.trace("add rental: dto={}", rentalDto);

        var rental = rentalConverter.convertDtoToModel(rentalDto);
        var addedRental = rentalService.add(rental);
        var resultRental = rentalConverter.convertModelToDto(addedRental);

        log.trace("add rental: rental={}", resultRental);
        return resultRental;
    }

    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteRental(@PathVariable Long id) {
        log.trace("delete rental: id={}", id);

        rentalService.delete(id);

        log.trace("delete bike - method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.PUT)
    RentalDto updateRental(@PathVariable Long id, @RequestBody RentalDto rentalDto) {
        log.trace("update rental: id={}, dto={}", id, rentalDto);

        var rental = rentalConverter.convertDtoToModel(rentalDto);
        var updatedRental = rentalService.update(rental);
        var resultRental = rentalConverter.convertModelToDto(updatedRental);

        log.trace("update rental: rental={}", resultRental);
        return resultRental;
    }

//    @RequestMapping(value = "/rentals")
//    RentalsListDto getAllRentals() {
//        return new RentalsListDto(rentalConverter.convertModelsToDtos(rentalService.getAll()));
//    }

    @RequestMapping(value = "/rentals")
    List<RentalDto> getAllRentals() {
        return new ArrayList<>(rentalConverter.convertModelsToDtos(rentalService.getAll()));
    }

    @RequestMapping(value = "/rentals/filter", method = RequestMethod.GET)
    RentalsListDto filterRentalsByDaysRented(@RequestParam int daysRented) {
        log.trace("filter - method entered: daysRented={}", daysRented);

        List<Rental> rentals = rentalService.filter(daysRented);
        List<RentalDto> rentalDtos = rentalConverter.convertModelsToDtos(rentals);
        RentalsListDto result = new RentalsListDto(rentalDtos);

        log.trace("filter: rentals={}", result);
        return result;
    }

    @RequestMapping(value = "/rentals/sort", method = RequestMethod.GET)
    RentalsListDto sortRentalsByDaysRented() {
        log.trace("sort - method entered");

        List<Rental> rentals = rentalService.sort();
        List<RentalDto> rentalDtos = rentalConverter.convertModelsToDtos(rentals);
        RentalsListDto result = new RentalsListDto(rentalDtos);

        log.trace("sort: rentals={}", result);
        return result;
    }
}
