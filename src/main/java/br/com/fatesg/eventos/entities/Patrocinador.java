package br.com.fatesg.eventos.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Patrocinador {

	@Id
	@GeneratedValue(generator = "patrocinador_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "patrocinador_seq", sequenceName = "patrocinador_seq", allocationSize = 1, initialValue = 1)
	@NotNull(message = "O identificador do patrocinador não pode ser cadastrado como nulo.")
	private Long idPatrocinador;

	@ManyToOne
	private Evento evento;

	@NotEmpty(message = "O campo nome não pode ser cadastrado em branco.")
	@Size(min = 1, max = 50, message = "O campo nome deve ter no máximo 50 caracteres.")
	private String nome;

	@NotEmpty(message = "O campo descrição não pode ser cadastrado em branco.")
	@Size(min = 1, max = 50, message = "O campo descrição deve ter no máximo 50 caracteres.")
	private String descricao;

	@NotNull(message = "O campo imagem não pode ser nulo!")
	private byte[] imagem;

	private Date dataDeCadastro;

	private Date dataDeAtualizacao;

	public Patrocinador(Long idPatrocinador, Evento evento, String nome, String descricao, byte[] imagem,
			Date dataDeCadastro, Date dataDeAtualizacao) {
		super();
		this.idPatrocinador = idPatrocinador;
		this.evento = evento;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.dataDeCadastro = dataDeCadastro;
		this.dataDeAtualizacao = dataDeAtualizacao;
	}

	public Patrocinador() {
	}

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

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public Date getDataDeAtualizacao() {
		return dataDeAtualizacao;
	}

	public void setDataDeAtualizacao(Date dataDeAtualizacao) {
		this.dataDeAtualizacao = dataDeAtualizacao;
	}
}