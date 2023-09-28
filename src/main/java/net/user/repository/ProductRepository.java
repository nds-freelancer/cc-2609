package net.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.user.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Page<Product> findAll(Pageable pageable);

	List<Product> findAllByCategoryId(String catid, Pageable pageable);

	long countByCategoryId(String catid);
	
	Optional<Product> findById(Integer id);
}