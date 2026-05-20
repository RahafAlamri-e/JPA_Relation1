package rahafalamri.github.com.schoolmanagamentsystem.Controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rahafalamri.github.com.schoolmanagamentsystem.Api.ApiResponse;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Address;
import rahafalamri.github.com.schoolmanagamentsystem.Service.AddressService;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addTeacherAddress(@PathVariable Integer teacherId, @RequestBody @Valid Address address) {
        addressService.addTeacherAddress(teacherId, address);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher address added"));
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> updateTeacherAddress(@PathVariable Integer teacherId, @RequestBody @Valid Address address) {
       addressService.updateTeacherAddress(teacherId, address);
       return ResponseEntity.status(200).body(new ApiResponse("Teacher address updated"));

    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> deleteTeacherAddress(@PathVariable Integer teacherId) {
       addressService.deleteTeacherAddress(teacherId);
       return ResponseEntity.status(200).body(new ApiResponse("Teacher address deleted"));
    }
}