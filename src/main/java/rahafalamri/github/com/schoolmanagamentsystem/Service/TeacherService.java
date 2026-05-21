package rahafalamri.github.com.schoolmanagamentsystem.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rahafalamri.github.com.schoolmanagamentsystem.Api.ApiException;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN.TeacherDTOIn;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT.AddressDTOOut;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT.CourseDTOOut;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT.TeacherDTOOut;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Course;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Teacher;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<TeacherDTOOut> getAllTeachers() {
        List<TeacherDTOOut> teachers = new ArrayList<>();

        for (Teacher teacher : teacherRepository.findAll()) {
            teachers.add(mapToTeacherDTOOut(teacher));
        }

        return teachers;
    }

    public void addTeacher(TeacherDTOIn teacherDTOIn) {
        Teacher teacher = new Teacher();

        teacher.setName(teacherDTOIn.getName());
        teacher.setAge(teacherDTOIn.getAge());
        teacher.setEmail(teacherDTOIn.getEmail());
        teacher.setSalary(teacherDTOIn.getSalary());

        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer teacherId, TeacherDTOIn teacherDTOIn) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        teacher.setName(teacherDTOIn.getName());
        teacher.setAge(teacherDTOIn.getAge());
        teacher.setEmail(teacherDTOIn.getEmail());
        teacher.setSalary(teacherDTOIn.getSalary());

        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    public TeacherDTOOut getTeacherDetails(Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        return mapToTeacherDTOOut(teacher);
    }

    private TeacherDTOOut mapToTeacherDTOOut(Teacher teacher) {
        AddressDTOOut addressDTOOut = null;
        if (teacher.getAddress() != null) {
            addressDTOOut = new AddressDTOOut(teacher.getAddress().getId(), teacher.getAddress().getArea(), teacher.getAddress().getStreet(), teacher.getAddress().getBuildingNumber());
        }

        List<CourseDTOOut> courses = new ArrayList<>();
        for (Course course : teacher.getCourses()) {
            courses.add(new CourseDTOOut(course.getId(), course.getName()));
        }

        return new TeacherDTOOut(teacher.getId(), teacher.getName(), teacher.getAge(), teacher.getEmail(), teacher.getSalary(), addressDTOOut, courses);
    }
}