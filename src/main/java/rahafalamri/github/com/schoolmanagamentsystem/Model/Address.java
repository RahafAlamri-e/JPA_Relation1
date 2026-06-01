package rahafalamri.github.com.schoolmanagamentsystem.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(50) not null")
    private String area;

    @Column(columnDefinition = "varchar(50) not null")
    private String street;

    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;
}