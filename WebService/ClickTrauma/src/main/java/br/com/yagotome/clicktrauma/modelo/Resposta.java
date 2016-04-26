package br.com.yagotome.clicktrauma.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resposta {
	@Id
	@GeneratedValue
	private Long id;
	private String texto;	
	private boolean correta;
	@ManyToOne
	private Pergunta pergunta;
	
	public Resposta() { }
	
	public Resposta(String texto, boolean correta, Pergunta pergunta) {
		this.texto = texto;
		this.correta = correta;
		this.pergunta = pergunta;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isCorreta() {
		return correta;
	}
	public void setCorreta(boolean correta) {
		this.correta = correta;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
}
