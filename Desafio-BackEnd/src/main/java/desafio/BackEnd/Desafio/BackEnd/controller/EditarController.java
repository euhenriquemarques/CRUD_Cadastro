package desafio.BackEnd.Desafio.BackEnd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import desafio.BackEnd.Desafio.BackEnd.modelos.Cadastro;
import desafio.BackEnd.Desafio.BackEnd.repository.CadastroRepository;


@Controller
public class EditarController {
	
	@Autowired
	CadastroRepository cr;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView editarCadastro(@PathVariable("id") long id) {
	    Cadastro cadastro = cr.findById(id);	
		ModelAndView mv = new ModelAndView("formulario/editarCadastro");
		mv.addObject("cadastros", cadastro);
		return mv;
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String salvarEdicao(@PathVariable("id") long id, @Valid Cadastro cadastro, @Valid String nome, @Valid String cpf, 
			@Valid String email, @Valid String senha, BindingResult result, RedirectAttributes attributes) {
		
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os Campos");
			return "redirect:/{id}";
		}
		cadastro = cr.findById(id);
		cadastro.setCpf(cpf);
		cadastro.setNome(nome);
		cadastro.setEmail(email);
		cadastro.setSenha(senha);
		cr.save(cadastro);
		attributes.addFlashAttribute("mensagem", "Adicionado com Sucesso");
		return "redirect:/listar";
		
	}
}
