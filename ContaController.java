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

import br.ufpb.dcx.poo.restaurantes.models.Conta;

@RequestMapping(value = "/conta")
@RestController
public class ContaController {
	
	private Map<Integer, Conta> contas;
	private long nextId = 1;

	public ContaController() {
		contas = new HashMap<Integer, Conta>();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Conta>> listar() {
		return new ResponseEntity<List<Conta>>(new ArrayList<Conta>(contas.values()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Conta> obter(@PathVariable("id") Integer id) {
		return new ResponseEntity<Conta>(contas.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Conta> adicionar(@RequestBody Conta conta) {
		conta.setId(nextId);
		contas.put((int) nextId++, conta);
		return new ResponseEntity<Conta>(conta, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Conta> deletar(@PathVariable("id") int id) {
		Conta conta = contas.remove(id);
		if (conta == null) {
			return new ResponseEntity<Conta>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Conta>(HttpStatus.NO_CONTENT);
	}
	
}
