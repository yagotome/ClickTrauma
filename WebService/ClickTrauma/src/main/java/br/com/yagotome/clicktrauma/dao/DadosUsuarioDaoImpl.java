package br.com.yagotome.clicktrauma.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.yagotome.clicktrauma.modelo.usuario.DadosUsuario;

@Named
public class DadosUsuarioDaoImpl implements DadosUsuarioDao {

	@Inject
	private EntityManager manager;
		
	@Override
	public void insere(DadosUsuario dadosUsuario) {
		manager.getTransaction().begin();
		manager.persist(dadosUsuario);
		manager.getTransaction().commit();
	}

	@Override
	public void atualiza(DadosUsuario dadosUsuario) {
		manager.getTransaction().begin();
		manager.merge(dadosUsuario);
		manager.getTransaction().commit();		
	}

	@Override
	public DadosUsuario buscaPorId(Long id) {			
		return manager.find(DadosUsuario.class, id);
	}
	
}
