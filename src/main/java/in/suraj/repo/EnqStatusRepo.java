package in.suraj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.suraj.entity.EnqStatusEntity;

public interface EnqStatusRepo extends JpaRepository<EnqStatusEntity, Integer>{
	
	@Query("select distinct(statusName) from EnqStatusEntity")
	List<String> getStatusNames();

}
