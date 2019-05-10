package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
=======
import javax.validation.constraints.NotNull;
>>>>>>> refs/remotes/origin/validacao-eventos

@Entity
public class Colaborador {
<<<<<<< HEAD
	
	
=======

	@NotNull
>>>>>>> refs/remotes/origin/validacao-eventos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotEmpty(message= "identificador de colaborador não pode ser nulo.")
	private Long idColaborador;
	
<<<<<<< HEAD
=======
	@NotNull
>>>>>>> refs/remotes/origin/validacao-eventos
	@ManyToOne
	private Evento evento;
<<<<<<< HEAD
	
	@Size(min=2, max= 50)
	@NotEmpty(message= "o nome do colaborador não pode estar vazio.")
=======
	@NotNull
>>>>>>> refs/remotes/origin/validacao-eventos
	private String nome;
<<<<<<< HEAD
	
	@Size(min=2, max=50)
	@NotEmpty(message= "a descrição do colaborador não pode estar vazia.")
=======
	@NotNull
>>>>>>> refs/remotes/origin/validacao-eventos
	private String descricao;
<<<<<<< HEAD
	
	@Size(min=1, max=5)
	@NotEmpty(message= "Ao menos uma imagem do colaborador deve ser cadastrada.")
=======
	@NotNull
>>>>>>> refs/remotes/origin/validacao-eventos
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