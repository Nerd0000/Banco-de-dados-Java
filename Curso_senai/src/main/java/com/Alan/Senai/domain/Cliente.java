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

import com.Alan.Senai.domain.enuns.TipoCliente;

@Entity // <-avisa ao JPA q será uma tabela e ja importa o framework
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // <-avisa que o atributo será um id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Atributos viram campos na tabela
	private Integer idCliente;
	private String nome;
	private String CpfOuCnpj;
	private Integer tipo;/* será usado no enum */
	// O banco não deixa os dados se repetirem
	@Column(unique = true)
	private String email;
	// Cria uma tabela com auto incremento
	@ElementCollection
	@CollectionTable(name = "Telefone") // nome da tabela vai nas " "
	private Set<String> telefones = new HashSet<>();

	// Construtor
	public Cliente(Integer idCliente, String nome, String cpfOuCnpj, String email, TipoCliente tipo) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.CpfOuCnpj = cpfOuCnpj;
		this.email = email;
		// não vai telefone
		this.tipo = tipo.getCod();/* busca o cod na classe */
	}

	// gets e setters
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);// puxa da classe enum
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfOuCnpj() {
		return CpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		CpfOuCnpj = cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	// id de auto incremento com valor unico
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}
}