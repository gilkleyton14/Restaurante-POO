package br.ufpb.dcx.poo.restaurantes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.dcx.poo.restaurantes.controller.RestauranteController;
import br.ufpb.dcx.poo.restaurantes.models.Restaurante;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

//"http://localhost:8080/swagger-ui.html#/" Link do Swagger Api-Restaurante
@RestController
@CrossOrigin(origins  = "http://localhost:8080/restaurantes")
@RequestMapping("/restaurante")
public class RestauranteService {
	 
		private Object pessoaRepository;


		@ApiOperation(
				value="Cadastrar um novo restaurante", 
				response=RestauranteController.class, 
				notes="Essa operação salva um novo registro com as informações de restaurante.")
		@ApiResponses(value= {
				@ApiResponse(
						code=200, 
						message="Retorna um Restaurante com uma mensagem de sucesso",
						response=RestauranteController.class
						),
				@ApiResponse(
						code=500, 
						message="Caso tenhamos algum erro vamos retornar um Restaurante com a Exception",
						response=RestauranteController.class
						)
	 
		})
		@RequestMapping(value="/pessoa", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)	
		public @ResponseBody ResponseEntity<RestauranteController> salvar(@RequestBody Restaurante pessoa){
	 
	 
			try {
	 
				return new ResponseEntity<RestauranteController>(HttpStatus.OK);
	 
			}catch(Exception e) {
	 
				return new ResponseEntity<RestauranteController>(new RestauranteController(),HttpStatus.INTERNAL_SERVER_ERROR);			
			}
		}
	 
	 
		@RequestMapping(value="/pessoa", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public @ResponseBody RestauranteController atualizar(@RequestBody Restaurante pessoa){
	 
			try {		
	 
				return new RestauranteController();
	 
			}catch(Exception e) {
	 
				return new RestauranteController();
			}
		}
	 
	 
		@RequestMapping(value="/pessoa", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public @ResponseBody List<Restaurante> consultar(){
	 
			return (List<Restaurante>)this.pessoaRepository();
		}

		private List<Restaurante> pessoaRepository() {
			return null;

		}


		@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public @ResponseBody Restaurante buscar(@PathVariable("codigo") Integer codigo){
	 
			return (Restaurante) this.pessoaRepository;
		}
	 
	 
		@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public @ResponseBody RestauranteController excluir(@PathVariable("codigo") Integer codigo){
	 
			Restaurante restaurante = ((Restaurante) pessoaRepository).findOne(codigo);
	 
			try {
	 
				((Restaurante) pessoaRepository).delete(restaurante);
	 
				return new RestauranteController();
	 
			}catch(Exception e) {
				return new RestauranteController();
			}
		}
	 
}


