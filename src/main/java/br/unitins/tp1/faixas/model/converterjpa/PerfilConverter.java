package br.unitins.tp1.faixas.model.converterjpa;

import br.unitins.tp1.faixas.model.Perfil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PerfilConverter implements AttributeConverter<Perfil, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Perfil perfil) {
        return perfil == null ? null : perfil.getId();
    }

    @Override
    public Perfil convertToEntityAttribute(Integer idPerfil) {
        return Perfil.valueOf(idPerfil);
    }
    
}
