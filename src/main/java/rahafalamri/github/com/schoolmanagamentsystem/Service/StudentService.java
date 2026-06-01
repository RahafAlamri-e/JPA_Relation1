package rahafalamri.github.com.schoolmanagamentsystem.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rahafalamri.github.com.schoolmanagamentsystem.Api.ApiException;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN.StudentDTOIn;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT.CourseDTOOut;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT.StudentDTOOut;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Course;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Student;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.CourseRepository;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<StudentDTOOut> getAllStudents() {
        List<StudentDTOOut> students = new ArrayList<>();

        for (Student student : studentRepository.findAll()) {
            students.add(mapToStudentDTOOut(student));
        }

        return students;
    }

    public void addStudent(StudentDTOIn studentDTOIn) {
        Student student = new Student();
        student.setName(studentDTOIn.getName());
        student.setAge(studentDTOIn.getAge());
        student.setMajor(studentDTOIn.getMajor());

        studentRepository.save(student);
    }

    public void updateStudent(Integer studentId, StudentDTOIn studentDTOIn) {
        Student student = studentRepository.findStudentById(studentId);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        student.setName(studentDTOIn.getName());
        student.setAge(studentDTOIn.getAge());
        student.setMajor(studentDTOIn.getMajor());

        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        Student student = studentRepository.findStudentById(studentId);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        for (Course course : student.getCourses()) {
            course.getStudents().remove(student);
        }

        studentRepository.delete(student);
    }

    public void assignCourseToStudent(Integer studentId, Integer courseId) {
        Student student = studentRepository.findStudentById(studentId);
        Course course = courseRepository.findCourseById(courseId);

        if (student == null || course == null) {
            throw new ApiException("Student or Course not found");
        }

        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeStudentMajor(Integer studentId, String major) {
        Student student = studentRepository.findStudentById(studentId);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        for (Course course : student.getCourses()) {
            course.getStudents().remove(student);
        }

        student.getCourses().clear();
        student.setMajor(major);
        studentRepository.save(student);
    }

    private StudentDTOOut mapToStudentDTOOut(Student student) {
        List<CourseDTOOut> courses = new ArrayList<>();

        if (student.getCourses() != null) {
            for (Course course : student.getCourses()) {
                courses.add(new CourseDTOOut(course.getId(), course.getName()));
            }
        }

        return new StudentDTOOut(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getMajor(),
                courses
        );
    }
}
