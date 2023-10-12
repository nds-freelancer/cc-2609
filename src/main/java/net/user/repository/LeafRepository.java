package net.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.user.entity.Leaf;

public interface LeafRepository extends JpaRepository<Leaf, Integer> {
	
	
}
