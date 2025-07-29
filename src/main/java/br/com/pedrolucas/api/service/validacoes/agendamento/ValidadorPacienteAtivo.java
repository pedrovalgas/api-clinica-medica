package br.com.pedrolucas.api.service.validacoes.agendamento;

import br.com.pedrolucas.api.dto.consultas.DadosAgendamentoConsulta;
import br.com.pedrolucas.api.repositories.PacienteRepository;
import br.com.pedrolucas.api.service.ValidacaoExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());

        if (!pacienteEstaAtivo){
            throw new ValidacaoExcpetion("Consulta não pode ser agendada com paciente excluído");
        }
    }

}
