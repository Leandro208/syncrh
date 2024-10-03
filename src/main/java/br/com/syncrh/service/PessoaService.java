package br.com.syncrh.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.syncrh.domain.entity.Pessoa;
import br.com.syncrh.domain.entity.Usuario;
import br.com.syncrh.repository.PessoaRepository;

@Service
public class PessoaService {

	private final PessoaRepository pessoaRepository;
	private final UsuarioService usuarioService;
	
	public PessoaService(PessoaRepository pessoaRepository,
						 UsuarioService usuarioService) {
		this.pessoaRepository = pessoaRepository;
		this.usuarioService = usuarioService;
	}
	
	@Transactional
	public void cadastrar(Pessoa pessoa, Usuario usuario) {
		pessoa.setDataCadastro(LocalDateTime.now());
		pessoaRepository.save(pessoa);
		usuario.setPessoa(pessoa);
		usuarioService.cadastrar(usuario);
	}
}
