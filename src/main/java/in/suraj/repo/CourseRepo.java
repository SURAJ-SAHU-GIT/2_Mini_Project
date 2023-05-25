package in.suraj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.suraj.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer>{
	
	@Query("select distinct(courseName) from CourseEntity")
	List<String> getCourse();


}
