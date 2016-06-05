package br.com.yagotome.clicktrauma.rest.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;

import br.com.yagotome.clicktrauma.dao.PerguntaDao;

@RestController
public class PerguntaRestController {
	@Inject
	private PerguntaDao dao;

	@RequestMapping(value = "/ws/perguntas", method = RequestMethod.GET)
	@ResponseBody
	public String lista() {
		return new GsonBuilder().create().toJson(dao.lista());
	}
}
