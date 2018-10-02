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

import br.ufpb.dcx.poo.restaurantes.models.Reserva;

@RequestMapping(value = "/reserva")
@RestController
public class ReservaController {
	
	private Map<Integer, Reserva> reservas;
	private long nextId = 1;

	public ReservaController() {
		reservas = new HashMap<Integer, Reserva>();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Reserva>> listar() {
		return new ResponseEntity<List<Reserva>>(new ArrayList<Reserva>(reservas.values()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Reserva> obter(@PathVariable("id") Integer id) {
		return new ResponseEntity<Reserva>(reservas.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Reserva> adicionar(@RequestBody Reserva reserva) {
		reserva.setId(nextId);
		reservas.put((int) nextId++, reserva);
		return new ResponseEntity<Reserva>(reserva, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Reserva> deletar(@PathVariable("id") int id) {
		Reserva reserva = reservas.remove(id);
		if (reserva == null) {
			return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Reserva>(HttpStatus.NO_CONTENT);
	}
	

}
