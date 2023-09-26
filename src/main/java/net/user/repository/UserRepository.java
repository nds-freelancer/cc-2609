package net.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
