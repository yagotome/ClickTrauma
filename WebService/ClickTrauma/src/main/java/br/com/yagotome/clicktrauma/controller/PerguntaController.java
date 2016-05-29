package br.com.yagotome.clicktrauma.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.yagotome.clicktrauma.dao.PerguntaDao;
import br.com.yagotome.clicktrauma.dao.PerguntaDaoImpl;
import br.com.yagotome.clicktrauma.modelo.Idioma;
import br.com.yagotome.clicktrauma.modelo.Pergunta;
import br.com.yagotome.clicktrauma.modelo.Resposta;

@Controller
public class PerguntaController {
	private PerguntaDao dao;

	public PerguntaController() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ClickTrauma");
		EntityManager manager = factory.createEntityManager();
		dao = new PerguntaDaoImpl(manager);
	}
	
	@RequestMapping("/pergunta/cadastro")
	public String cadastraPergunta() {
		return "pergunta/cadastro";
	}

	@RequestMapping(value = "/pergunta/insere", method = RequestMethod.POST)
	public String inserePerguta(Pergunta pergunta, Model model, ServletRequest request,
			@RequestParam("textoPerguntaPt") String textoPerguntaPt,
			@RequestParam("textoPerguntaEn") String textoPerguntaEn,
			@RequestParam("textosRespostasPt[]") String[] textosRespostasPt,
			@RequestParam("textosRespostasEn[]") String[] textosRespostasEn) {
		Idioma portugues = new Idioma("pt");
		Idioma ingles = new Idioma("en");
		pergunta.setTexto(textoPerguntaPt, portugues);
		pergunta.setTexto(textoPerguntaEn, ingles);
		for (int i = 0; i < pergunta.getRespostas().size(); i++) {
			pergunta.getRespostas().get(i).setTexto(textosRespostasPt[i], portugues);
			pergunta.getRespostas().get(i).setTexto(textosRespostasEn[i], ingles);
		}
		int qtdResp = 5;
		if (pergunta.getRespostas().get(4).getTexto(portugues).isEmpty()
				&& pergunta.getRespostas().get(4).getTexto(ingles).isEmpty()) {
			pergunta.getRespostas().remove(4);
			qtdResp = 4;
		}
		pergunta.getRespostas().forEach(resp -> resp.setPergunta(pergunta));
		dao.insere(pergunta);
		try {
			String path = request.getServletContext().getRealPath("/")
					+ request.getServletContext().getInitParameter("ImagesPath").replace("/", "\\");

			if (pergunta.getImg() != null && !pergunta.getImg().isEmpty()) {
				String extension = extensao(pergunta.getImg().getOriginalFilename());
				String nome = "perguntas\\" + pergunta.getId() + extension;
				salvaArq(pergunta.getImg(), path + nome);
				pergunta.setImgUrl(path + nome);
			}

			for (int i = 0; i < qtdResp; i++) {
				if (pergunta.getRespostas().get(i).getImg() != null
						&& !pergunta.getRespostas().get(i).getImg().isEmpty()) {
					String extension = extensao(pergunta.getRespostas().get(i).getImg().getOriginalFilename());
					String nome = "respostas\\" + pergunta.getRespostas().get(i).getId() + extension;
					salvaArq(pergunta.getRespostas().get(i).getImg(), path + nome);
					pergunta.getRespostas().get(i).setImgUrl(path + nome);
				}
			}
			dao.atualiza(pergunta);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		model.addAttribute("inserido", true);
		return "redirect:cadastro";
	}

	private String extensao(String nomeArq) {
		String aux = nomeArq;
		System.out.println(aux);
		String revExtension = "";
		for (int i = aux.length() - 1; i >= 0 && aux.charAt(i) != '.'; i--) {
			revExtension += aux.charAt(i);
		}
		String extension = "";
		for (int i = revExtension.length() - 1; i >= 0; i--) {
			extension += revExtension.charAt(i);
		}
		return "." + extension;
	}

	private void salvaArq(MultipartFile arq, String nome) throws Exception {
		File arquivo = new File(nome);
		System.out.println(arquivo.getAbsolutePath());
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(arquivo));
		FileCopyUtils.copy(arq.getInputStream(), stream);
		stream.close();
	}

	@RequestMapping("/pergunta/lista")
	public String lista(Model model) {
		List<Pergunta> perguntas = dao.lista();
		model.addAttribute("perguntas", perguntas);
		return "pergunta/lista";
	}

	@RequestMapping("/pergunta/remove")
	public void remove(Long id, HttpServletResponse response) {
		Pergunta p = dao.buscaPorId(id);
		if (p.getImgUrl() != null) {
			File arq = new File(p.getImgUrl());
			if (!arq.delete())
				throw new RuntimeException("Erro ao excluir imagem da pergunta " + p.getId() + ".");
		}
		for (Resposta r : p.getRespostas()) {
			if (r.getImgUrl() != null) {
				File arq = new File(r.getImgUrl());
				if (!arq.delete())
					throw new RuntimeException("Erro ao excluir imagem da resposta " + r.getId() + ".");
			}
		}
		dao.remove(p);
		response.setStatus(200);
	}
}
