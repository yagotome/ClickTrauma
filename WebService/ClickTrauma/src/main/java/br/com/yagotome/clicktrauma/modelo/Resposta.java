package br.com.yagotome.clicktrauma.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Resposta {
	@Id
	@GeneratedValue
	private Long id;
	private String texto;	
	private boolean correta;
	private String imgUrl;
	@Transient private MultipartFile img;
	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
