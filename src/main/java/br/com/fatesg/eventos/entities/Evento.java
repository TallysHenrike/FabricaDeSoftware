package br.com.fatesg.eventos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEvento;
	@ManyToOne
	private Administrador administrador;
	@ManyToOne
	private Categoria categoria;
	private String titulo;
	private String descricao;
	private String corpo;
	private byte[] imagemPrincipal;
	private Date dataDeInicio;
	private int quantidadeDeVagas;
	private String urlDoGoogleMaps;
	
	public Evento() {}

	public Evento(Long idEvento, Administrador administrador, Categoria categoria, String titulo, String descricao,	String corpo, byte[] imagemPrincipal, Date dataDeInicio, int quantidadeDeVagas, String urlDoGoogleMaps) {
		super();
		this.idEvento = idEvento;
		this.administrador = administrador;
		this.categoria = categoria;
		this.titulo = titulo;
		this.descricao = descricao;
		this.corpo = corpo;
		this.imagemPrincipal = imagemPrincipal;
		this.dataDeInicio = dataDeInicio;
		this.quantidadeDeVagas = quantidadeDeVagas;
		this.urlDoGoogleMaps = urlDoGoogleMaps;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
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

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public byte[] getImagemPrincipal() {
		return imagemPrincipal;
	}

	public void setImagemPrincipal(byte[] imagemPrincipal) {
		this.imagemPrincipal = imagemPrincipal;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public int getQuantidadeDeVagas() {
		return quantidadeDeVagas;
	}

	public void setQuantidadeDeVagas(int quantidadeDeVagas) {
		this.quantidadeDeVagas = quantidadeDeVagas;
	}

	public String getUrlDoGoogleMaps() {
		return urlDoGoogleMaps;
	}

	public void setUrlDoGoogleMaps(String urlDoGoogleMaps) {
		this.urlDoGoogleMaps = urlDoGoogleMaps;
	}
}