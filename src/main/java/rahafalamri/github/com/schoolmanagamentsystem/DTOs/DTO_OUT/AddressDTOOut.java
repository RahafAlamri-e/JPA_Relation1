package rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTOOut {

    private Integer id;
    private String area;
    private String street;
    private Integer buildingNumber;
}