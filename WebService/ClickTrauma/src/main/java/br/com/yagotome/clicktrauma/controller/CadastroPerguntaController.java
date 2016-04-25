package br.com.yagotome.clicktrauma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.yagotome.clicktrauma.modelo.Pergunta;

@Controller
public class CadastroPerguntaController {
	@RequestMapping("/pergunta/cadastro")
	public String cadastraPergunta() {
		return "pergunta/cadastro";
	}
	@RequestMapping("/pergunta/insere")
	public String inserePerguta(Pergunta pergunta) {
		return "pergunta/insere";
	}
}
