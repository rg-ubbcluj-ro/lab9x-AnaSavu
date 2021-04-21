package ro.ubb.bikes.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentalsListDto {
    private List<RentalDto> rentals;
}
