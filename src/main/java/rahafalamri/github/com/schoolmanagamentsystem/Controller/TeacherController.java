package rahafalamri.github.com.schoolmanagamentsystem.Controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN.TeacherDTOIn;
import rahafalamri.github.com.schoolmanagamentsystem.Service.TeacherService;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid TeacherDTOIn teacherDTOIn) {
        teacherService.addTeacher(teacherDTOIn);
        return ResponseEntity.status(200).body("Teacher added successfully");
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer teacherId, @RequestBody @Valid TeacherDTOIn teacherDTOIn) {
        teacherService.updateTeacher(teacherId, teacherDTOIn);
        return ResponseEntity.status(200).body("Teacher updated successfully");
    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.status(200).body("Teacher deleted successfully");
    }

    @GetMapping("/details/{teacherId}")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer teacherId) {
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(teacherId));
    }
}