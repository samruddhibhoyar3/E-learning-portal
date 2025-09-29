package portal.elearning.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portal.elearning.UserService.entity.userEntity;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<userEntity,Integer> {
    Optional<userEntity> findByEmail(String email);



}
