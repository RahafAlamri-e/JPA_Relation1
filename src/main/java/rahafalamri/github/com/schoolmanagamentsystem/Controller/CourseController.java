package rahafalamri.github.com.schoolmanagamentsystem.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN.CourseDTOIn;
import rahafalamri.github.com.schoolmanagamentsystem.Service.CourseService;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addCourse(@PathVariable Integer teacherId, @RequestBody @Valid CourseDTOIn courseDTOIn) {
        courseService.addCourse(teacherId, courseDTOIn);
        return ResponseEntity.status(201).body("Course added successfully");
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer courseId, @RequestBody @Valid CourseDTOIn courseDTOIn) {
        courseService.updateCourse(courseId, courseDTOIn);
        return ResponseEntity.status(200).body("Course updated successfully");
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(200).body("Course deleted successfully");
    }

    @GetMapping("/teacher-name/{courseId}")
    public ResponseEntity<?> getTeacherNameByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getTeacherNameByCourseId(courseId));
    }

    @GetMapping("/students/{courseId}")
    public ResponseEntity<?> getStudentsByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getStudentsByCourseId(courseId));
    }
}
