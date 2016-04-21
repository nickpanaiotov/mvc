package mvc.data.repository;

import mvc.data.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaRepository extends JpaRepository<Users, Long> {
}
