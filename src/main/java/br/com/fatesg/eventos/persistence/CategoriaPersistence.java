package br.com.fatesg.eventos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatesg.eventos.model.Categoria;

public interface CategoriaPersistence extends JpaRepository<Categoria, Integer> {}