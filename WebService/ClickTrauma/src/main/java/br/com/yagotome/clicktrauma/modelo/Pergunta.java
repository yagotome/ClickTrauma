package br.com.yagotome.clicktrauma.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Pergunta {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "texto_id")
	private Texto texto;
	private String imgUrl;
	@Transient
	private MultipartFile img;

	private Texto texto() {
		return texto != null ? texto : (texto = new Texto());
	}
	
	@OneToMany
	private List<Resposta> respostas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTexto(final String texto, final Idioma idioma) {
		texto().addText(idioma.getCode(), texto);
	}

	public Texto getTexto() {
		return texto();
	}
	
	public String getTexto(final Idioma language) {
		return texto().getText(language.getCode());
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
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
