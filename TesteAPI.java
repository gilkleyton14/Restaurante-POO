package br.ufpb.dcx.poo.restaurantes.testes;

import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;

import com.jayway.restassured.specification.RequestSpecification;

public class TesteAPI {

	public TesteAPI() {
		baseURI = "http://localhost:8080/restaurantes";
	}

	/* Chama o serviço pelo metodo POST */
	@Test
	public void testeCardapio() {
		String myJson = "{\"id\":\"1\",\"nome\":\"Tempero bom\"}";

		given()
			.contentType("application/json")
			.body(myJson)
		.when()
			.post("/")
		.then()
			.statusCode(200)
			.body("message",containsString("Restaurante criado com sucesso"));
	}

	/* Chama o serviço pelo metodo GET */
	@Test
	public void testConsultaRestaurante() {

		given()
		.when()
			.get("/1")
		.then()
			.statusCode(200)
			.body("id", is(1))
			.body("nome", equalTo("Tempero bom"));
			assertThat()
				.body(matchesJsonSchemaInClasspath("schema_exemplo.json"));
	}

	private RequestSpecification assertThat() {
		return null;
	}

}

