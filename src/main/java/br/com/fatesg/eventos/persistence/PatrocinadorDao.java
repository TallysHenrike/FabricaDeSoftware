package br.com.fatesg.eventos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fatesg.eventos.entities.Patrocinador;

public interface PatrocinadorDao extends JpaRepository<Patrocinador, Long> {
	
	@Query("SELECT p FROM Patrocinador p WHERE p.evento.idEvento = :idEvento")
	public List<Patrocinador> findAllByIdEvento(@Param("idEvento") long idPatrocinador);
}