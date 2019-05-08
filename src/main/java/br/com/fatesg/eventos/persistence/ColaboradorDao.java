package br.com.fatesg.eventos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fatesg.eventos.entities.Colaborador;

public interface ColaboradorDao extends JpaRepository<Colaborador, Long> {
	
	@Query(value = "SELECT * from Colaborador c where c.evento_id_evento = :idEvento", nativeQuery=true)
	public List<Colaborador> listarDe(@Param("idEvento") long idEvento);
}