package br.com.fatesg.eventos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fatesg.eventos.entities.Administrador;

public interface AdministradorDao extends JpaRepository<Administrador, Long> {
	
	@Query("SELECT u from Administrador u where u.usuario = :usuario and u.senha = :senha")
	public Administrador validarAcesso(@Param("usuario") String usuario, @Param("senha") String senha);
}