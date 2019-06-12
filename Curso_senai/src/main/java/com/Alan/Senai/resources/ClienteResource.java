package com.Alan.Senai.resources;//Esse pacote lida com a transmissão de tudo que foi criado no backEnd para o Front

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Alan.Senai.domain.Cliente;
import com.Alan.Senai.services.ClienteService;

@RestController // para serializar e transformar em Json ou Xml
@RequestMapping(value = "/clientes") // caminho que será encontrado
public class ClienteResource {
	@Autowired // instancia sem new
	private ClienteService service;// pega os metodos do services

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // pede o id do cliente
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {// responde cliente do domain e tranforma o id em url
		Cliente obj = service.buscar(id);// pega o id
		return ResponseEntity.ok().body(obj);// retorna no corpo do objeto todas as informações
	}
}
