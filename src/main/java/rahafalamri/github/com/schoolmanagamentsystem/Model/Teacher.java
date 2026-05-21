package rahafalamri.github.com.schoolmanagamentsystem.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @Column(columnDefinition = "int not null check (age>21)")
    private Integer age;

    @Column(columnDefinition = "varchar(100) not null unique")
    private String email;

    @Column(columnDefinition = "double not null check(salary > 0)")
    private Double salary;

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Course> courses;
}