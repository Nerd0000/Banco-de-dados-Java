package com.Alan.Senai.domain;

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
	/* V--Relacionamento das classes(Endereço e Cliente)--V */
	@JsonIgnore // evita que o relacionamento entre em loop infinito e estoure a memoria
	@ManyToOne // indica o tipo do relacionamento(muitos para um)
	@JoinColumn(name = "cliente_id") // será a coluna a ser gerada em nossa tabela
	private Cliente cliente;// puxa a instancia da classe Cliente
	/*---------------------------------------------------*/
	// construtor

	public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep,
			Cliente cliente) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cliente = cliente;
	}

	// gets e sets
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
