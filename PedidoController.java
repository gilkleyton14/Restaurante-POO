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

import br.ufpb.dcx.poo.restaurantes.models.Pedido;

@RequestMapping(value = "/pedido")
@RestController
public class PedidoController {

	private Map<Integer, Pedido> pedidos;
	private long nextId = 1;

	public PedidoController() {
		pedidos = new HashMap<Integer, Pedido>();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pedido>> listar() {
		return new ResponseEntity<List<Pedido>>(new ArrayList<Pedido>(pedidos.values()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> obter(@PathVariable("id") Integer id) {
		return new ResponseEntity<Pedido>(pedidos.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Pedido> adicionar(@RequestBody Pedido pedido) {
		pedido.setId(nextId);
		pedidos.put((int) nextId++, pedido);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pedido> deletar(@PathVariable("id") int id) {
		Pedido pedido = pedidos.remove(id);
		if (pedido == null) {
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Pedido>(HttpStatus.NO_CONTENT);
	}

}
