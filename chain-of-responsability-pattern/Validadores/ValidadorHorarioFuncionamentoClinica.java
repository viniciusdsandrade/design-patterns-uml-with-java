package Validadores;

import dto.DadosAgendamentoConsulta;
import Exception.ValidacaoException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoConsulta {

    private static final LocalTime HORA_ABERTURA = LocalTime.of(8, 0);
    private static final LocalTime HORA_FECHAMENTO = LocalTime.of(18, 0);

    @Override
    public void validar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        LocalDateTime dataHoraConsulta = dados.getDataHora();

        if (dataHoraConsulta.toLocalTime().isBefore(HORA_ABERTURA) ||
                dataHoraConsulta.toLocalTime().isAfter(HORA_FECHAMENTO)) {
            throw new ValidacaoException("A clínica não funciona neste horário.");
        }
    }
}