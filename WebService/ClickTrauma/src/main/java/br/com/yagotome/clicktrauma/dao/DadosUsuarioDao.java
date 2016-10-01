package br.com.yagotome.clicktrauma.dao;

import br.com.yagotome.clicktrauma.modelo.usuario.DadosUsuario;

public interface DadosUsuarioDao {
	void insere(DadosUsuario dadosUsuario);
	void atualiza(DadosUsuario dadosUsuario);
	DadosUsuario buscaPorId(Long id);
}
