package br.com.fatesg.eventos.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.eventos.entities.Administrador;
import br.com.fatesg.eventos.persistence.AdministradorPersistence;
import br.com.fatesg.eventos.util.LoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

	@Autowired
	private AdministradorPersistence administradorDao;

	@RequestMapping(value = "acessar", method = RequestMethod.POST)
	public Map<String, Object> acessar(@RequestBody Administrador administrador) throws ServletException {
		Administrador adm = administradorDao.validarAcesso(administrador.getUsuario(), administrador.getSenha());
		Map<String, Object> mapeamento = new HashMap<String, Object>();
		
		if(adm.getNome() == null) {
			throw new ServletException("USUARIO NÃO ENCONTRADO");
		}else {
			//Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
			String token = Jwts.builder()
				.setSubject(adm.getNome())
				.signWith(SignatureAlgorithm.HS256, "abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890")
				.setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
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