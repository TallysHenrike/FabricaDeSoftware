package br.com.fatesg.eventos.controllers;

import br.com.fatesg.eventos.entities.Evento;
import br.com.fatesg.eventos.entities.Patrocinador;
import br.com.fatesg.eventos.persistence.PatrocinadorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restrito/patrocinador")
public class PatrocinadorController {

	@Autowired
	private PatrocinadorPersistence patrocinadorDao;
	
	@RequestMapping(value = "listar/{idEvento}", method = RequestMethod.GET)
	public List<Patrocinador> listar(@PathVariable Long idEvento, ServletResponse response) throws IOException {
		try {
			return patrocinadorDao.findAllByIdEvento(idEvento);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível listar os patrocinadores!");
		}
		return null;
	}

	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Patrocinador> buscar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			return patrocinadorDao.findById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível buscar o patrocinador!");
		}
		return null;
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			patrocinadorDao.deleteById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível deletar o patrocinador!");
		}
	}

	@RequestMapping(value = "inserir/{idEvento}", method = RequestMethod.POST)
	public Patrocinador inserir(@RequestBody Patrocinador patrocinador, @PathVariable Long idEvento, ServletResponse response) throws IOException {
		try {
			Evento evento = new Evento();
			evento.setIdEvento(idEvento);

			patrocinador.setEvento(evento);
			patrocinador.setDataDeCadastro(new Date());
			return patrocinadorDao.save(patrocinador);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível adicionar o patrocinador!");
		}
		return null;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Patrocinador alterar(@RequestBody Patrocinador patrocinador, ServletResponse response) throws IOException {
		try {
			patrocinador.setDataDeAtualizacao(new Date());
			return patrocinadorDao.save(patrocinador);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível alterar o patrocinador!");
		}
		return null;
	}
}