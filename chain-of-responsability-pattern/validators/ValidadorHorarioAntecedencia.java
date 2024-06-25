package validators;

import dto.DadosAgendamentoConsulta;

import exception.ValidacaoException;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Validador que verifica se o agendamento está sendo feito com antecedência mínima.
 */
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta {

    /**
     * {@inheritDoc}
     *
     * Este validador verifica se o agendamento está sendo feito com pelo menos 30 minutos de antecedência.
     *
     * @param dados Os dados de agendamento a serem validados.
     * @throws ValidacaoException Se o agendamento for feito com menos de 30 minutos de antecedência.
     */
    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime dataConsulta = dados.dataHora();
        LocalDateTime agora = LocalDateTime.now();
        long diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("A consulta deve ser marcada com pelo menos 30 minutos de antecedência.");
        }
    }
}
