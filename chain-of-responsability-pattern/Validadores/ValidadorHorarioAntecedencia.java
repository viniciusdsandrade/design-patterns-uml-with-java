package Validadores;

import dto.DadosAgendamentoConsulta;

import Exception.ValidacaoException;
import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta{
    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime dataConsulta = dados.dataHora();
        LocalDateTime agora = LocalDateTime.now();
        long diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30)
            throw new ValidacaoException("A consulta deve ser marcada com pelo menos 30 minutos de antecedência.");
    }
}
