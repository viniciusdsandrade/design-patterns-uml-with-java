package src.validators;

import src.dto.DadosAgendamentoConsulta;
import src.exception.ValidacaoException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * Validador que verifica se o dia de agendamento está dentro dos dias de funcionamento da clínica.
 */
public class ValidadorDiaDeFuncionamentoClinica implements ValidadorAgendamentoConsulta {

    private static final DayOfWeek DIA_ABERTURA = DayOfWeek.MONDAY;
    private static final DayOfWeek DIA_FECHAMENTO = DayOfWeek.SATURDAY;

    /**
     * {@inheritDoc}
     * <p>
     * Este validador verifica se o dia de agendamento está dentro dos dias de funcionamento da clínica,
     * definido entre segunda-feira e sábado.
     *
     * @param dados Os dados de agendamento a serem validados.
     * @throws ValidacaoException Se o dia de agendamento estiver fora dos dias de funcionamento.
     */
    @Override
    public void validar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        LocalDateTime dataHoraConsulta = dados.getDataHora();
        DayOfWeek diaConsulta = dataHoraConsulta.getDayOfWeek();

        if (diaConsulta.getValue() < DIA_ABERTURA.getValue() ||
                diaConsulta.getValue() > DIA_FECHAMENTO.getValue())
            throw new ValidacaoException("A clínica não funciona neste dia.");
    }
}

