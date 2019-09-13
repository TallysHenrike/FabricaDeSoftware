package br.com.fatesg.eventos.controllers;

import br.com.fatesg.eventos.entities.Administrador;
import br.com.fatesg.eventos.entities.Evento;
import br.com.fatesg.eventos.persistence.EventoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restrito/evento")
public class EventoController {

	@Autowired
	private EventoPersistence eventoDao;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> listar(ServletResponse response) throws IOException {
		try {
			List<Evento> eventos = eventoDao.findAll();
			HttpStatus status = eventos.size() > 0? HttpStatus.OK : HttpStatus.NO_CONTENT;
			
			return ResponseEntity.status(status).body(eventos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Evento>> buscar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			Optional<Evento> evento = eventoDao.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(evento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			eventoDao.deleteById(id);
		} catch (Exception e) {
			
		}
	}

	@RequestMapping(value = "inserir/{idAdministrador}", method = RequestMethod.POST)
	public ResponseEntity<Evento> inserir(@RequestBody Evento evento, @PathVariable Long idAdministrador, ServletResponse response) throws IOException {
		try {
			Administrador administrador = new Administrador();
			administrador.setIdAdministrador(idAdministrador);

			evento.setAdministrador(administrador);
			evento.setDataDeCadastro(new Date());
			
			administrador.setDataDeCadastro(new Date());
			return ResponseEntity.status(HttpStatus.CREATED).body(eventoDao.save(evento));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public ResponseEntity<Evento> alterar(@RequestBody Evento evento, ServletResponse response) throws IOException {
		try {
			evento.setDataDeAtualizacao(new Date());
			return ResponseEntity.status(HttpStatus.OK).body(eventoDao.save(evento));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}