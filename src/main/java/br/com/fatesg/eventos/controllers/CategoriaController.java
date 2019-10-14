package br.com.fatesg.eventos.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.eventos.entities.Categoria;
import br.com.fatesg.eventos.persistence.CategoriaPersistence;

@RestController
@RequestMapping("/restrito/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaPersistence categoriaDao;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listar(ServletResponse response) throws IOException {
		try {
			List<Categoria> categorias = categoriaDao.findAll();
			HttpStatus status = categorias.size() > 0? HttpStatus.OK : HttpStatus.NO_CONTENT;
			
			return ResponseEntity.status(status).body(categorias);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> buscar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			Optional<Categoria> categoria = categoriaDao.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(categoria);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			categoriaDao.deleteById(id);
		} catch (Exception e) {
			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "inserir", method = RequestMethod.POST)
	public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria, ServletResponse response) throws IOException {
		try {
			categoria.setDataDeCadastro(new Date());
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDao.save(categoria));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria, ServletResponse response) throws IOException {
		try {
			categoria.setDataDeAtualizacao(new Date());
			return ResponseEntity.status(HttpStatus.OK).body(categoriaDao.save(categoria));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}