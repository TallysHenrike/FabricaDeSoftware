package br.com.fatesg.eventos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "O idAdministrador não pode ser nulo!")
	private Long idAdministrador;

	@NotNull(message = "O campo nome não pode ser nulo!")
	private String nome;

	@NotNull(message = "O campo usuario não pode ser nulo!")
	private String usuario;

	@NotNull(message = "O campo senha não pode ser nulo!")
	private String senha;

	//@NotNull(message = "O campo foto não pode ser nulo!")
	private byte[] foto;

	private Date dataDeCadastro;

	private Date dataDeAtualizacao;

	public Administrador() {}

	public Administrador(Long idAdministrador, String nome, String usuario, String senha, byte[] foto) {
		super();
		this.idAdministrador = idAdministrador;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
	}

	public Long getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Long idAdministrador) {
		this.idAdministrador = idAdministrador;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
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