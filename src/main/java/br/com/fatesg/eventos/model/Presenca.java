package br.com.fatesg.eventos.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Presenca {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo = null;
	@ManyToOne
	private Evento evento = null;
	private String nome = null;
	private String sobrenome = null;
	private String email = null;
	private String telefone = null;
	private String cpf = null;
	private String status = null;
	private LocalDateTime dataDeCriacao = null;
	private LocalDateTime dataDeAtualizacao = null;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
