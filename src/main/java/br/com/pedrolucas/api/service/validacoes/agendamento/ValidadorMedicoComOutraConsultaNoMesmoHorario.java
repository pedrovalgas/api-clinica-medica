package br.com.pedrolucas.api.service.validacoes.agendamento;

import br.com.pedrolucas.api.dto.consultas.DadosAgendamentoConsulta;
import br.com.pedrolucas.api.repositories.ConsultaRepository;
import br.com.pedrolucas.api.service.ValidacaoExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoExcpetion("Médico");
        }
    }
}
