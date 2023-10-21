package br.com.alura.curso.validations;

import br.com.alura.curso.records.ConsultasRecord;
import org.springframework.stereotype.Component;

@Component
public interface IValidation {
    void validar(ConsultasRecord record);
}
