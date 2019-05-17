package br.com.fatesg.eventos.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.eventos.entities.Categoria;
import br.com.fatesg.eventos.persistence.CategoriaDao;

@RestController
@RequestMapping("/restrito/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaDao categoriaDao;
	private Map<String, Object> mapeamento = new HashMap<String, Object>();
	private Categoria categoria = new Categoria();

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
	public Map<String, Object> inserir(HttpServletRequest request, @RequestBody Map<String, String> objeto) {
		categoria.setNome(objeto.get("nome"));
		categoria.setDescricao(objeto.get("descricao"));
		categoria.setIcone(Base64.decodeBase64(objeto.get("icone").getBytes()));
		categoria.setDataDeCadastro(new Date());

		Categoria values = categoriaDao.save(categoria);

		mapeamento.put("idCategoria", values.getIdCategoria());
		mapeamento.put("nome", values.getNome());
		mapeamento.put("descricao", values.getDescricao());
		mapeamento.put("icone", values.getIcone());
		mapeamento.put("dataDeCadastro", values.getDataDeCadastro());

		return mapeamento;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Map<String, Object> alterar(@RequestBody Map<String, String> objeto) {
		categoria.setNome(objeto.get("nome"));
		categoria.setDescricao(objeto.get("descricao"));
		categoria.setIcone(Base64.decodeBase64(objeto.get("icone").getBytes()));
		categoria.setDataDeAtualizacao(new Date());

		Categoria values = categoriaDao.save(categoria);

		mapeamento.put("idCategoria", values.getIdCategoria());
		mapeamento.put("nome", values.getNome());
		mapeamento.put("descricao", values.getDescricao());
		mapeamento.put("icone", values.getIcone());
		mapeamento.put("dataDeCadastro", values.getDataDeCadastro());

		return mapeamento;
	}

}