package br.com.fatesg.eventos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatesg.eventos.entities.Patrocinador;

public interface PatrocinadorDao extends JpaRepository<Patrocinador, Long> {}