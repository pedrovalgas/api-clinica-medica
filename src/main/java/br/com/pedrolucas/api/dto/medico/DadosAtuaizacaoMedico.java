package br.com.pedrolucas.api.dto.medico;

import br.com.pedrolucas.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtuaizacaoMedico(

        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco) {
}
