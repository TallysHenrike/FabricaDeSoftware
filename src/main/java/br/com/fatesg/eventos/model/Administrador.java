package br.com.fatesg.eventos.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo = null;
	private String nome = null;
	private String usuario = null;
	private String senha = null;
	private byte[] imagem = null;
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
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