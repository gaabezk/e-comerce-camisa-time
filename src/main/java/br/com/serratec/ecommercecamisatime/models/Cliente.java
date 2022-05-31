package br.com.serratec.ecommercecamisatime.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Column(name = "nome")
	private String nome;
	@NotNull
	@Column(name = "cpf", unique = true)
	private String cpf;
	@NotNull
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	@NotNull
	@Column(name = "telefone")
	private String telefone;
	@NotNull
	@Column(name = "email", unique = true)
	private String email;
	@NotNull
	@Column(name = "password")
	private String password;

//	@OneToMany(mappedBy = "cliente")
//	private List<Pedido> pedidos;
//
//	@OneToMany(mappedBy = "cliente")
//	private List<Endereco> enderecos;

	public Cliente() {
	}

	public Cliente(Integer id, @NotNull String nome, @CPF @NotNull String cpf, @NotNull LocalDate dataNascimento,
			@NotNull String telefone, @NotNull String email, @NotNull String password, List<Pedido> pedidos,
			List<Endereco> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.password = password;
//		this.pedidos = pedidos;
//		this.enderecos = enderecos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<Pedido> getPedido() {
//		return pedidos;
//	}
//
//	public void setPedido(List<Pedido> pedido) {
//		this.pedidos = pedido;
//	}
}
