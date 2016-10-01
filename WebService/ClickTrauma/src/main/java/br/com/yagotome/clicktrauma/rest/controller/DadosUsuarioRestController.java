package br.com.yagotome.clicktrauma.rest.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.yagotome.clicktrauma.dao.DadosUsuarioDao;
import br.com.yagotome.clicktrauma.modelo.usuario.DadosUsuario;

@RestController
public class DadosUsuarioRestController {
	@Inject
	private DadosUsuarioDao dao;

	@RequestMapping(value = "/ws/dadosUsuario/salva", method = RequestMethod.POST)
	@ResponseBody
	public void salva(@RequestBody DadosUsuario dadosUsuario) {
		dao.insere(dadosUsuario);
	}
}
