package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;


@Entity
public class Patrocinador {

	@NotEmpty
	@Id
	@GeneratedValue(generator="patrocinador_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="patrocinador_seq", sequenceName="patrocinador_seq", allocationSize=1, initialValue=1)
	private Long idPatrocinador;
	
	@NotEmpty
	@ManyToOne
	private Evento evento;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String descricao;
	
	@NotEmpty
	private byte[] imagem;

	public Long getIdPatrocinador() {
		return idPatrocinador;
	}

	public void setIdPatrocinador(Long idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
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