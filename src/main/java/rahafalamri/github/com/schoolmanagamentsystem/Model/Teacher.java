package rahafalamri.github.com.schoolmanagamentsystem.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 22, message = "Age must be 22 or above")
    private Integer age;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(columnDefinition = "varchar(100) not null unique")
    private String email;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private Double salary;

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Address address;
}