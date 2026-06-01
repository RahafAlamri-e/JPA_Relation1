package rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTOOut {

    private Integer id;
    private String name;
    private Integer age;
    private String major;
    private List<CourseDTOOut> courses;
}
