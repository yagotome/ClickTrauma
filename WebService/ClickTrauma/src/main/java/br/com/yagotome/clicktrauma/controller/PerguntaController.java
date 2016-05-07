package br.com.yagotome.clicktrauma.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
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
	@RequestMapping("/pergunta/insere")
	public String inserePerguta(Pergunta pergunta, Model model) {
		if (pergunta.getRespostas().get(4).getTexto().isEmpty())
			pergunta.getRespostas().remove(4);
		for (Resposta resposta : pergunta.getRespostas()) {
			resposta.setPergunta(pergunta);			
		}
		dao.insere(pergunta);
		model.addAttribute("inserido", true);
		return "redirect:cadastro";
	}
	@RequestMapping("/pergunta/lista")
	public String lista(Model model) {
		List<Pergunta> perguntas = dao.lista();
		model.addAttribute("perguntas", perguntas);
		return "pergunta/lista";
	}
	
	@RequestMapping("/pergunta/remove")
	public void remove(Long id, HttpServletResponse response) {
		Pergunta p = new Pergunta();
		p.setId(id);
		dao.remove(p);
		response.setStatus(200);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/pergunta/insereFile")
	public String abreFileUpload() {
		return "pergunta/fileUpload";
	}
	@RequestMapping(value = "/pergunta/insereFile", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("name") String name,
								   @RequestParam("file") MultipartFile file,
								   ServletRequest request/*,
								   RedirectAttributes redirectAttributes*/) {
		if (name.contains("/")) {
			//redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
			return "redirect:/pergunta/insereFile";
		}
		
		if (name.contains("/")) {
			//redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
			return "redirect:/pergunta/insereFile";
		}
		if (!file.isEmpty()) {
			try {
				String path = request.getServletContext().getRealPath("/") 
						+ request.getServletContext().getInitParameter("ImagesPath");
				File arquivo = new File(path + name);
				System.out.println(arquivo.getAbsolutePath());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(arquivo));
                FileCopyUtils.copy(file.getInputStream(), stream);
				stream.close();	
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return "redirect:/pergunta/insereFile";
	}
}
