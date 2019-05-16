package br.com.fatesg.eventos.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.eventos.entities.Evento;
import br.com.fatesg.eventos.entities.Patrocinador;
import br.com.fatesg.eventos.persistence.PatrocinadorDao;

@RestController
@RequestMapping("/restrito/patrocinador")
public class PatrocinadorController {

	@Autowired
	private PatrocinadorDao patrocinadorDao;
	
	@RequestMapping(value = "listar/{idEvento}", method = RequestMethod.GET)
	public List<Patrocinador> listar(@PathVariable Long idEvento) {
		return patrocinadorDao.findAllByIdEvento(idEvento);
	}

	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Patrocinador> buscar(@PathVariable Long id) {
		return patrocinadorDao.findById(id);
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id) {
		patrocinadorDao.deleteById(id);
	}

	@RequestMapping(value = "inserir/{idEvento}", method = RequestMethod.POST)
	public Patrocinador inserir(@RequestBody Patrocinador patrocinador, @PathVariable Long idEvento) {
		Evento evento = new Evento();
		evento.setIdEvento(idEvento);

		patrocinador.setEvento(evento);
		patrocinador.setDataDeCadastro(new Date());
		return patrocinadorDao.save(patrocinador);
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Patrocinador alterar(@RequestBody Patrocinador patrocinador) {
		patrocinador.setDataDeAtualizacao(new Date());
		return patrocinadorDao.save(patrocinador);
	}

}