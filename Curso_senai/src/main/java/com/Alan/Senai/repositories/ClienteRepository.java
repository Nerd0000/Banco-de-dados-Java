package com.Alan.Senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alan.Senai.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	// Jpa fará todo o serviço de insert, delete, rename, update, etc.
	// Veja que busca o tipo do nosso id e integer
	// veja que é uma interface que extende os recursos do JPA
}
