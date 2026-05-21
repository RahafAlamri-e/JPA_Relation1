package rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTOIn {

    @NotEmpty(message = "Name is required")
    private String name;
}