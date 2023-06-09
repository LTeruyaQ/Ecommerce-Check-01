package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}