package br.com.fatesg.eventos.entities;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo = null;
	private Categoria categoria = null;
	private String titulo = null;
	private String descricao = null;
	private String apresentaao = null;
	private String icone = null;
	private Integer precoUnitario = null;
	private Integer quantidadeDeVagas = null;
	private String urlDoGoogleMaps = null;
	private LocalDateTime dataDeCriacao = null;
	private LocalDateTime dataDeAtualizacao = null;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getApresentaao() {
		return apresentaao;
	}
	public void setApresentaao(String apresentaao) {
		this.apresentaao = apresentaao;
	}
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;
	}
	public Integer getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(Integer precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public Integer getQuantidadeDeVagas() {
		return quantidadeDeVagas;
	}
	public void setQuantidadeDeVagas(Integer quantidadeDeVagas) {
		this.quantidadeDeVagas = quantidadeDeVagas;
	}
	public String getUrlDoGoogleMaps() {
		return urlDoGoogleMaps;
	}
	public void setUrlDoGoogleMaps(String urlDoGoogleMaps) {
		this.urlDoGoogleMaps = urlDoGoogleMaps;
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