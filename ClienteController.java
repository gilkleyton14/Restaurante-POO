package br.ufpb.dcx.poo.restaurantes.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.dcx.poo.restaurantes.models.Cliente;

@RequestMapping(value = "/cliente")
@RestController
public class ClienteController {
	
	private Map<Integer, Cliente> clientes;
	private long nextId = 1;

	public ClienteController() {
		clientes = new HashMap<Integer, Cliente>();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar() {
		return new ResponseEntity<List<Cliente>>(new ArrayList<Cliente>(clientes.values()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> obter(@PathVariable("id") Integer id) {
		return new ResponseEntity<Cliente>(clientes.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {
		cliente.setId(nextId);
		clientes.put((int) nextId++, cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> deletar(@PathVariable("id") int id) {
		Cliente cliente = clientes.remove(id);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}


}
