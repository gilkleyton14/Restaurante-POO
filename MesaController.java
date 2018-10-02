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

import br.ufpb.dcx.poo.restaurantes.models.Mesa;

@RequestMapping(value = "/mesa")
@RestController
public class MesaController {

	private Map<Integer, Mesa> mesas;
	private long nextId = 1;

	public MesaController() {
			mesas = new HashMap<Integer, Mesa>();
		}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Mesa>> listar() {
		return new ResponseEntity<List<Mesa>>(new ArrayList<Mesa>(mesas.values()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mesa> obter(@PathVariable("id") Integer id) {
		return new ResponseEntity<Mesa>(mesas.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Mesa> adicionar(@RequestBody Mesa mesa) {
		mesa.setId(nextId);
		mesas.put((int) nextId++, mesa);
		return new ResponseEntity<Mesa>(mesa, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Mesa> deletar(@PathVariable("id") int id) {
		Mesa mesa = mesas.remove(id);
		if (mesa == null) {
			return new ResponseEntity<Mesa>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Mesa>(HttpStatus.NO_CONTENT);
	}

}
