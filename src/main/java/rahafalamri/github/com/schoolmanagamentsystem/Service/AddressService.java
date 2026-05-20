package rahafalamri.github.com.schoolmanagamentsystem.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Address;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Teacher;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.AddressRepository;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.TeacherRepository;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addTeacherAddress(Integer teacherId, Address address) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);

        if (teacher == null) {
            throw new RuntimeException("Teacher not found");
        }

        address.setTeacher(teacher);
        addressRepository.save(address);
    }

    public void updateTeacherAddress(Integer teacherId, Address address) {
        Address oldAddress = addressRepository.findAddressById(teacherId);

        if (oldAddress == null) {
            throw new RuntimeException("Address not found");
        }

        oldAddress.setArea(address.getArea());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setBuildingNumber(address.getBuildingNumber());

        addressRepository.save(oldAddress);
    }

    public void deleteTeacherAddress(Integer teacherId) {
        Address address = addressRepository.findAddressById(teacherId);

        if (address == null) {
            throw new RuntimeException("Address not found");
        }

        addressRepository.delete(address);
    }
}