package br.com.yagotome.clicktrauma.dao;

import java.util.List;

import br.com.yagotome.clicktrauma.modelo.Pergunta;

public interface PerguntaDao {
	void insere(Pergunta pergunta);
	void altera(Pergunta pergunta);
	void remove(Pergunta pergunta);
	Pergunta buscaPorId(Long id);
	List<Pergunta> lista();
}
