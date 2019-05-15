package br.com.fatesg.eventos.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
<<<<<<< HEAD
=======
import javax.validation.constraints.Min;
>>>>>>> refs/heads/DevCliente
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Evento {

	@Id
	@GeneratedValue(generator = "evento_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq", allocationSize = 1, initialValue = 1)
	@NotNull(message = "O id do evento não pode ser null!")
	private Long idEvento;
<<<<<<< HEAD
	
=======

>>>>>>> refs/heads/DevCliente
	@ManyToOne
	private Administrador administrador;
<<<<<<< HEAD
	
=======

>>>>>>> refs/heads/DevCliente
	@ManyToOne
	private Categoria categoria;
<<<<<<< HEAD
	
	@NotEmpty(message = "Campo Título não pode ser vazio!")
=======

	@Size(min = 3, message = "A quantidade minima é de 3 caracteres.")
	@Size(max=50, message = "A quantidade máxima é de 50 caracteres.")
	@NotEmpty(message = "O campo Título não pode ser vazio!")
>>>>>>> refs/heads/DevCliente
	private String titulo;
<<<<<<< HEAD
	
	@NotEmpty(message = "Campo Descrição não pode ser vazio!")
=======

	@Size(min = 2, message = "A quantidade minima é de 2 caracteres.")
	@Size(max=250, message = "A quantidade máxima é de 250 caracteres.")
	@NotEmpty(message = "O campo Descrição não pode ser vazio!")
>>>>>>> refs/heads/DevCliente
	private String descricao;
<<<<<<< HEAD
	
	@NotEmpty(message = "Campo Corpo não pode ser vazio!")
=======

	@Size(min = 2, message = "A quantidade minima é de 2 caracteres.")
	@Size(max=2000, message = "A quantidade máxima é de 2000 caracteres.")
	@NotEmpty(message = "O campo Corpo não pode ser vazio!")
>>>>>>> refs/heads/DevCliente
	private String corpo;
<<<<<<< HEAD
	
=======

>>>>>>> refs/heads/DevCliente
	private byte[] imagemPrincipal;
<<<<<<< HEAD
	
	@NotEmpty(message = "Campo Data de Início não pode ser vazio!")
=======

	//@NotEmpty(message = "O campo Data de Início não pode ser vazio!")
>>>>>>> refs/heads/DevCliente
	private Date dataDeInicio;
<<<<<<< HEAD
	
	@NotEmpty(message = "Campo Quantidade de Vagas não pode ser vazio!")
=======

	@Min(value = 1, message = "O campo Quantidade de Vagas não pode ser 0!")
>>>>>>> refs/heads/DevCliente
	private int quantidadeDeVagas;
<<<<<<< HEAD
	
	@URL(message = "URL inválida!")
	@URL(host = "google.com")
=======

	/*@URL(message = "URL inválida!")
	@URL(host = "google.com/maps")*/
>>>>>>> refs/heads/DevCliente
	private String urlDoGoogleMaps;
<<<<<<< HEAD
	
=======

>>>>>>> refs/heads/DevCliente
	@CreatedDate
	private Date dataDeCadastro;
<<<<<<< HEAD
	
=======

>>>>>>> refs/heads/DevCliente
	@LastModifiedDate
	private Date dataDeAtualizacao;

	public Evento() {}

	public Evento(
			Long idEvento,
			Administrador administrador,
			Categoria categoria,
			String titulo,
			String descricao,
			String corpo,
			byte[] imagemPrincipal,
			Date dataDeInicio,
			int quantidadeDeVagas,
			String urlDoGoogleMaps,
<<<<<<< HEAD
			Date dataDeCadastro,
			Date dataDeAtualizacao
=======
			Date dataDeCadastro, Date dataDeAtualizacao
>>>>>>> refs/heads/DevCliente
	) {
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

	public Evento(
			Long idEvento,
			Administrador administrador,
			Categoria categoria,
			String titulo,
			String descricao,
			String corpo,
			int quantidadeDeVagas,
			String urlDoGoogleMaps
	) {
		this.idEvento = idEvento;
		this.administrador = administrador;
		this.categoria = categoria;
		this.titulo = titulo;
		this.descricao = descricao;
		this.corpo = corpo;
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