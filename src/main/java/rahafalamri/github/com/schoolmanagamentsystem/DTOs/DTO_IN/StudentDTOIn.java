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
public class StudentDTOIn {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    @Positive(message = "Age must be positive")
    private Integer age;

    @NotEmpty(message = "Major is required")
    private String major;
}
