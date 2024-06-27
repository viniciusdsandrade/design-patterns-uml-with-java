package validators;

import dto.DadosAgendamentoConsulta;
import exception.ValidacaoException;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Validador que verifica se o horário de agendamento está dentro do horário de funcionamento da clínica.
 */
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoConsulta {

    private static final LocalTime HORA_ABERTURA = LocalTime.of(8, 0);
    private static final LocalTime HORA_FECHAMENTO = LocalTime.of(18, 0);

    /**
     * {@inheritDoc}
     * <p>
     * Este validador verifica se o horário de agendamento está dentro do horário de funcionamento da clínica,
     * definido entre as 8h00 e 18h00.
     *
     * @param dados Os dados de agendamento a serem validados.
     * @throws ValidacaoException Se o horário de agendamento estiver fora do horário de funcionamento.
     */
    @Override
    public void validar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        LocalDateTime dataHoraConsulta = dados.getDataHora();

        if (dataHoraConsulta.toLocalTime().isBefore(HORA_ABERTURA) ||
                dataHoraConsulta.toLocalTime().isAfter(HORA_FECHAMENTO))
            throw new ValidacaoException("A clínica não funciona neste horário.");
    }
}