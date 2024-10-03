package br.com.syncrh.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.syncrh.domain.dto.CadastroFuncionarioDTO;
import br.com.syncrh.domain.entity.Funcionario;
import br.com.syncrh.domain.entity.Usuario;
import br.com.syncrh.domain.enums.RegimeTrabalho;
import br.com.syncrh.domain.enums.Situacao;
import br.com.syncrh.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	private final PessoaService pessoaService;
	
	public FuncionarioService(FuncionarioRepository funcionarioRepository, PessoaService pessoaService) {
		this.funcionarioRepository = funcionarioRepository;
		this.pessoaService = pessoaService;
	}

	@Transactional
	public void cadastrar(CadastroFuncionarioDTO funcionarioCadastro) {
		pessoaService.cadastrar(funcionarioCadastro.getPessoa(), funcionarioCadastro.getUsuario());
		
		funcionarioCadastro.getFuncionario().setDataCadastro(LocalDateTime.now());
		funcionarioCadastro.getFuncionario().setUltimaAtualizacao(LocalDateTime.now());
		funcionarioCadastro.getFuncionario().setSituacao(Situacao.ATIVO);
		funcionarioCadastro.getFuncionario().setRegimeTrabalho(RegimeTrabalho.QUARENTA_HORAS_SEMANAIS);
		funcionarioCadastro.getFuncionario().setPessoa(funcionarioCadastro.getPessoa());
		funcionarioRepository.save(funcionarioCadastro.getFuncionario());
	}
}
