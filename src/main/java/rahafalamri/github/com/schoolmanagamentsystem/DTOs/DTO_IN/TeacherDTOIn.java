package rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTOIn {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 22, message = "Age must be 22 or above")
    private Integer age;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private Double salary;
}
