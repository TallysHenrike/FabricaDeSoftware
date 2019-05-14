package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Login {
	
	@Id
	@GeneratedValue(generator = "login_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "login_seq", sequenceName = "login_seq", allocationSize = 1, initialValue = 1)
	@NotNull(message= "Identificador do usuário não pode ser cadastrado como nulo.")
	private String usuario;

	@Size(min = 1, max = 15, message= "O campo telefone deve ter no máximo 15 caracteres.")
	@NotEmpty(message= "Senha inválida.")
	private String senha;
	
	public Login(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Login() {}

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
	
	

}
