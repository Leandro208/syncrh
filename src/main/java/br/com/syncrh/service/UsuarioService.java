package br.com.syncrh.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.syncrh.dominio.Usuario;
import br.com.syncrh.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Transactional
	public void cadastrar(Usuario usuario) {
		usuario.setEmail(usuario.getPessoa().getEmail());
		usuario.setDataCadastro(LocalDateTime.now());
		usuario.setAtivo(true);
		usuarioRepository.save(usuario);
	}
}
