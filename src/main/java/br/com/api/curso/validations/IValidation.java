package br.com.api.curso.validations;

import br.com.api.curso.records.ConsultasRecord;
import org.springframework.stereotype.Component;

@Component
public interface IValidation {
    void validar(ConsultasRecord record);
}
