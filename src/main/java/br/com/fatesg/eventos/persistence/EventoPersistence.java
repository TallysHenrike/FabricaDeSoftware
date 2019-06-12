package br.com.fatesg.eventos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatesg.eventos.entities.Evento;

public interface EventoPersistence extends JpaRepository<Evento, Long> {}