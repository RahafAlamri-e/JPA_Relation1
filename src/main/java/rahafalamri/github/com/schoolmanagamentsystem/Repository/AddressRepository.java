package rahafalamri.github.com.schoolmanagamentsystem.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);;
}
