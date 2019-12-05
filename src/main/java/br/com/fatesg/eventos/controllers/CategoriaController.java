package br.com.fatesg.eventos.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.eventos.model.Categoria;
import br.com.fatesg.eventos.persistence.CategoriaPersistence;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaPersistence persistence;
	private final HttpServletRequest request;

	@Autowired
	public CategoriaController(HttpServletRequest request) {
		this.request = request;
	}

	@RequestMapping(value = "/categoria/{codigo}", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> buscar(@PathVariable("codigo") Integer codigo) throws IOException {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return ResponseEntity.status(HttpStatus.OK).body(persistence.findById(codigo));
		}

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@RequestMapping(value = "/categoria", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listarCategoria(ServletResponse response) throws IOException {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			List<Categoria> categorias = persistence.findAll();
			HttpStatus status = categorias.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT;

			return ResponseEntity.status(status).body(categorias);
		}
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@RequestMapping(value = "/categoria", produces = { "application/json" }, consumes = { "multipart/form-data" }, method = RequestMethod.POST)
	public ResponseEntity<Categoria> inserirCategoria(@Valid @RequestParam Categoria categoria) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			persistence.save(categoria);
		}
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
	
	@RequestMapping(value = "/categoria", produces = { "application/json" }, consumes = { "multipart/form-data" }, method = RequestMethod.PUT)
	public ResponseEntity<Categoria> alterarCategoria(@Valid @RequestParam Categoria categoria) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			persistence.save(categoria);
		}
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@RequestMapping(value = "/categoria/{codigo}", method = RequestMethod.DELETE)
	public void removerCategoria(@PathVariable("codigo") Integer codigo) throws IOException {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			persistence.deleteById(codigo);
		}
	}
}