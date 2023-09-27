package net.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.user.entity.Product;

public interface ProductService {
	
	Page<Product> findAll(Pageable pageable);

	List<Product> findAllByCategoryId(String catid, Pageable pageable);

	long countByCategoryId(String catid);
	
}
