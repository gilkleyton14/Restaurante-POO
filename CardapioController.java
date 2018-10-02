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

import br.ufpb.dcx.poo.restaurantes.models.Cardapio;

@RequestMapping(value = "/cardapio")
@RestController
public class CardapioController {

	private Map<Integer, Cardapio> cardapios;
	private long nextId = 1;

	public CardapioController() {
		 cardapios = new HashMap<Integer, Cardapio>();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cardapio>> listar() {
		return new ResponseEntity<List<Cardapio>>(new ArrayList<Cardapio>(cardapios.values()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cardapio> obter(@PathVariable("id") Integer id) {
		return new ResponseEntity<Cardapio>(cardapios.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cardapio> adicionar(@RequestBody Cardapio cardapio) {
		cardapio.setId(nextId);
		cardapios.put((int) nextId++, cardapio);
		return new ResponseEntity<Cardapio>(cardapio, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Cardapio> deletar(@PathVariable("id") int id) {
		Cardapio cardapio = cardapios.remove(id);
		if (cardapio == null) {
			return new ResponseEntity<Cardapio>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cardapio>(HttpStatus.NO_CONTENT);	}
}
