package rahafalamri.github.com.schoolmanagamentsystem.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rahafalamri.github.com.schoolmanagamentsystem.Api.ApiException;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_IN.AddressDTOIn;
import rahafalamri.github.com.schoolmanagamentsystem.DTOs.DTO_OUT.AddressDTOOut;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Address;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Teacher;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.AddressRepository;
import rahafalamri.github.com.schoolmanagamentsystem.Repository.TeacherRepository;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addTeacherAddress(Integer teacherId, AddressDTOIn addressDTOIn) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Address address = new Address();

        address.setArea(addressDTOIn.getArea());
        address.setStreet(addressDTOIn.getStreet());
        address.setBuildingNumber(addressDTOIn.getBuildingNumber());

        address.setTeacher(teacher);

        addressRepository.save(address);
    }

    public void updateTeacherAddress(Integer teacherId, AddressDTOIn addressDTOIn) {
        Address address = addressRepository.findAddressById(teacherId);

        if (address == null) {
            throw new ApiException("Address not found");
        }

        address.setArea(addressDTOIn.getArea());
        address.setStreet(addressDTOIn.getStreet());
        address.setBuildingNumber(addressDTOIn.getBuildingNumber());

        addressRepository.save(address);
    }

    public void deleteTeacherAddress(Integer teacherId) {
        Address address = addressRepository.findAddressById(teacherId);

        if (address == null) {
            throw new ApiException("Address not found");
        }

        addressRepository.delete(address);
    }

    public AddressDTOOut getTeacherAddress(Integer teacherId) {
        Address address = addressRepository.findAddressById(teacherId);

        if (address == null) {
            throw new ApiException("Address not found");
        }

        return new AddressDTOOut(address.getId(),address.getArea(), address.getStreet(), address.getBuildingNumber());
    }
}