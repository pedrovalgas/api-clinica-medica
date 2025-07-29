package br.com.pedrolucas.api.dto.medico;

import br.com.pedrolucas.api.model.Especialidade;
import br.com.pedrolucas.api.model.Medico;


public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
