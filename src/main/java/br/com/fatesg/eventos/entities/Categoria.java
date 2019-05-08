package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCategoria;
	private String nome;
	private String descricao;
	private byte[] icone;
	
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

}