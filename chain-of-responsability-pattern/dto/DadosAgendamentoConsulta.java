package dto;

import enumerate.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
    String nomePaciente,
    String nomeMedico,
    Especialidade especialidade,
    LocalDateTime dataHora
) {

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
