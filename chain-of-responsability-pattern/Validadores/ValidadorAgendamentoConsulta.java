package Validadores;

import dto.DadosAgendamentoConsulta;
import Exception.ValidacaoException;

/**
 * Interface que define o contrato para validadores de dados de agendamento de consulta.
 * <p>
 * Classes que implementam esta interface são responsáveis por verificar a
 * validade dos dados fornecidos para o agendamento.
 */
public interface ValidadorAgendamentoConsulta {

    /**
     * Valida os dados de agendamento fornecidos.
     *
     * @param dados Os dados de agendamento a serem validados.
     * @throws ValidacaoException Se os dados forem inválidos,
     *                           uma exceção deve ser lançada.
     */
    void validar(DadosAgendamentoConsulta dados);
}