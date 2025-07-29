package br.com.pedrolucas.api.service.validacoes.agendamento;

import br.com.pedrolucas.api.dto.consultas.DadosAgendamentoConsulta;
import br.com.pedrolucas.api.repositories.MedicoRepository;
import br.com.pedrolucas.api.service.ValidacaoExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidacaoExcpetion("Consulta não pode ser agendada com médico inativo");
        }

    }

}
