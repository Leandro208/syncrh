package br.com.syncrh.domain.enums;

public enum RegimeTrabalho {

	VINTE_HORAS_SEMANAIS("20H"),
	TRINTA_HORAS_SEMANAIS("30H"),
	QUARENTA_HORAS_SEMANAIS("40H");
	
	private final String regime;
	
	private RegimeTrabalho(String regime) {
		this.regime = regime;
	}
	
	public String getRegime() {
		return regime;
	}
}
