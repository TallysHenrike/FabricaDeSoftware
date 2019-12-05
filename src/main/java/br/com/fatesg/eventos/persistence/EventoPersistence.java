package br.com.fatesg.eventos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fatesg.eventos.model.Evento;

public interface EventoPersistence extends JpaRepository<Evento, Integer> {
	@Query("SELECT u from Evento u where u.categoria.codigo = :codigo")
	public List<Evento> listarEventosPorCategoria(@Param("codigo") Integer idCategoria);
}