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

import br.com.fatesg.eventos.entities.Categoria;
import br.com.fatesg.eventos.persistence.CategoriaPersistence;

@RestController
@RequestMapping("/restrito/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaPersistence categoriaDao;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public List<Categoria> listar() {
		return categoriaDao.findAll();
	}

	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Categoria> buscar(@PathVariable Long id) {
		return categoriaDao.findById(id);
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id) {
		categoriaDao.deleteById(id);
	}

	@RequestMapping(value = "inserir", method = RequestMethod.POST)
	public Categoria inserir(@RequestBody Categoria categoria) {
		categoria.setDataDeCadastro(new Date());
		return categoriaDao.save(categoria);
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Categoria alterar(@RequestBody Categoria categoria) {
		categoria.setDataDeAtualizacao(new Date());
		return categoriaDao.save(categoria);
	}

}