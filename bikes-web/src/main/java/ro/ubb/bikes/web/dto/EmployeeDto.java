package ro.ubb.bikes.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EmployeeDto extends BaseDto{
    private String name;
    private String position;
    private int workedHours;
}
