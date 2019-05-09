package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Colaborador {

	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idColaborador;
	
	@NotNull
	@ManyToOne
	private Evento evento;
	@NotNull
	private String nome;
	@NotNull
	private String descricao;
	@NotNull
	private byte[] imagem;

	public Colaborador(@NotNull Long idColaborador, @NotNull Evento evento, @NotNull String nome,
			@NotNull String descricao, @NotNull byte[] imagem) {
		this.idColaborador = idColaborador;
		this.evento = evento;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
	}

	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
}