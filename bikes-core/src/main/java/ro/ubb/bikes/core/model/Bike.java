package ro.ubb.bikes.core.model;


import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Bike extends BaseEntity<Long> {
    private String serialNumber;
    private String manufacturer;
    private String color;
    private int price;

    @Override
    public String toString() {
        return "Bike{serialNumber=" + serialNumber + ", " +
                "manufacturer=" + manufacturer + ", " +
                "color=" + color + ", " +
                "price=" + price +
                "} " + super.toString();
    }
}
