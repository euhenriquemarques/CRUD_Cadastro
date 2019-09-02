package desafio.BackEnd.Desafio.BackEnd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import desafio.BackEnd.Desafio.BackEnd.modelos.Cadastro;
import desafio.BackEnd.Desafio.BackEnd.repository.CadastroRepository;

@Controller
public class IndexController {

	

	@Autowired
	CadastroRepository cr;
	
	//quando o usuario digitar a pagina / o spring vai identificr e retornar o index
	@RequestMapping("/")
	public String login() {
		return "index";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String form(String login, String pass,  RedirectAttributes attributes) {

		if (login.equals("teste@teste.com")  && pass.equals("123")) {

		
			return "redirect:/listar";
		}
	
		attributes.addFlashAttribute("mensagem", "Login/Senha Incorreto");
		return "redirect:/";
	}


	


	

}
