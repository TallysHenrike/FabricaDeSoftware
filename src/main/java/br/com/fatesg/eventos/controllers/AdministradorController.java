package br.com.fatesg.eventos.controllers;

import br.com.fatesg.eventos.entities.Administrador;
import br.com.fatesg.eventos.persistence.AdministradorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restrito/administrador")
public class AdministradorController {

	@Autowired
	private AdministradorPersistence administradorDao;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public List<Administrador> listar(ServletResponse response) throws IOException {
		try {
			return administradorDao.findAll();
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível listar os administradores!");
		}
		return null;
	}

	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Administrador> buscar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			return administradorDao.findById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível buscar o administrador!");
		}
		return null;
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			administradorDao.deleteById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível deletar o administrador!");
		}
	}

	@RequestMapping(value = "inserir", method = RequestMethod.POST)
	public Administrador inserir(@RequestBody Administrador administrador, ServletResponse response) throws IOException {
		try {
			administrador.setDataDeCadastro(new Date());
			return administradorDao.save(administrador);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível adicionar o administrador!");
		}
		return null;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Administrador alterar(@RequestBody Administrador administrador, ServletResponse response) throws IOException {
		try {
			administrador.setDataDeAtualizacao(new Date());
			return administradorDao.save(administrador);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível alterar o administrador!");
		}
		return null;
	}
}