package rahafalamri.github.com.schoolmanagamentsystem.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Teacher;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findTeacherById(id);

        if (oldTeacher == null) {
            throw new RuntimeException("Teacher not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());

        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null) {
            throw new RuntimeException("Teacher not found");
        }

        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherDetails(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null) {
            throw new RuntimeException("Teacher not found");
        }

        return teacher;
    }
}