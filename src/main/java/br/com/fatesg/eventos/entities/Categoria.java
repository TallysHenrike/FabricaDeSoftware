package br.com.fatesg.eventos.entities;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo = null;
	private String nome = null;
	private String descricao = null;
	private String icone = null;
	private LocalDateTime dataDeCriacao = null;
	private LocalDateTime dataDeAtualizacao = null;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;
	}
	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}
	public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}
	public LocalDateTime getDataDeAtualizacao() {
		return dataDeAtualizacao;
	}
	public void setDataDeAtualizacao(LocalDateTime dataDeAtualizacao) {
		this.dataDeAtualizacao = dataDeAtualizacao;
	}
	
}