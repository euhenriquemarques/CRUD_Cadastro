package desafio.BackEnd.Desafio.BackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import desafio.BackEnd.Desafio.BackEnd.modelos.Cadastro;
import desafio.BackEnd.Desafio.BackEnd.repository.CadastroRepository;

@Controller
public class ListarController {

	
	@Autowired
	CadastroRepository cr;
	
	//quando o usuario digitar a pagina / o spring vai identificr e retornar o index
	@RequestMapping("formulario/listar")
	public String Listar() {
		return "formulario/listar";
		}
	
	
	
	//função abaixo busca a lista que tem disponivel no banco de dados
	@RequestMapping("/listar")
	public ModelAndView listarCadastro() {
		ModelAndView mv = new ModelAndView("formulario/listar");
		Iterable<Cadastro> cadastro = cr.findAll();
		mv.addObject("cadastros", cadastro);
		return mv;
	}
	
	@RequestMapping("/deletarCadastro")
	public String deletarCadastro(long id) {
		Cadastro cadastro = cr.findById(id);
		cr.delete(cadastro);
		return "redirect:/listar";
	}

}
