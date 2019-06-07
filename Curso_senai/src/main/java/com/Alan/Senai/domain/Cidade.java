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
	//get e set
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	//hashCode e equal
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
