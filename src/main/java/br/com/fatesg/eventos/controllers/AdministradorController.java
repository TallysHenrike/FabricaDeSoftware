package br.com.fatesg.eventos.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.eventos.entities.Administrador;
import br.com.fatesg.eventos.persistence.AdministradorDao;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AdministradorDao administradorDao;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public List<Administrador> listar() {
		return administradorDao.findAll();
	}

	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Administrador> buscar(@PathVariable Long id) {
		return administradorDao.findById(id);
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id) {
		administradorDao.deleteById(id);
	}

	@RequestMapping(value = "inserir", method = RequestMethod.POST)
	public Administrador inserir(@RequestBody Administrador administrador) {
		return administradorDao.save(administrador);
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Administrador alterar(@RequestBody Administrador administrador) {
		return administradorDao.save(administrador);
	}

	@RequestMapping(value = "acessar", method = RequestMethod.POST)
	public Administrador acessar(@RequestBody Administrador administrador) {
		try {
			Query query = em
					.createQuery("SELECT u from Administrador u where u.usuario = :usuario and u.senha = :senha")
					.setParameter("usuario", administrador.getUsuario())
					.setParameter("senha", administrador.getSenha());
			return (Administrador) query.getSingleResult();			
		}catch (Exception e) {
			return null;
		}
	}

}