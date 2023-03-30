package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
}
