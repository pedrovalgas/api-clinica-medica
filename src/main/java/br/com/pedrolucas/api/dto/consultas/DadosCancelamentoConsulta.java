package br.com.pedrolucas.api.dto.consultas;

import br.com.pedrolucas.api.service.validacoes.cancelamento.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {
}
