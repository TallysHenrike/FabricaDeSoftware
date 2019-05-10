package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Colaborador {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotEmpty(message= "identificador de colaborador não pode ser nulo.")
	private Long idColaborador;
	
	@ManyToOne
	private Evento evento;
	
	@Size(min=2, max= 50)
	@NotEmpty(message= "o nome do colaborador não pode estar vazio.")
	private String nome;
	
	@Size(min=2, max=50)
	@NotEmpty(message= "a descrição do colaborador não pode estar vazia.")
	private String descricao;
	
	@Size(min=1, max=5)
	@NotEmpty(message= "Ao menos uma imagem do colaborador deve ser cadastrada.")
	private byte[] imagem;

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