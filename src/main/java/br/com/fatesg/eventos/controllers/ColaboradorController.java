package br.com.fatesg.eventos.controllers;

import br.com.fatesg.eventos.entities.Colaborador;
import br.com.fatesg.eventos.entities.Evento;
import br.com.fatesg.eventos.persistence.ColaboradorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restrito/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorPersistence colaboradorDao;

	@RequestMapping(value = "listar/{idEvento}", method = RequestMethod.GET)
	public List<Colaborador> listar(@PathVariable Long idEvento, ServletResponse response) throws IOException {
		try {
			return colaboradorDao.findAllByIdEvento(idEvento);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi " +
					"possível listar os colaboradores!");
		}
		return null;
	}
	
	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Colaborador> buscar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			return colaboradorDao.findById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi " +
					"possível buscar o colaborador!");
		}
		return null;
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			colaboradorDao.deleteById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi " +
					"possível deletar o colaborador!");
		}
	}

	@RequestMapping(value = "inserir/{idEvento}", method = RequestMethod.POST)
	public Colaborador inserir(@RequestBody Colaborador colaborador, @PathVariable Long idEvento,
	                           ServletResponse response) throws IOException {
		try {
			Evento evento = new Evento();
			evento.setIdEvento(idEvento);

			colaborador.setEvento(evento);
			colaborador.setDataDeCadastro(new Date());
			return colaboradorDao.save(colaborador);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi " +
					"possível adicionar o colaborador!");
		}
		return null;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Colaborador alterar(@RequestBody Colaborador colaborador, ServletResponse response) throws IOException {
		try {
			colaborador.setDataDeCadastro(new Date());
			return colaboradorDao.save(colaborador);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi " +
					"possível alterar o colaborador!");
		}
		return null;
	}
}