package br.com.fatesg.eventos.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.eventos.entities.Administrador;
import br.com.fatesg.eventos.persistence.AdministradorDao;
import br.com.fatesg.eventos.util.LoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private AdministradorDao administradorDao;
	private Administrador administrador = new Administrador();
	private Map<String, Object> mapeamento = new HashMap<String, Object>();

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
		administrador.setDataDeCadastro(new Date());
		return administradorDao.save(administrador);
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Administrador alterar(@RequestBody Administrador administrador) {
		administrador.setDataDeAtualizacao(new Date());
		return administradorDao.save(administrador);
	}

	@RequestMapping(value = "acessar", method = RequestMethod.POST)
	public Map<String, Object> acessar(@RequestBody Administrador administrador) throws ServletException {
		Administrador adm = administradorDao.validarAcesso(administrador.getUsuario(), administrador.getSenha());
		
		if(adm.getNome() == null) {
			throw new ServletException("USUARIO NÃO ENCONTRADO");
		}else {
			//Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
			String token = Jwts.builder()
				.setSubject(adm.getNome())
				.signWith(SignatureAlgorithm.HS256, "abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890")
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
				.compact();
			
			mapeamento.put("idAdministrador", adm.getIdAdministrador());
			mapeamento.put("nome", adm.getNome());
			mapeamento.put("usuario", adm.getUsuario());
			//mapeamento.put("senha", adm.getSenha());
			mapeamento.put("foto", adm.getFoto());
			mapeamento.put("acesso", new LoginResponse(token));
			
			return mapeamento;
		}
	}
}