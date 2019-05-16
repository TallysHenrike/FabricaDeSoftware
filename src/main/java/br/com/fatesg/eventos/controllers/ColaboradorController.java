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

import br.com.fatesg.eventos.entities.Colaborador;
import br.com.fatesg.eventos.entities.Evento;
import br.com.fatesg.eventos.persistence.ColaboradorDao;

@RestController
@RequestMapping("/restrito/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorDao colaboradorDao;

	@RequestMapping(value = "listar/{idEvento}", method = RequestMethod.GET)
	public List<Colaborador> listar(@PathVariable Long idEvento) {
		return colaboradorDao.findAllByIdEvento(idEvento);
	}
	
	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Colaborador> buscar(@PathVariable Long id) {
		return colaboradorDao.findById(id);
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id) {
		colaboradorDao.deleteById(id);
	}

	@RequestMapping(value = "inserir/{idEvento}", method = RequestMethod.POST)
	public Colaborador inserir(@RequestBody Colaborador colaborador, @PathVariable Long idEvento) {
		Evento evento = new Evento();
		evento.setIdEvento(idEvento);
		
		colaborador.setEvento(evento);
		colaborador.setDataDeCadastro(new Date());
		return colaboradorDao.save(colaborador);
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Colaborador alterar(@RequestBody Colaborador colaborador) {
		colaborador.setDataDeCadastro(new Date());
		return colaboradorDao.save(colaborador);
	}

}