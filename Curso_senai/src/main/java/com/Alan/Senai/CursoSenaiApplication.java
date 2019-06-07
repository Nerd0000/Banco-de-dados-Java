package com.Alan.Senai;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Alan.Senai.domain.Estado;
import com.Alan.Senai.repositories.EstadoRepository;

@SpringBootApplication
public class CursoSenaiApplication implements CommandLineRunner {
	@Autowired // instancia todo o objeto
	// acesso direto a main por esse repositorio
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSenaiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instacio estado e preencho
		Estado est1 = new Estado(null,"Minas Gerais");//id null pois o id será auto-gerado
		Estado est2 = new Estado(null,"São Paulo");
		//foi chamado acima e aqui salvo
		estadoRepository.saveAll(Arrays.asList(est1,est2));
	}

}
