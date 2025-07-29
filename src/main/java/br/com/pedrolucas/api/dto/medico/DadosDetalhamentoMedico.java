package br.com.pedrolucas.api.dto.medico;

import br.com.pedrolucas.api.endereco.Endereco;
import br.com.pedrolucas.api.model.Especialidade;
import br.com.pedrolucas.api.model.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
