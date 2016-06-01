package br.com.yagotome.clicktrauma.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.yagotome.clicktrauma.modelo.Idioma;
import br.com.yagotome.clicktrauma.modelo.Pergunta;
import br.com.yagotome.clicktrauma.modelo.Resposta;

public class PerguntaDaoTest {
	private EntityManagerFactory factory;
	private EntityManager manager;
	private PerguntaDao dao;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("ClickTrauma");
		manager = factory.createEntityManager();
		dao = new PerguntaDaoImpl(manager);
	}

	@After
	public void destroy() {
		manager.close();
		factory.close();
	}

	@Test
	public void testBuscaPorId() {
		// assertEquals("Qual é a metade de 10?",
		// dao.buscaPorId(1L).getTexto());
	}

	@Test
	public void testRemove() {
		Pergunta pergunta = new Pergunta();
		pergunta.setId(1L);
		// dao.remove(pergunta);
	}

	@Test
	public void testInsere() {
		Idioma ingles = new Idioma();
		ingles.setCode("en");
		manager.persist(ingles);
		Idioma portugues = new Idioma();
		portugues.setCode("pt");
		manager.persist(portugues);

		Pergunta pergunta = new Pergunta();
		pergunta.setTexto("Qual é a metade de dez?", portugues);
		pergunta.setTexto("What is the half of ten?", ingles);
		List<Resposta> respostas = new ArrayList<>();
		respostas.add(new Resposta("Vinte", false, portugues).setTexto("Twenty", ingles));		
		respostas.add(new Resposta("Dez", false, portugues).setTexto("Ten", ingles));
		respostas.add(new Resposta("Dois", false, portugues).setTexto("Two", ingles));
		respostas.add(new Resposta("Cinco", true, portugues).setTexto("Five", ingles));
		respostas.add(new Resposta("Quinze", false, portugues).setTexto("Fifteen", ingles));
		pergunta.setRespostas(respostas);
		dao.insere(pergunta);
	}

}
