package com.Alan.Senai.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//pesquisar no site do JPA para mais informações sobre anotacoes @
@Entity // <-avisa ao JPA q será uma tabela e ja importa o framework
public class Cidade implements Serializable {
	// serve para a jvm identificar como entidade unica e executar
	private static final long serialVersionUID = 1L;

	@Id // <-avisa que o atributo será um id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Atributos viram campos na tabela
	private Integer id;
	private String nome;
	// ---------------Relacionamento cidade<->estado--------------------
	@ManyToOne // indica o tipo do relacionamento(muitos para um)
	@JoinColumn(name = "estado id") // será a coluna a ser gerada em nossa tabela da relação
	private Estado estado;// puxa a instancia da classe Estado
	// construtor vazio

	public Cidade() {
	}
	//construtor cheio
	public Cidade(Integer id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}
	
}
