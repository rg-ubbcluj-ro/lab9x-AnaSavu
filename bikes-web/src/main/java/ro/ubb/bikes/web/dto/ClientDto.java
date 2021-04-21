package ro.ubb.bikes.web.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClientDto extends BaseDto{
    private String name;
    private int age;
    private String phoneNumber;
}
