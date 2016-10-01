package br.com.yagotome.clicktrauma.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.yagotome.clicktrauma.modelo.quiz.Idioma;
import br.com.yagotome.clicktrauma.modelo.quiz.Pergunta;

@Named
public class PerguntaDaoImpl implements PerguntaDao {
	@Inject
	private EntityManager manager;
	
	@Override
	public void insere(Pergunta pergunta) {
		manager.getTransaction().begin();
		pergunta.getTexto().getMap().entrySet()
				.stream()
				.map(entry -> entry.getKey())
				.filter(key -> manager.find(Idioma.class, key) == null)
				.distinct()
				.forEach(key -> manager.persist(new Idioma(key)));		
		manager.persist(pergunta);
		pergunta.getRespostas().forEach(manager::persist);
		manager.getTransaction().commit();		
	}

	@Override
	public void remove(Pergunta pergunta) {
		manager.getTransaction().begin();
		pergunta = buscaPorId(pergunta.getId());
		pergunta.getRespostas().forEach(manager::remove);
		manager.remove(pergunta);
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

	@Override
	public void atualiza(Pergunta pergunta) {
		manager.getTransaction().begin();
		manager.merge(pergunta);
		pergunta.getRespostas().forEach(manager::merge);
		manager.getTransaction().commit();
	}

}
