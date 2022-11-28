package course.ensf607.assignment6.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public Optional<Course> findByName(String name);

    public List<Course> findAllByOrderByNameAsc();

}
