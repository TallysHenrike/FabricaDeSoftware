package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Patrocinador {
	
	@Id
	@GeneratedValue(generator="patrocinador_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="patrocinador_seq", sequenceName="patrocinador_seq", allocationSize=1, initialValue=1)
	@NotEmpty(message= "O identificador do patrocinador não pode ser cadastrado como nulo.")
	private Long idPatrocinador;
	
	@ManyToOne
	private Evento evento;
	
	@NotEmpty(message= "O campo nome não pode ser cadastrado em branco.")
	@Size(min = 1, max = 50, message= "O campo nome deve ter no máximo 50 caracteres.")
	private String nome;
	
	@NotEmpty(message= "O campo descrição não pode ser cadastrado em branco.")
	@Size(min = 1, max = 50, message= "O campo descrição deve ter no máximo 50 caracteres.")
	private String descricao;
	
	@NotEmpty(message= "Deve ser cadastrado ao menos uma imagem.")
	@Size(min = 1, max = 5, message= "A quantidade de imagens cadastradas não pode exceder a 5.")
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