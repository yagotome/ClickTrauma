package br.com.yagotome.clicktrauma.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.yagotome.clicktrauma.dao.PerguntaDao;
import br.com.yagotome.clicktrauma.dao.PerguntaDaoImpl;
import br.com.yagotome.clicktrauma.modelo.Pergunta;
import br.com.yagotome.clicktrauma.modelo.PerguntaCadastro;
import br.com.yagotome.clicktrauma.modelo.Resposta;

@Controller
public class CadastroPerguntaController {
	private PerguntaDao dao;
	public CadastroPerguntaController() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ClickTrauma");
		EntityManager manager = factory.createEntityManager();
		dao = new PerguntaDaoImpl(manager);
	}
	@RequestMapping("/pergunta/cadastro")
	public String cadastraPergunta() {
		return "pergunta/cadastro";
	}
	@RequestMapping("/pergunta/insere")
	public String inserePerguta(PerguntaCadastro form) {
		Pergunta pergunta = new Pergunta();
		pergunta.setTexto(form.getPergunta());
		List<Resposta> respostas = new ArrayList<>();
		respostas.add(new Resposta(form.getResp1(), form.isCerta1(), pergunta));
		respostas.add(new Resposta(form.getResp2(), form.isCerta2(), pergunta));
		respostas.add(new Resposta(form.getResp3(), form.isCerta3(), pergunta));
		respostas.add(new Resposta(form.getResp4(), form.isCerta4(), pergunta));
		respostas.add(new Resposta(form.getResp5(), form.isCerta5(), pergunta));
		pergunta.setRespostas(respostas);
		dao.insere(pergunta);
		return "ok";
	}
}
