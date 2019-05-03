package br.com.fatesg.eventos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatesg.eventos.entities.Colaborador;

public interface ColaboradorDao extends JpaRepository<Colaborador, Long> {}