package br.com.fatesg.eventos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatesg.eventos.entities.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {}
