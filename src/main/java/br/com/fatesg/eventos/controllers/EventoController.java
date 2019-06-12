package br.com.fatesg.eventos.controllers;

import br.com.fatesg.eventos.entities.Administrador;
import br.com.fatesg.eventos.entities.Evento;
import br.com.fatesg.eventos.persistence.EventoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Evento> listar(ServletResponse response) throws IOException {
		try {
			return eventoDao.findAll();
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível listar os eventos!");
		}
		return null;
	}
	
	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Evento> buscar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			return eventoDao.findById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível buscar o evento!");
		}
		return null;
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			eventoDao.deleteById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível deletar o evento!");
		}
	}

	@RequestMapping(value = "inserir/{idAdministrador}", method = RequestMethod.POST)
	public Evento inserir(@RequestBody Evento evento, @PathVariable Long idAdministrador, ServletResponse response) throws IOException {
		try {
			Administrador administrador = new Administrador();
			administrador.setIdAdministrador(idAdministrador);

			evento.setAdministrador(administrador);
			evento.setDataDeCadastro(new Date());

			return eventoDao.save(evento);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível adicionar o evento!");
		}
		return null;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Evento alterar(@RequestBody Evento evento, ServletResponse response) throws IOException {
		try {
			evento.setDataDeAtualizacao(new Date());
			return eventoDao.save(evento);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível alterar o evento!");
		}
		return null;
	}
}