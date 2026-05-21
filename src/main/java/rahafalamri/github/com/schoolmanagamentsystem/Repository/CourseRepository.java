package rahafalamri.github.com.schoolmanagamentsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rahafalamri.github.com.schoolmanagamentsystem.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);
}
