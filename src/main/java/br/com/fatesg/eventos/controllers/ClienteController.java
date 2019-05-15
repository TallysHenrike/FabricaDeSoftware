package br.com.fatesg.eventos.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.fatesg.eventos.entities.Cliente;
import br.com.fatesg.eventos.persistence.ClienteDao;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteDao clienteDao;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public List<Cliente> listar() {
		return clienteDao.findAll();
	}

	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public Optional<Cliente> buscar(@PathVariable Long id) {
		return clienteDao.findById(id);
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id) {
		clienteDao.deleteById(id);
	}

	@RequestMapping(value = "inserir/{idCliente}", method = RequestMethod.POST)
	public Cliente inserir(@RequestBody Cliente cliente, @PathVariable Long idCliente) {
		return clienteDao.save(cliente);
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Cliente alterar(@RequestBody Cliente cliente) {
		return clienteDao.save(cliente);
	}

}
