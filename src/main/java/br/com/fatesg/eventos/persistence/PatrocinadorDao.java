package br.com.fatesg.eventos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fatesg.eventos.entities.Patrocinador;

public interface PatrocinadorDao extends JpaRepository<Patrocinador, Long> {
	
	@Query(value = "SELECT * from Patrocinador p where p.evento_id_evento = :idEvento", nativeQuery=true)
	public List<Patrocinador> listarDe(@Param("idEvento") long idPatrocinador);
}