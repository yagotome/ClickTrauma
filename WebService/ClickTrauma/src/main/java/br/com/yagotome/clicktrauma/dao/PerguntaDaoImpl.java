package br.com.yagotome.clicktrauma.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.yagotome.clicktrauma.modelo.Pergunta;

public class PerguntaDaoImpl implements PerguntaDao {
	private EntityManager manager;
	
	public PerguntaDaoImpl(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void insere(Pergunta pergunta) {
		manager.getTransaction().begin();
		manager.persist(pergunta);
		manager.getTransaction().commit();
		
	}

	@Override
	public void altera(Pergunta pergunta) {
		manager.getTransaction().begin();
		manager.merge(pergunta);
		manager.getTransaction().commit();	
	}

	@Override
	public void remove(Pergunta pergunta) {
		manager.getTransaction().begin();		
		manager.remove(buscaPorId(pergunta.getId()));
		manager.getTransaction().commit();
	}

	@Override
	public Pergunta buscaPorId(Long id) {
		return manager.find(Pergunta.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pergunta> lista() {
		return manager.createQuery("select p from Pergunta p").getResultList();
	}

}
