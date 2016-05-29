package br.com.yagotome.clicktrauma.dao;

import br.com.yagotome.clicktrauma.modelo.Usuario;

public interface UsuarioDao {
	void insere(Usuario usuario);
	void atualiza(Usuario usuario);
	Usuario buscaPorId(Long id);
}
