package br.com.fatesg.eventos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(generator = "categoria_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_seq", allocationSize = 1, initialValue = 1)
	@NotNull(message = "O idCategoria não pode ser nulo!")
	private Long idCategoria;

	@NotNull(message = "O campo nome não pode ser nulo!")
	private String nome;

	@NotNull(message = "O campo descricao não pode ser nulo!")
	private String descricao;

	@NotNull(message = "O campo icone não pode ser nulo!")
	private byte[] icone;

	private Date dataDeCadastro;

	private Date dataDeAtualizacao;

	public Categoria() {}

	public Categoria(Long idCategoria, String nome, String descricao, byte[] icone) {
		super();
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.descricao = descricao;
		this.icone = icone;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
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

	public byte[] getIcone() {
		return icone;
	}

	public void setIcone(byte[] icone) {
		this.icone = icone;
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