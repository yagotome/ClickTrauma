package br.com.yagotome.clicktrauma.modelo.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = true)
	private String cpf;
	@Column(nullable = true)
	private String uf;
	@Column(nullable = true)
	private String profissao;
	@Column(nullable = true)
	private String especialidade;
	@Column(nullable = true)
	private String email;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String senha;
	public Usuario() { }
	public Usuario(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}	
	public Usuario(String nome, String cpf, String uf, String profissao, String especialidade, String email,
			String login, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.uf = uf;
		this.profissao = profissao;
		this.especialidade = especialidade;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
