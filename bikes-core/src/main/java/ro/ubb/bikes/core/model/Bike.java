package ro.ubb.bikes.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Bike extends BaseEntity<Long> {
    private String serialNumber;
    private String manufacturer;
    private String color;
    private int price;
}
