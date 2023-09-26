package net.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.user.entity.Cake;

public interface CakeRepository extends JpaRepository<Cake, Integer> {
	
	
}
