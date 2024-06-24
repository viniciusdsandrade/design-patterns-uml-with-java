package service;

import dto.DadosAgendamentoConsulta;

/**
 * Interface que define o contrato para o repositório de agendamentos de consulta.
 * Define o metodo para persistir os dados de agendamento.
 */
public interface RepositorioAgendamentos {

    /**
     * Salva os dados de agendamento de consulta.
     *
     * @param dados Os dados da consulta a serem salvos.
     */
    void salvar(DadosAgendamentoConsulta dados);
}
