package ro.ubb.bikes.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopDto extends BaseDto{
    private String name;
    private String city;
}
