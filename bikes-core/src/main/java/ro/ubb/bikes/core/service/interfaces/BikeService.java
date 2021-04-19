package ro.ubb.bikes.core.service.interfaces;

import ro.ubb.bikes.core.model.Bike;

import java.io.Serializable;
import java.util.List;

public interface BikeService {
    List<Bike> getAll();

    Bike update(Long bikeID, String serialNumber, String manufacturer, String color, int price);
}
