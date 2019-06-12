package br.com.fatesg.eventos.controllers;

import br.com.fatesg.eventos.entities.Categoria;
import br.com.fatesg.eventos.persistence.CategoriaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restrito/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaPersistence categoriaDao;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public List<Categoria> listar(ServletResponse response) throws IOException {
		try {
			return categoriaDao.findAll();
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível listar as categorias!");
		}
		return null;
	}

	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Categoria> buscar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			return categoriaDao.findById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível buscar a categorias");
		}
		return null;
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			categoriaDao.deleteById(id);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível deletar a categoria!");
		}
	}

	@RequestMapping(value = "inserir", method = RequestMethod.POST)
	public Categoria inserir(@RequestBody Categoria categoria, ServletResponse response) throws IOException {
		try {
			categoria.setDataDeCadastro(new Date());
			return categoriaDao.save(categoria);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível adicionar a categoria!");
		}
		return null;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Categoria alterar(@RequestBody Categoria categoria, ServletResponse response) throws IOException {
		try {
			categoria.setDataDeAtualizacao(new Date());
			return categoriaDao.save(categoria);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Não foi possível alterar a categoria!");
		}
		return null;
	}
}