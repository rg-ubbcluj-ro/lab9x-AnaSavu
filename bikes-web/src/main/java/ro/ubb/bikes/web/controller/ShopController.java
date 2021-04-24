package ro.ubb.bikes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.core.model.Shop;
import ro.ubb.bikes.core.service.interfaces.ShopService;
import ro.ubb.bikes.web.converter.ShopConverter;
import ro.ubb.bikes.web.dto.BikeDto;
import ro.ubb.bikes.web.dto.BikesListDto;
import ro.ubb.bikes.web.dto.ShopDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShopController {
    private static final Logger log = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopConverter shopConverter;

    @RequestMapping(value = "/shops", method = RequestMethod.POST)
    ShopDto addShop(@RequestBody ShopDto shopDto) {
        log.trace("addShop: dto={}", shopDto);

        var shop = shopConverter.convertDtoToModel(shopDto);
        var addedShop = shopService.add(shop);
        var resultShop= shopConverter.convertModelToDto(addedShop);

        log.trace("addShop: result={}", resultShop);
        return resultShop;
    }

    @RequestMapping(value = "/shops/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteShop(@PathVariable Long id) {
        log.trace("deleteShop: id={}", id);
        shopService.delete(id);
        log.trace("deleteShop - method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/shops/{id}", method = RequestMethod.PUT)
    ShopDto updateShop(@PathVariable Long id, @RequestBody ShopDto shopDto) {
        log.trace("updateShop: id={}, dto={}", id, shopDto);

        var shop = shopConverter.convertDtoToModel(shopDto);
        var updatedShop = shopService.update(shop);
        var resultShop = shopConverter.convertModelToDto(updatedShop);

        log.trace("updateShop: result={}", resultShop);
        return resultShop;
    }

    @RequestMapping(value = "/shops")
    List<ShopDto> getAllShops() {
        return new ArrayList<>(
                shopConverter.convertModelsToDtos(
                        shopService.getAll()
                ));
    }

    @RequestMapping(value = "/shops/filter", method = RequestMethod.GET)
    List<ShopDto> filterShopsByName(@RequestParam String name) {
        log.trace("filterShopsByName - method entered: name={}", name);

        List<Shop> shops = shopService.filter(name);
        List<ShopDto> result = new ArrayList<>(shopConverter.convertModelsToDtos(shops));
        log.trace("filterShopsByName: result={}", result);
        return result;
    }

    @RequestMapping(value = "/shops/sort", method = RequestMethod.GET)
    List<ShopDto> sortShopsByCity() {
        log.trace("sortShopsByCity - method entered");

        List<Shop> shops = shopService.sort();
        List<ShopDto> result = new ArrayList<>(shopConverter.convertModelsToDtos(shops));
        log.trace("sortShopsByCity: result={}", result);
        return result;
    }
}
