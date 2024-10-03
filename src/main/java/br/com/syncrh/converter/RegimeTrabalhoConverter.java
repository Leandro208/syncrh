package br.com.syncrh.converter;


import br.com.syncrh.domain.enums.RegimeTrabalho;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RegimeTrabalhoConverter implements AttributeConverter<RegimeTrabalho, String> {

	@Override
    public String convertToDatabaseColumn(RegimeTrabalho regimeTrabalho) {
        if (regimeTrabalho == null) {
            return null;
        }
        return regimeTrabalho.getRegime();  
    }

    @Override
    public RegimeTrabalho convertToEntityAttribute(String regime) {
        if (regime == null) {
            return null;
        }

        for (RegimeTrabalho rt : RegimeTrabalho.values()) {
            if (rt.getRegime().equals(regime)) {
                return rt;
            }
        }

        throw new IllegalArgumentException("Regime de trabalho desconhecido: " + regime);
    }

}
