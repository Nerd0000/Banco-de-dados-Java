package com.Alan.Senai.resources;//responsavel pela interação front e backend

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Alan.Senai.domain.Cliente;
import com.Alan.Senai.services.ClienteService;

@RestController // para serializar e transformar em Json ou Xml
@RequestMapping(value = "/clientes") // caminho que será encontrado
public class ClienteResource {
	@Autowired // instancia sem new
	private ClienteService service;// pega os metodos do services

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // retorna o cliente com o id digitado
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {// responde cliente do domain e tranforma o id em url
		Cliente obj = service.buscar(id);// pega o id
		return ResponseEntity.ok().body(obj);// retorna no corpo do objeto todas as informações
	}

	@RequestMapping(method = RequestMethod.GET) // retorna todos os clientes
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// insere valor
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Cliente obj) {// puxa a resposta vazia e
		obj = service.insert(obj);//insere uma valida na requisição
		//--Uri e o trabalho de browser para enviar para o backend
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
