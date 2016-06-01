package br.com.yagotome.clicktrauma.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;

import br.com.yagotome.clicktrauma.dao.PerguntaDao;
import br.com.yagotome.clicktrauma.dao.PerguntaDaoImpl;

@RestController
public class PerguntaRestController {
	private PerguntaDao dao;

	public PerguntaRestController() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ClickTrauma");
		EntityManager manager = factory.createEntityManager();
		dao = new PerguntaDaoImpl(manager);
	}

	@RequestMapping(value = "/ws/perguntas", method = RequestMethod.GET)
	@ResponseBody
	public String lista() {
		return new GsonBuilder().create().toJson(dao.lista());
	}
}
