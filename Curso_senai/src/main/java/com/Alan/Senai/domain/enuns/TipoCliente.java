package com.Alan.Senai.domain.enuns;

public enum TipoCliente {
	// Será nosso estatico, que não ira mudar
	// O enum so permite a escolha de um dos campos declarados abaixo
	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");
	// Nossos atributos
	private int cod;
	private String descricao;

	// Construtor
	private TipoCliente(int cod, String descrição) {
		this.cod = cod;
		this.descricao = descrição;
	}

	// getter, não necessita set pois é imutavel
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		// se receber vazio , retorna vazio
		if (cod == null) {
			return null;
		}
		// se não, percorre todos os valores do TipoCliente
		for (TipoCliente x : TipoCliente.values()) {
			// se o codigo corresponder a um dos dois estaticos definidos, retorna o codigo
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		// caso digitar um codigo invalido
		throw new IllegalArgumentException("O id digitado é invalido->" + cod);
	}

}
