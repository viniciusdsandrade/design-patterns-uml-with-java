package dto;

import enumerate.Especialidade;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para representar os dados de agendamento de uma consulta.
 *
 * @param nomePaciente  Nome completo do paciente que está agendando a consulta.
 * @param nomeMedico    Nome completo do médico com quem a consulta está sendo agendada.
 * @param especialidade Especialidade médica da consulta sendo agendada.
 * @param dataHora     Data e hora agendadas para a consulta.
 */
public record DadosAgendamentoConsulta(
        String nomePaciente,
        String nomeMedico,
        Especialidade especialidade,
        LocalDateTime dataHora
) {

    /**
     * Retorna a data e hora agendadas para a consulta.
     *
     * @return Data e hora da consulta.
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }
}