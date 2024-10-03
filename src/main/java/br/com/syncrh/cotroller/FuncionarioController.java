package br.com.syncrh.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.syncrh.domain.entity.Funcionario;
import br.com.syncrh.domain.entity.Pessoa;
import br.com.syncrh.domain.entity.Usuario;
import br.com.syncrh.service.FuncionarioService;
import br.com.syncrh.service.PessoaService;

@Controller
public class FuncionarioController {

	public static final String FORM_CADASTRO_FUNCIONARIO = "cadastro_funcionario";

	private final FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/cadastro/funcionario")
	public String entrarCadastro(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		model.addAttribute("usuario", new Usuario());
		return FORM_CADASTRO_FUNCIONARIO;
	}

	@PostMapping("/cadastro/funcionario")
	public String cadastrar(@ModelAttribute Funcionario funcionario, @ModelAttribute Usuario usuario, RedirectAttributes redirectAtributes) {
		try {
			funcionarioService.cadastrar(funcionario, usuario);
			redirectAtributes.addFlashAttribute("msgSucesso", "Funcionario Cadastrado");
		} catch (Exception e) {
			redirectAtributes.addFlashAttribute("msgErro", "Houve uma falha");
		}
		return "redirect:/cadastro/funcionario";
	}
}
