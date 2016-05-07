package br.com.yagotome.clicktrauma.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@RequestMapping(method = RequestMethod.POST, value = "/pergunta/insereFile")
	public String handleFileUpload(@RequestParam("name") String name,
								   @RequestParam("file") MultipartFile file/*,
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
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(name)));
                FileCopyUtils.copy(file.getInputStream(), stream);
				stream.close();
				//redirectAttributes.addFlashAttribute("message",
					//	"You successfully uploaded " + name + "!");
			}
			catch (Exception e) {
				//redirectAttributes.addFlashAttribute("message",
					//	"You failed to upload " + name + " => " + e.getMessage());
			}
		}
		/*else {
			redirectAttributes.addFlashAttribute("message",
					"You failed to upload " + name + " because the file was empty");
		}*/
		
		return "redirect:/pergunta/insereFile";
	}
}
