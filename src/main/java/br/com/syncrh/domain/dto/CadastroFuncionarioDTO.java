package br.com.syncrh.domain.dto;

import br.com.syncrh.domain.entity.Funcionario;
import br.com.syncrh.domain.entity.Pessoa;
import br.com.syncrh.domain.entity.Usuario;

public class CadastroFuncionarioDTO {

	private Funcionario funcionario;
	private Pessoa pessoa;
	private Usuario usuario;
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
