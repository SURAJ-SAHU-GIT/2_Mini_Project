package in.suraj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.suraj.entity.UserDtlsEntity;

public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity, Integer> {

	UserDtlsEntity findByEmail(String email);

	UserDtlsEntity findByEmailAndPassword(String email, String password);
}
