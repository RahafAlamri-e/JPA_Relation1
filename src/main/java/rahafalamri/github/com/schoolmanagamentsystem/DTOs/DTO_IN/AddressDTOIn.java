package rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTOIn {

    @NotEmpty(message = "Area is required")
    private String area;

    @NotEmpty(message = "Street is required")
    private String street;

    @NotNull(message = "Building number is required")
    @Positive(message = "Building number must be positive")
    private Integer buildingNumber;
}
