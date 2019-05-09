package br.com.fatesg.eventos.entities;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Evento {

	@Id
	@GeneratedValue(generator = "evento_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq", allocationSize = 1, initialValue = 1)
	@NotEmpty(message = "Campo idEvento não pode ser vazio!")
	private Long idEvento;
	@ManyToOne
	@NotEmpty(message = "Campo Administrador não pode ser vazio!")
	private Administrador administrador;
	@ManyToOne
	@NotEmpty(message = "Campo Categoria não pode ser vazio!")
	private Categoria categoria;
	@NotEmpty(message = "Campo Título não pode ser vazio!")
	private String titulo;
	@NotEmpty(message = "Campo Descrição não pode ser vazio!")
	private String descricao;
	@NotEmpty(message = "Campo Corpo não pode ser vazio!")
	private String corpo;
	private byte[] imagemPrincipal;
	@NotEmpty(message = "Campo Data de Início não pode ser vazio!")
	private Date dataDeInicio;
	@NotEmpty(message = "Campo Quantidade de Vagas não pode ser vazio!")
	private int quantidadeDeVagas;
	@URL(message = "URL inválida!")
	@URL(host = "google.com")
	private String urlDoGoogleMaps;
	@CreatedDate
	private Date dataDeCadastro;
	@LastModifiedDate
	private Date dataDeAtualizacao;

	public Evento() {}


	public Evento(Long idEvento, Administrador administrador, Categoria categoria, String titulo, String descricao,
	              String corpo, byte[] imagemPrincipal, Date dataDeInicio, int quantidadeDeVagas, String urlDoGoogleMaps,
	              Date dataDeCadastro, Date dataDeAtualizacao) {
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
		this.dataDeCadastro = dataDeCadastro;
		this.dataDeAtualizacao = dataDeAtualizacao;
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