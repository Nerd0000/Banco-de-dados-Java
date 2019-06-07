package com.Alan.Senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alan.Senai.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	// Jpa fará todo o serviço de insert, delete, rename, update, etc.
	// Veja que busca do Cidade e o Integer o tipo do nosso id e integer
	// veja que é uma interface que extende os recursos do JPA
}
