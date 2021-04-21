package ro.ubb.bikes.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Employee extends BaseEntity<Long> {
    private String name;
    private String position; //ex: cashier, manager, director,...
    private int workedHours;
}
