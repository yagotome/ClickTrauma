package br.com.yagotome.clicktrauma.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
	public EntityManager createEntityManager() {
		return Persistence.createEntityManagerFactory("ClickTrauma").createEntityManager();
	}
}
