package br.com.fatesg.eventos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatesg.eventos.entities.Administrador;

public interface AdministradorDao extends JpaRepository<Administrador, Long> {}