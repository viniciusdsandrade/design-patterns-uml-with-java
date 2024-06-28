package src.service;

import src.dto.DadosAgendamentoConsulta;
import src.exception.ValidacaoException;

/**
 * Interface que define o serviço de agendamento de consultas.

 */
public interface AgendaService {

    /**
     * Agenda uma consulta com base nos dados fornecidos.
     *
     * @param dados Os dados para agendamento da consulta.
     * @return Uma String confirmando o agendamento (e.g., ID do agendamento).
     * @throws ValidacaoException Se houver algum problema de validação com os dados de agendamento.
     */
    String agendar(DadosAgendamentoConsulta dados) throws ValidacaoException;
}