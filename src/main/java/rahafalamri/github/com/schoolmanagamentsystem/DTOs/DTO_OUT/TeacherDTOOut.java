package rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTOOut {

    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Double salary;
    private AddressDTOOut address;

    private List<CourseDTOOut> courses;
}