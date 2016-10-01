package br.com.yagotome.clicktrauma.dao;

import java.util.List;

import br.com.yagotome.clicktrauma.modelo.quiz.Pergunta;

public interface PerguntaDao {
	void insere(Pergunta pergunta);
	void atualiza(Pergunta pergunta);
	void remove(Pergunta pergunta);
	Pergunta buscaPorId(Long id);
	List<Pergunta> lista();
}
