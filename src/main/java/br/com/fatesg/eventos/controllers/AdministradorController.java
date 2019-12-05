package br.com.fatesg.eventos.controllers;

import br.com.fatesg.eventos.entities.Administrador;
import br.com.fatesg.eventos.persistence.AdministradorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
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
	public ResponseEntity<List<Administrador>> listar(ServletResponse response) throws IOException {
		try {
			List<Administrador> administrador = administradorDao.findAll();
			HttpStatus status = administrador.size() > 0? HttpStatus.OK : HttpStatus.NO_CONTENT;
			
			return ResponseEntity.status(status).body(administrador);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Administrador>> buscar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			Optional<Administrador> administrador = administradorDao.findById(id);			
			return ResponseEntity.status(HttpStatus.OK).body(administrador);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id, ServletResponse response) throws IOException {
		try {
			administradorDao.deleteById(id);
		} catch (Exception e) {
			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "inserir", method = RequestMethod.POST)
	public ResponseEntity<Administrador> inserir(@RequestBody Administrador administrador, ServletResponse response) throws IOException {
		try {
			administrador.setDataDeCadastro(new Date());
			return ResponseEntity.status(HttpStatus.CREATED).body(administradorDao.save(administrador));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public ResponseEntity<Administrador> alterar(@RequestBody Administrador administrador, ServletResponse response) throws IOException {
		try {
			administrador.setDataDeAtualizacao(new Date());
			return ResponseEntity.status(HttpStatus.OK).body(administradorDao.save(administrador));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}