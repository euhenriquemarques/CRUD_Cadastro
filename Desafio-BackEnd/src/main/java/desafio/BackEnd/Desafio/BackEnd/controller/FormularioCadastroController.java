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
public class FormularioCadastroController {

	@Autowired
	CadastroRepository cr;

	@RequestMapping(value = "/cadastroForm", method = RequestMethod.GET)
	public String form() {
		return "formulario/cadastroForm";
	}

	@RequestMapping(value = "/cadastroForm", method = RequestMethod.POST)
	public String form(@Valid Cadastro cadastro, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {

			attributes.addFlashAttribute("mensagem", "Verifique os Campos");
			return "redirect:/cadastroForm";
		}
		cr.save(cadastro);
		attributes.addFlashAttribute("mensagem", "Adicionado com Sucesso");
		return "redirect:/listar";
	}

}
