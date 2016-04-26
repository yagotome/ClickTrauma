package br.com.yagotome.clicktrauma.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import br.com.yagotome.clicktrauma.modelo.Pergunta;
import br.com.yagotome.clicktrauma.modelo.Resposta;

public class PerguntaDaoTest {
	private EntityManagerFactory factory;
	private EntityManager manager;
	private PerguntaDao dao;
	@Before
	public void init() {
		factory = Persistence
				.createEntityManagerFactory("ClickTrauma");
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
		assertEquals("Qual é a metade de 10?", dao.buscaPorId(1L).getTexto());
	}
	

	@Test
	public void testRemove() {
		Pergunta pergunta = new Pergunta();
		pergunta.setId(1L);
		dao.remove(pergunta);
	}
	
	@Test
	public void testInsere() {
		Pergunta pergunta = new Pergunta();
		pergunta.setTexto("Qual é a metade de 10?");
		List<Resposta> respostas = new ArrayList<>();
		respostas.add(new Resposta("20", false, pergunta));
		respostas.add(new Resposta("10", false, pergunta));
		respostas.add(new Resposta("2", false, pergunta));
		respostas.add(new Resposta("5", true, pergunta));
		respostas.add(new Resposta("15", false, pergunta));
		pergunta.setRespostas(respostas);
		dao.insere(pergunta);
	}

}
