package com.Alan.Senai.domain;

//^-Pacote de origem,importações necessarias-v
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // <-avisa ao JPA q será uma tabela e ja importa o framework
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // <-avisa que o atributo será um id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Atributos viram campos na tabela
	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;

	// -----Relacionamento das classes(Endereço e Cliente)
	@JsonIgnore // evita que o relacionamento entre em loop infinito e estoure a memoria
	@ManyToOne // indica o tipo do relacionamento(muitos para um)
	@JoinColumn(name = "cliente_id") // será a coluna a ser gerada em nossa tabela
	private Cliente cliente;// puxa a instancia da classe Cliente

	// Endereco conhece a cidade, mas a cidade não conhece o endereço
	@ManyToOne // indica o tipo do relacionamento(muitos para um)
	@JoinColumn(name = "cidade_id") // será a coluna a ser gerada em nossa tabela
	private Cidade cidade;// puxa a instancia da classe Cidade
	// ---------------------------------------------------

	// construtor
	public Endereco() {
	}
	public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep,
			Cliente cliente, Cidade cidade) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cliente = cliente;
		this.cidade = cidade;
	}

	// gets e sets
	public Cliente getCliente() {
		return cliente;
	}

	public Integer getId() {
		return id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	// HashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
