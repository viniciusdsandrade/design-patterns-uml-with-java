package src.service.impl;

import src.dto.DadosAgendamentoConsulta;
import src.service.RepositorioAgendamentos;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do repositório de agendamentos que armazena os dados em memória.
 * <p>
 * Esta implementação é útil para fins de testes ou prototipagem,
 * onde a persistência em um banco de dados real não é necessária.
 */
public class RepositorioAgendamentosEmMemoria implements RepositorioAgendamentos {

    private final List<DadosAgendamentoConsulta> agendamentos;

    /**
     * Constrói uma nova instância do repositório de agendamentos em memória.
     */
    public RepositorioAgendamentosEmMemoria() {
        agendamentos = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Este método adiciona os dados de agendamento fornecidos à lista
     * de agendamentos mantida em memória.
     */
    @Override
    public void salvar(DadosAgendamentoConsulta dados) {
        agendamentos.add(dados);
    }
}