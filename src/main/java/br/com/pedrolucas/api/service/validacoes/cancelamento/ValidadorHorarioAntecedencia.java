package br.com.pedrolucas.api.service.validacoes.cancelamento;

import br.com.pedrolucas.api.dto.consultas.DadosCancelamentoConsulta;
import br.com.pedrolucas.api.repositories.ConsultaRepository;
import br.com.pedrolucas.api.service.ValidacaoExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoExcpetion("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}

