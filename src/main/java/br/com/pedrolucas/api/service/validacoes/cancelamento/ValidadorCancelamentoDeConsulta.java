package br.com.pedrolucas.api.service.validacoes.cancelamento;

import br.com.pedrolucas.api.dto.consultas.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);

}
