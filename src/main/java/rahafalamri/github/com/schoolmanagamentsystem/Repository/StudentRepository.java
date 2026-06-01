package rahafalamri.github.com.schoolmanagamentsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);
}
