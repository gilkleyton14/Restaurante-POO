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

import br.ufpb.dcx.poo.restaurantes.models.Restaurante;

@RequestMapping(value = "/restaurantes")
@RestController
public class RestauranteController {

	private Map<Integer, Restaurante> restaurantes;
	private long nextId = 1;

	public RestauranteController() {
		restaurantes = new HashMap<Integer, Restaurante>();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Restaurante>> listar() {
		return new ResponseEntity<List<Restaurante>>(new ArrayList<Restaurante>(restaurantes.values()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Restaurante> obter(@PathVariable("id") Integer id) {
		return new ResponseEntity<Restaurante>(restaurantes.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Restaurante> adicionar(@RequestBody Restaurante restaurante) {
		restaurante.setId(nextId);
		restaurantes.put((int) nextId++, restaurante);
		return new ResponseEntity<Restaurante>(restaurante, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Restaurante> deletar(@PathVariable("id") int id) {
		Restaurante restaurante = restaurantes.remove(id);
		if (restaurante == null) {
			return new ResponseEntity<Restaurante>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Restaurante>(HttpStatus.NO_CONTENT);
	}

}