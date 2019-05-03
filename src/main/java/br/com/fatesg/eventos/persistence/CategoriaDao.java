package br.com.fatesg.eventos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatesg.eventos.entities.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {}