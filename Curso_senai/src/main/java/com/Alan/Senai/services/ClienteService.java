package com.Alan.Senai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alan.Senai.domain.Cliente;
import com.Alan.Senai.repositories.ClienteRepository;
import com.Alan.Senai.repositories.EnderecoRepository;
import com.Alan.Senai.services.exceptions.ObjectNotFoundException;

@Service // cuida da manipulação dos dados pela web
public class ClienteService {
	@Autowired // instacia do repositorio que tem DML(manipulação de dados)
	private ClienteRepository repo;// repo - objeto criado
	@Autowired
	private EnderecoRepository enderecoRepository;

	// faz a busca do cliente pelo id
	public Cliente buscar(Integer idCliente) {
		// Optional para que não de NullPointerException
		Optional<Cliente> obj = repo.findById(idCliente);
		// me retorna uma mensagem de erro
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"núnero do id não encontrado: " + idCliente + " tipo: " + Cliente.class.getName()));
	}

	// busca todos os clientes
	public List<Cliente> findAll() {
		return repo.findAll();
	}

	// insere um endereço em cliente
	public Cliente insert(Cliente obj) {
		obj.setIdCliente(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	// atualiza um cliente
	public Cliente update(Cliente obj) {
		// busca o cliente a ser atualizado
		buscar(obj.getIdCliente());
		return repo.save(obj);
	}
}
