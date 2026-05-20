package rahafalamri.github.com.schoolmanagamentsystem.Repository;
import  rahafalamri.github.com.schoolmanagamentsystem.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findTeacherById(Integer id);
}

