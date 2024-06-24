package service;

import Validadores.ValidadorAgendamentoConsulta;
import Exception.ValidacaoException;
import dto.DadosAgendamentoConsulta;

import java.util.List;

public class AgendaServiceImplementado implements AgendaService {
    private final List<ValidadorAgendamentoConsulta> validadores;
    private final RepositorioAgendamentos repositorio;

    public AgendaServiceImplementado(List<ValidadorAgendamentoConsulta> validadores, RepositorioAgendamentos repositorio) {
        this.validadores = validadores;
        this.repositorio = repositorio;
    }

    @Override
    public String agendar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        for (ValidadorAgendamentoConsulta validador : validadores) {
            validador.validar(dados);
        }
        repositorio.salvar(dados);
        return "Agendamento realizado com sucesso!";
    }
}
