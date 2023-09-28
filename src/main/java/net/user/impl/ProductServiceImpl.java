package net.user.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import net.user.entity.Product;
import net.user.repository.ProductRepository;
import net.user.service.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	@Override
	public List<Product> findAllByCategoryId(String catid, Pageable pageable) {
		return productRepository.findAllByCategoryId(catid, pageable);
	}

	@Override
	public long countByCategoryId(String catid) {
		return productRepository.countByCategoryId(catid);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}

}
