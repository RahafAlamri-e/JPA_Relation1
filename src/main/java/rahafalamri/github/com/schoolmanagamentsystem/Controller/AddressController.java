package rahafalamri.github.com.schoolmanagamentsystem.Controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN.AddressDTOIn;
import rahafalamri.github.com.schoolmanagamentsystem.Service.AddressService;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addTeacherAddress(@PathVariable Integer teacherId, @RequestBody @Valid AddressDTOIn addressDTOIn) {
        addressService.addTeacherAddress(teacherId, addressDTOIn);
        return ResponseEntity.status(200).body("Address added successfully");
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> updateTeacherAddress(@PathVariable Integer teacherId, @RequestBody @Valid AddressDTOIn addressDTOIn) {
        addressService.updateTeacherAddress(teacherId, addressDTOIn);
        return ResponseEntity.status(200).body("Address updated successfully");
    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> deleteTeacherAddress(@PathVariable Integer teacherId) {
        addressService.deleteTeacherAddress(teacherId);
        return ResponseEntity.status(200).body("Address deleted successfully");
    }

    @GetMapping("/get/{teacherId}")
    public ResponseEntity<?> getTeacherAddress(@PathVariable Integer teacherId) {
        return ResponseEntity.status(200).body(addressService.getTeacherAddress(teacherId));
    }
}