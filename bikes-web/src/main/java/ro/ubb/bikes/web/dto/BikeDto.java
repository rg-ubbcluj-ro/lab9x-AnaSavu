package ro.ubb.bikes.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BikeDto extends BaseDto {
    private String serialNumber;
    private String manufacturer;
    private String color;
    private Integer price;


    @Override
    public String toString() {
        return "BikeDto{" +
                "serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", color=" + color + '\'' +
                ", price=" + price + '\'' +
                "} " + super.toString();
    }
}
