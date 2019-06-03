package com.Alan.Senai.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // <-avisa ao JPA q será uma tabela e ja importa o framework
public class Cliente implements Serializable {
	private static final long seriaLVersionUID = 1L;

	@Id // <-avisa que o atributo será um id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Atributos viram campos na tabela
	private Integer idCliente;
	private String nome;
	private String CpfOuCnpj;
	// O banco não deixa os dados se repetirem
	@Column(unique = true)
	private String email;
	// Cria uma tabela com auto incremento
	@ElementCollection
	@CollectionTable(name = "Telefone") // nome da tabela vai nas " "
	private Set<String> telefones = new HashSet<>();
}
