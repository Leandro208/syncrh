package br.com.syncrh.domain.enums;

public enum Situacao {

	ATIVO(1),
	APOSENTADO(2),
	CEDIDO(3),
	EXCLUIDO(4),
	SUSPENSO(5),
	NAO_INFORMADO(6);
	
	private final int codigo;
	
	private Situacao(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
}
