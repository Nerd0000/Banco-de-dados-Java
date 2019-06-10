package com.Alan.Senai;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Alan.Senai.domain.Cliente;
import com.Alan.Senai.repositories.ClienteRepository;
import com.Alan.Senai.domain.Estado;
import com.Alan.Senai.repositories.EstadoRepository;
import com.Alan.Senai.domain.enuns.TipoCliente;


@SpringBootApplication
public class CursoSenaiApplication implements CommandLineRunner {
	@Autowired // instancia todos os objetos
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSenaiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instacio estado e preencho
		Estado est1 = new Estado(null, "Minas Gerais");// id null pois o id será auto-gerado
		Estado est2 = new Estado(null, "São Paulo");
		// foi chamado acima e aqui salvo
		estadoRepository.saveAll(Arrays.asList(est1, est2));

		// ---Criação de 10 clientes
		Cliente cli1 = new Cliente(null, "Crispim Luiz", "12345678987", "c.luiz@fiemg.com.br",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("34900000000", "98765432112"));
		//..........
		Cliente cli2 = new Cliente(null, "Luiz Crispim", "35412698745", "luizC@gmail.com.br", 
				TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("56989687455", "28563156947"));
		//..........
		Cliente cli3 = new Cliente(null, "Klaus Baudelaire", "36521456328", "LeitorAnonimo@csc.com.br",
				TipoCliente.PESSOAFISICA);
		cli3.getTelefones().addAll(Arrays.asList("88888889888", "77777877777"));
		//..........
		Cliente cli4 = new Cliente(null, "Violet Baudelaire", "12345678987", "InventoraMestra@csc.com.br",
				TipoCliente.PESSOAFISICA);
		cli4.getTelefones().addAll(Arrays.asList("55545945555", "66319766662"));
		//..........
		Cliente cli5 = new Cliente(null, "Sunny Baudelaire", "14785236547", "Mordedora@csc.com.br",
				TipoCliente.PESSOAFISICA);
		cli5.getTelefones().addAll(Arrays.asList("11831461117", "55555584785"));
		//..........
		Cliente cli6 = new Cliente(null, "Strauss", "58965478521", "S2direito@tribuna.com.br",
				TipoCliente.PESSOAJURIDICA);
		cli6.getTelefones().addAll(Arrays.asList("66665555478", "44466699988"));
		//..........
		Cliente cli7 = new Cliente(null, "Bill Cipher", "99977733311", "TriReality@Gravity.com.br",
				TipoCliente.PESSOAJURIDICA);
		cli7.getTelefones().addAll(Arrays.asList("33366655544", "55544448877"));
		//..........
		Cliente cli8 = new Cliente(null, "Dipper Pines", "77788844455", "Trust_no_one@Gravity.com.br",
				TipoCliente.PESSOAFISICA);
		cli8.getTelefones().addAll(Arrays.asList("22222255555", "77772222266"));
		//..........
		Cliente cli9 = new Cliente(null, "Mabel Pines", "33355544488", "Waddles@Gravity.com.br",
				TipoCliente.PESSOAFISICA);
		cli9.getTelefones().addAll(Arrays.asList("66655544472", "33322255566"));
		//..........
		Cliente cli10 = new Cliente(null, "Soos Ramirez", "85236974586", "Not-Soos@Gravity.com.br",
				TipoCliente.PESSOAFISICA);
		cli10.getTelefones().addAll(Arrays.asList("45826682954", "44544574455"));
		// --Salvando todos os dados
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6, cli7, cli8, cli9, cli10));
	}
}
