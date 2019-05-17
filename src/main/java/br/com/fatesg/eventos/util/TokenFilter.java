package br.com.fatesg.eventos.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String header = req.getHeader("Authorization");
		
		if(header.equals("Bearer ") || header.isEmpty()) {
			throw new ServletException("Token inexistente ou invalido");
		}
		
		String token = header.substring(7);
		System.out.println("token: " + token);

		try {
			Jwts.parser().setSigningKey("abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890").parseClaimsJws(token).getBody();
		}catch (Exception e) {
			throw new ServletException("Token inválido");
		}
		
		chain.doFilter(request, response);
	}

}