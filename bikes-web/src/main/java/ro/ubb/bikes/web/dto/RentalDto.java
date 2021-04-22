package ro.ubb.bikes.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class RentalDto extends BaseDto{
    private int daysRented;
    private Long bikeID;
    private Long clientID;
    private Long employeeID;
}
