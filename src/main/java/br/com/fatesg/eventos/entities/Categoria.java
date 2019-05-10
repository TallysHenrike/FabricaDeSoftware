package br.com.fatesg.eventos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Categoria {

	@NotEmpty(message= "Código de categoria não pode ser cadastrado como nulo.")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCategoria;
	@NotEmpty(message= "Nome da categoria é obrigatório.")
	private String nome;
	@NotEmpty(message= "Descrição da categoria é obrigatória.")
	private String descricao;
	@NotEmpty(message= "Ícone da categoria é obrigatório.")
	private byte[] icone;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
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

	public byte[] getIcone() {
		return icone;
	}

	public void setIcone(byte[] icone) {
		this.icone = icone;
	}

}