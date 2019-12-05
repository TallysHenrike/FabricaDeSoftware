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

import br.com.fatesg.eventos.model.Evento;
import br.com.fatesg.eventos.persistence.EventoPersistence;

@RestController
public class EventoController {

	@Autowired
	private EventoPersistence persistence;
	private final HttpServletRequest request;

	@Autowired
	public EventoController(HttpServletRequest request) {
		this.request = request;
	}

	@RequestMapping(value = "/evento/{codigo}", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<Optional<Evento>> buscarEvento(@PathVariable("codigo") Integer codigo) throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(persistence.findById(codigo));
	}
	
	@RequestMapping(value = "/evento/categoria/{codigo}", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> listarEventoPorCategoria(@PathVariable("codigo") Integer codigo) {
		return ResponseEntity.status(HttpStatus.OK).body(persistence.findAll());
	}

	@RequestMapping(value = "/evento", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> listarEvento(ServletResponse response) throws IOException {
		List<Evento> evento = persistence.findAll();
		HttpStatus status = evento.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT;

		return ResponseEntity.status(status).body(evento);
	}

	@RequestMapping(value = "/evento", produces = { "application/json" }, consumes = { "multipart/form-data" }, method = RequestMethod.POST)
	public ResponseEntity<Evento> inserirEvento(@Valid @RequestParam Evento evento) {
		persistence.save(evento);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@RequestMapping(value = "/evento", produces = { "application/json" }, consumes = { "multipart/form-data" }, method = RequestMethod.PUT)
	public ResponseEntity<Evento> alterarAdministrador(@Valid @RequestParam Evento evento) {
		persistence.save(evento);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value = "/evento/{codigo}", method = RequestMethod.DELETE)
	public void removerEvento(@PathVariable("codigo") Integer codigo) throws IOException {
		persistence.deleteById(codigo);
	}
}