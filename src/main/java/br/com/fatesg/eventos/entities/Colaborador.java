package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

@Entity
public class Colaborador {
	
	@Id
	@GeneratedValue(generator="colaborador_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="colaborador_seq", sequenceName="colaborador_seq", allocationSize=1, initialValue=1)
	@NotEmpty(message = "identificador de colaborador não pode ser nulo.")
	private Long idColaborador;

	@ManyToOne
	private Evento evento;

	@Size(min = 1, max = 50, message= "O campo nome deve ter no máximo 50 caracteres.")
	@NotEmpty(message = "O nome do colaborador não pode estar vazio.")
	private String nome;

	@Size(min = 1, max = 50, message= "O campo descrição deve ter no máximo 50 caracteres.")
	@NotEmpty(message = "A descrição do colaborador não pode estar vazia.")
	private String descricao;

	@Size(min = 1, max = 5, message= "A quantidade de imagens cadastradas não pode exceder a 5.")
	@NotEmpty(message = "Ao menos uma imagem do colaborador deve ser cadastrada.")
	private byte[] imagem;

	public Colaborador(Long idColaborador, Evento evento, String nome, String descricao, byte[] imagem) {
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