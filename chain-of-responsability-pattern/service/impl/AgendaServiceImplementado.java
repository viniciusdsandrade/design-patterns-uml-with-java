package service.impl;

import service.AgendaService;
import service.RepositorioAgendamentos;
import validators.ValidadorAgendamentoConsulta;
import exception.ValidacaoException;
import dto.DadosAgendamentoConsulta;

import java.util.List;

/**
 * Implementação concreta do serviço de agendamento de consultas.
 * <p>
 * Esta classe implementa a interface {@link AgendaService} e fornece a lógica
 * para agendar uma consulta, realizando validações e persistindo os dados.
 */
public class AgendaServiceImplementado implements AgendaService {
    private final List<ValidadorAgendamentoConsulta> validadores;
    private final RepositorioAgendamentos repositorio;

    /**
     * Constrói uma nova instância do serviço de agendamento.
     *
     * @param validadores Lista de validadores a serem aplicados aos dados de agendamento.
     * @param repositorio Repositório responsável por persistir os dados de agendamento.
     */
    public AgendaServiceImplementado(List<ValidadorAgendamentoConsulta> validadores, RepositorioAgendamentos repositorio) {
        this.validadores = validadores;
        this.repositorio = repositorio;
    }

    /**
     * {@inheritDoc}
     *
     * Este método aplica cada validador da lista aos dados de agendamento fornecidos.
     * Se todas as validações forem bem-sucedidas, os dados são salvos no repositório
     * e uma mensagem de sucesso é retornada. Caso contrário, uma exceção
     * {@link ValidacaoException} é lançada.
     */
    @Override
    public String agendar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        validadores.forEach(validador -> validador.validar(dados));
        repositorio.salvar(dados);
        return "Agendamento realizado com sucesso!";
    }
}