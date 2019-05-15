package br.com.fatesg.eventos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
<<<<<<< HEAD
import javax.validation.constraints.NotNull;
=======
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
>>>>>>> refs/heads/DevCliente

@Entity
public class Patrocinador {

	@Id
	@GeneratedValue(generator = "patrocinador_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "patrocinador_seq", sequenceName = "patrocinador_seq", allocationSize = 1, initialValue = 1)
<<<<<<< HEAD
	@NotNull(message = "O idPatrocinador não pode ser nulo!")
=======
	@NotNull(message = "O identificador do patrocinador não pode ser cadastrado como nulo.")
>>>>>>> refs/heads/DevCliente
	private Long idPatrocinador;

	@ManyToOne
	private Evento evento;

<<<<<<< HEAD
	@NotNull(message = "O campo nome não pode ser nulo!")
=======
	@NotEmpty(message = "O campo nome não pode ser cadastrado em branco.")
	@Size(max = 50, message = "O campo nome deve ter no máximo 50 caracteres.")
>>>>>>> refs/heads/DevCliente
	private String nome;

<<<<<<< HEAD
	@NotNull(message = "O campo descricao não pode ser nulo!")
=======
	@NotEmpty(message = "O campo descrição não pode ser cadastrado em branco.")
	@Size(max = 50, message = "O campo descrição deve ter no máximo 50 caracteres.")
>>>>>>> refs/heads/DevCliente
	private String descricao;

<<<<<<< HEAD
	@NotNull(message = "O campo imagem não pode ser nulo!")
=======
>>>>>>> refs/heads/DevCliente
	private byte[] imagem;

	private Date dataDeCadastro;

	private Date dataDeAtualizacao;

<<<<<<< HEAD
	public Patrocinador() {}

	public Patrocinador(Long idPatrocinador, Evento evento, String nome, String descricao, byte[] imagem) {
		super();
		this.idPatrocinador = idPatrocinador;
		this.evento = evento;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
=======
	public Patrocinador(Long idPatrocinador, Evento evento, String nome, String descricao, byte[] imagem,
			Date dataDeCadastro, Date dataDeAtualizacao) {
		this.idPatrocinador = idPatrocinador;
		this.evento = evento;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.dataDeCadastro = dataDeCadastro;
		this.dataDeAtualizacao = dataDeAtualizacao;
	}

	public Patrocinador() {
>>>>>>> refs/heads/DevCliente
	}

	public Long getIdPatrocinador() {
		return idPatrocinador;
	}

	public void setIdPatrocinador(Long idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
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
<<<<<<< HEAD
=======
	
	
>>>>>>> refs/heads/DevCliente
}