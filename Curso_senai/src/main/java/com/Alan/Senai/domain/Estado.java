package com.Alan.Senai.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // <-avisa ao JPA q será uma tabela e ja importa o framework
public class Estado implements Serializable {
	// Serializable serve para a jvm(maquina virtual do java)
	// identificar como entidade unica e executar
	private static final long serialVersionUID = 1L;

	@Id // <-avisa que o atributo será um id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//gera o id
	// Atributos viram campos na tabela
	private Integer id;
	private String nome;

	/* V--Relacionamento das classes(Estado e Cidade)--V */
	@JsonIgnore // evita que o relacionamento entre em loop infinito e estoure a memoria
	@OneToMany(mappedBy = "estado") // indica o tipo do relacionamento(um para muitos)
	// ^-salvo tudo que foi pegado na linha acima pelo mapped em uma lista-v
	private List<Cidade> cidades = new ArrayList<>();
	/*---------------------------------------------------*/

	// construtor vazio
	public Estado() {
	}

	// construtor cheio
	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	// get e set
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	// hashCode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidades == null) ? 0 : cidades.hashCode());
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
		Estado other = (Estado) obj;
		if (cidades == null) {
			if (other.cidades != null)
				return false;
		} else if (!cidades.equals(other.cidades))
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
