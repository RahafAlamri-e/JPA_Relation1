package rahafalamri.github.com.schoolmanagamentsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @Column(columnDefinition = "int not null check (age > 0)")
    private Integer age;

    @Column(columnDefinition = "varchar(50) not null")
    private String major;

    @ManyToMany
    @JsonIgnore
    private Set<Course> courses;
}
