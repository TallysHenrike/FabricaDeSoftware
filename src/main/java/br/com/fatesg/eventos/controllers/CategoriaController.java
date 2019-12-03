package br.com.fatesg.eventos.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.eventos.entities.Categoria;
import br.com.fatesg.eventos.persistence.CategoriaPersistence;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaPersistence persistence;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listar(ServletResponse response) throws IOException {
		try {
			List<Categoria> categorias = persistence.findAll();
			HttpStatus status = categorias.size() > 0? HttpStatus.OK : HttpStatus.NO_CONTENT;
			
			return ResponseEntity.status(status).body(categorias);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> buscar(@PathVariable Long codigo, ServletResponse response) throws IOException {
		try {
			Optional<Categoria> categoria = persistence.findById(codigo);
			return ResponseEntity.status(HttpStatus.OK).body(categoria);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}