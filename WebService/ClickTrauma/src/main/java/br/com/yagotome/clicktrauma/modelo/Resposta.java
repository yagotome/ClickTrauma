package br.com.yagotome.clicktrauma.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Resposta {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "texto_id")
	private Texto texto;
	private boolean correta;
	private String imgUrl;
	@Transient
	private MultipartFile img;

	private Texto texto() {
		return texto != null ? texto : (texto = new Texto());
	}

	public Resposta() {
	}

	public Resposta(String texto, boolean correta, Idioma idioma) {
		setTexto(texto, idioma);
		this.correta = correta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Resposta setTexto(final String texto, final Idioma idioma) {
		texto().addText(idioma.getCode(), texto);
		return this;
	}

	public Texto getTexto() {
		return texto();
	}
	
	public String getTexto(final Idioma idioma) {
		return texto().getText(idioma.getCode());
	}

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean correta) {
		this.correta = correta;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}
}
