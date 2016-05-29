package br.com.yagotome.clicktrauma.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Idioma {
	@Id
	private String codigo;

	public Idioma() {
	}

	public Idioma(String codigo) {
		this.codigo = codigo;
	}

	public String getCode() {
		return codigo;
	}

	public void setCode(String code) {
		this.codigo = code;
	}
}
