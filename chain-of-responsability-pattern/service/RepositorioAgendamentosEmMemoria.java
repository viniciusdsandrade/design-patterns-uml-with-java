package service;

import dto.DadosAgendamentoConsulta;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAgendamentosEmMemoria implements RepositorioAgendamentos {
    private final List<DadosAgendamentoConsulta> agendamentos = new ArrayList<>();

    @Override
    public void salvar(DadosAgendamentoConsulta dados) {
        agendamentos.add(dados);
    }
}