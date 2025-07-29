package br.com.pedrolucas.api.service.validacoes.agendamento;

import br.com.pedrolucas.api.dto.consultas.DadosAgendamentoConsulta;
import br.com.pedrolucas.api.service.ValidacaoExcpetion;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30){
            throw new ValidacaoExcpetion("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }

    }

    }
