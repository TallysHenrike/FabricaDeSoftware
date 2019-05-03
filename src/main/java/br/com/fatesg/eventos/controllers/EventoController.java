package br.com.fatesg.eventos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.eventos.entities.Evento;
import br.com.fatesg.eventos.persistence.EventoDao;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoDao eventoDao;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public List<Evento> listar() {
		return eventoDao.findAll();
	}
	
	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Evento> buscar(@PathVariable Long id) {
		return eventoDao.findById(id);
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id) {
		eventoDao.deleteById(id);
	}

	@RequestMapping(value = "inserir", method = RequestMethod.POST)
	public Evento inserir(@RequestBody Evento categoria) {
		return eventoDao.save(categoria);
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Evento alterar(@RequestBody Evento categoria) {
		return eventoDao.save(categoria);
	}

}