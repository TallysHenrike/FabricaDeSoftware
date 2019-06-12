package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(generator = "cliente_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1, initialValue = 1)
	@NotNull(message= "Identificador do cliente não pode ser cadastrado como nulo.")
	private long idCliente;
	
	@Size(max = 20, message= "O campo telefone deve ter no máximo 20 caracteres.")
	@NotEmpty(message= "Um telefone deve ser cadastrado.")
	private String telefone;
	
	@Size(max = 50, message= "O campo endereço deve ter no máximo 50 caracteres.")
	@NotEmpty(message= "Um endereço deve ser cadastrado.")
	private String endereco;
	
	@Size(max = 14, message= "O campo CPF deve ter no máximo 14 caracteres.")
	@NotEmpty(message= "Um CPF deve ser cadastrado.")
	@CPF(message= "CPF inválido.")
	private String cpf;
	
	@Size(max = 50, message= "O campo nome deve ter no máximo 50 caracteres.")
	@NotEmpty(message= "Um nome deve ser cadastrado.")
	private String nome;
	
	@Size(max = 30, message= "O campo email deve ter no máximo 30 caracteres.")
	@NotEmpty(message= "Um email deve ser cadastrado.")
	@Email(message= "Um email válido deve ser cadastrado.")
	private String email;
	
	@NotEmpty(message= "Um login deve ser cadastrado.")
	@OneToOne
	private Login login;

	public Cliente(long idCliente, String telefone, String endereco, String cpf, String nome, String email,Login login) {
		this.idCliente = idCliente;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.login = login;
	}

	public Cliente() {}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdCliente() {
		return idCliente;
	}
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
