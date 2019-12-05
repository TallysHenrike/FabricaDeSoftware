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

import br.com.fatesg.eventos.model.Administrador;
import br.com.fatesg.eventos.persistence.AdministradorPersistence;

@RestController
public class AdministradorController {

	@Autowired
	private AdministradorPersistence persistence;
	private final HttpServletRequest request;

	@Autowired
	public AdministradorController(HttpServletRequest request) {
		this.request = request;
	}

	@RequestMapping(value = "/administrador/{codigo}", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<Optional<Administrador>> buscar(@PathVariable("codigo") Integer codigo) throws IOException {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return ResponseEntity.status(HttpStatus.OK).body(persistence.findById(codigo));
		}

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@RequestMapping(value = "/administrador", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<Administrador>> listarAdministradores(ServletResponse response) throws IOException {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			List<Administrador> administradores = persistence.findAll();
			HttpStatus status = administradores.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT;

			return ResponseEntity.status(status).body(administradores);
		}
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@RequestMapping(value = "/administrador", produces = { "application/json" }, consumes = { "multipart/form-data" }, method = RequestMethod.POST)
	public ResponseEntity<Administrador> inserirAdministrador(@Valid @RequestParam Administrador administrador) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("multipart/form-data")) {
			persistence.save(administrador);
		}
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
	
	@RequestMapping(value = "/administrador", produces = { "application/json" }, consumes = { "multipart/form-data" }, method = RequestMethod.PUT)
	public ResponseEntity<Administrador> alterarAdministrador(@Valid @RequestParam Administrador administrador) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("multipart/form-data")) {
			persistence.save(administrador);
		}
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@RequestMapping(value = "/administrador/{codigo}", method = RequestMethod.DELETE)
	public void removerAdministrador(@PathVariable("codigo") Integer codigo) throws IOException {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			persistence.deleteById(codigo);
		}
	}
}