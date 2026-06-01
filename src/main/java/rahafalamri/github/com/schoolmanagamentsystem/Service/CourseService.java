package rahafalamri.github.com.schoolmanagamentsystem.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rahafalamri.github.com.schoolmanagamentsystem.Api.ApiException;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN.CourseDTOIn;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT.CourseDTOOut;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT.StudentDTOOut;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Course;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Student;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Teacher;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.CourseRepository;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<CourseDTOOut> getAllCourses() {
        List<CourseDTOOut> courses = new ArrayList<>();

        for (Course course : courseRepository.findAll()) {
            courses.add(mapToCourseDTOOut(course));
        }

        return courses;
    }

    public void addCourse(Integer teacherId, CourseDTOIn courseDTOIn) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Course course = new Course();
        course.setName(courseDTOIn.getName());
        course.setTeacher(teacher);

        courseRepository.save(course);
    }

    public void updateCourse(Integer courseId, CourseDTOIn courseDTOIn) {
        Course course = courseRepository.findCourseById(courseId);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        course.setName(courseDTOIn.getName());
        courseRepository.save(course);
    }

    public void deleteCourse(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        for (Student student : course.getStudents()) {
            student.getCourses().remove(course);
        }

        courseRepository.delete(course);
    }

    public String getTeacherNameByCourseId(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        if (course.getTeacher() == null) {
            throw new ApiException("Course has no teacher");
        }

        return course.getTeacher().getName();
    }

    public List<StudentDTOOut> getStudentsByCourseId(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        List<StudentDTOOut> students = new ArrayList<>();

        for (Student student : course.getStudents()) {
            students.add(mapToStudentDTOOut(student));
        }

        return students;
    }

    private CourseDTOOut mapToCourseDTOOut(Course course) {
        return new CourseDTOOut(course.getId(), course.getName());
    }

    private StudentDTOOut mapToStudentDTOOut(Student student) {
        List<CourseDTOOut> courses = new ArrayList<>();

        for (Course course : student.getCourses()) {
            courses.add(new CourseDTOOut(course.getId(), course.getName()));
        }

        return new StudentDTOOut(student.getId(), student.getName(), student.getAge(), student.getMajor(), courses);
    }
}
