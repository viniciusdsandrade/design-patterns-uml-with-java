package src.validators;

import src.dto.DadosAgendamentoConsulta;

import src.exception.ValidacaoException;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Validador que verifica se o agendamento está sendo feito com antecedência mínima.
 */
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta {

    private static final long ANTECEDENCIA_MINIMA_MINUTOS = 30;
    private static final LocalDateTime AGORA = LocalDateTime.now();

    /**
     * {@inheritDoc}
     * <p>
     * Este validador verifica se o agendamento está sendo feito com pelo menos 30 minutos de antecedência.
     *
     * @param dados Os dados de agendamento a serem validados.
     * @throws ValidacaoException Se o agendamento for feito com menos de 30 minutos de antecedência.
     */
    @Override
    public void validar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        LocalDateTime dataConsulta = dados.dataHora();

        long diferencaEmMinutos = Duration.between(AGORA, dataConsulta).toMinutes();

        if (diferencaEmMinutos < ANTECEDENCIA_MINIMA_MINUTOS)
            throw new ValidacaoException("A consulta deve ser marcada com pelo menos 30 minutos de antecedência.");
    }
}
