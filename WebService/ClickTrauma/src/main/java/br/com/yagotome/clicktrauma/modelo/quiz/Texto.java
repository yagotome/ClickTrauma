package br.com.yagotome.clicktrauma.modelo.quiz;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "texto")
public class Texto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(name = "idioma", insertable = false, updatable = false)
	@CollectionTable(name = "texto_traducao", joinColumns = @JoinColumn(name = "texto_id"))
	@Column(name = "traducao")
	private Map<String, String> map = new HashMap<String, String>();

	public Texto() {
		super();
	}

	public Texto(final String language, final String text) {
		addText(language, text);
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void addText(String lang, String text) {
		getMap().put(lang, text);
	}

	public String getText(String code) {
		return map.get(code);
	}
}