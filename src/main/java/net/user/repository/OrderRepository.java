package net.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import net.user.entity.OrderCa;

public interface OrderRepository extends JpaRepository<OrderCa, Integer> {
	
	@Query(value = "select * from orderca where phone = ?1", nativeQuery = true)
	public List<OrderCa> findAllByPhone(String phone);
}
