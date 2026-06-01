package rahafalamri.github.com.schoolmanagamentsystem.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rahafalamri.github.com.schoolmanagamentsystem.Api.ApiResponse;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN.StudentDTOIn;
import rahafalamri.github.com.schoolmanagamentsystem.Service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid StudentDTOIn studentDTOIn) {
        studentService.addStudent(studentDTOIn);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer studentId, @RequestBody @Valid StudentDTOIn studentDTOIn) {
        studentService.updateStudent(studentId, studentDTOIn);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
    }

    @PutMapping("/assign-course/{studentId}/{courseId}")
    public ResponseEntity<?> assignCourseToStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        studentService.assignCourseToStudent(studentId, courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Course assigned to student successfully"));
    }

    @PutMapping("/change-major/{studentId}/{major}")
    public ResponseEntity<?> changeStudentMajor(@PathVariable Integer studentId, @PathVariable String major) {
        studentService.changeStudentMajor(studentId, major);
        return ResponseEntity.status(200).body(new ApiResponse("Student major changed and courses dropped successfully"));
    }
}
