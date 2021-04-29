package ro.ubb.bikes.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Rental extends BaseEntity<Long> {
    private int daysRented;
    private Long bikeID;
    private Long clientID;
    private Long employeeID;
    private Long shopID;
}
