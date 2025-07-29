package br.com.pedrolucas.api.dto.paciente;

import jakarta.validation.constraints.NotNull;
import br.com.pedrolucas.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
