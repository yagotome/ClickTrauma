package br.com.yagotome.clicktrauma.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.yagotome.clicktrauma.modelo.usuario.Usuario;

import static org.junit.Assert.*;

public class UsuarioDaoTest {
	private EntityManagerFactory factory;
	private EntityManager manager;
	private UsuarioDao dao;
	@Before
	public void init() {
		factory = Persistence
				.createEntityManagerFactory("ClickTrauma");
		manager = factory.createEntityManager();
		dao = new UsuarioDaoImpl(manager);
	}
	
	@After
	public void destroy() {
		manager.close();
		factory.close();
	}
	

	@Test
	public void testGetById() {
		Usuario usuario = dao.buscaPorId(3L);
		assertEquals("Yago Tom�", usuario.getNome());
		assertEquals("yagotome", usuario.getLogin());
		assertEquals("1234567", usuario.getSenha());
		assertEquals("yagotome@gmail.com", usuario.getEmail());
		assertEquals("RJ", usuario.getUf());
		assertNull(usuario.getCpf());
		assertNull(usuario.getEspecialidade());
		assertNull(usuario.getProfissao());
	}
	

	@Test
	public void testAtualiza() {
		Usuario usuario = dao.buscaPorId(3L);
		usuario.setSenha("1234567");
		dao.atualiza(usuario);
	}
	
	@Test
	public void testInsere() {
		Usuario usuario = new Usuario("Yago Tom�", "yagotome", "1234");
		usuario.setEmail("yagotome@gmail.com");
		usuario.setUf("RJ");
		dao.insere(usuario);
	}

}
