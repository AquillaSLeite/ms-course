package leite.aquilla.hruser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import leite.aquilla.hruser.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
