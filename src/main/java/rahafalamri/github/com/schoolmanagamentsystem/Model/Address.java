package rahafalamri.github.com.schoolmanagamentsystem.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "Area is required")
    @Column(columnDefinition = "varchar(50) not null")
    private String area;

    @NotEmpty(message = "Street is required")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;

    @NotNull(message = "Building number is required")
    @Positive(message = "Building number must be positive")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;
}