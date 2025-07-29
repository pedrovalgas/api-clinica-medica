package br.com.pedrolucas.api.service.validacoes.agendamento;

import br.com.pedrolucas.api.dto.consultas.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsulta dados);
}
