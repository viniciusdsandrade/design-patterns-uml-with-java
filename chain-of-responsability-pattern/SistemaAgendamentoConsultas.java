import validators.ValidadorAgendamentoConsulta;
import validators.ValidadorDiaDeFuncionamentoClinica;
import validators.ValidadorHorarioAntecedencia;
import validators.ValidadorHorarioFuncionamentoClinica;
import dto.DadosAgendamentoConsulta;
import enumerate.Especialidade;
import service.impl.AgendaServiceImplementado;
import service.RepositorioAgendamentos;
import exception.ValidacaoException;
import service.impl.RepositorioAgendamentosEmMemoria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaAgendamentoConsultas {

    public static void main(String[] args) {
        // Configuração do repositório e validadores
        RepositorioAgendamentos repositorio = new RepositorioAgendamentosEmMemoria();
        List<ValidadorAgendamentoConsulta> validadores = new ArrayList<>();
        validadores.add(new ValidadorHorarioAntecedencia());
        validadores.add(new ValidadorHorarioFuncionamentoClinica());
        validadores.add(new ValidadorDiaDeFuncionamentoClinica());

        // Instanciação do serviço de agendamento
        AgendaServiceImplementado agendaService = new AgendaServiceImplementado(validadores, repositorio);

        // Teste 1: Agendamento com sucesso
        DadosAgendamentoConsulta dadosConsulta1 = new DadosAgendamentoConsulta(
                "João",
                "Silva",
                Especialidade.CARDIOLOGIA,
                LocalDateTime.now().plusDays(1).withHour(10).withMinute(0)
        );
        try {
            String resultado1 = agendaService.agendar(dadosConsulta1);
            System.out.println("Teste 1: " + resultado1);
        } catch (ValidacaoException e) {
            System.out.println("Teste 1: " + e.getMessage());
        }

        // Teste 2: Agendamento com menos de 30 minutos de antecedência
        DadosAgendamentoConsulta dadosConsulta2 = new DadosAgendamentoConsulta(
                "Maria",
                "Souza",
                Especialidade.DERMATOLOGIA,
                LocalDateTime.now().plusMinutes(29)
        );
        try {
            String resultado2 = agendaService.agendar(dadosConsulta2);
            System.out.println("Teste 2: " + resultado2);
        } catch (ValidacaoException e) {
            System.out.println("Teste 2: " + e.getMessage());
        }

        // Teste 3: Agendamento fora do horário de funcionamento da clínica
        DadosAgendamentoConsulta dadosConsulta3 = new DadosAgendamentoConsulta(
                "Pedro",
                "Oliveira",
                Especialidade.ORTOPEDIA,
                LocalDateTime.now().plusDays(1).withHour(20)
        );
        try {
            String resultado3 = agendaService.agendar(dadosConsulta3);
            System.out.println("Teste 3: " + resultado3);
        } catch (ValidacaoException e) {
            System.out.println("Teste 3: " + e.getMessage());
        }

        // Teste 4: Agendamento em um dia fora de funcionamento (Domingo)
        DadosAgendamentoConsulta dadosConsulta4 = new DadosAgendamentoConsulta(
                "Ana",
                "Santos",
                Especialidade.PEDIATRIA,
                LocalDateTime.now().plusDays(4).withHour(10).withMinute(0) // Ajustado para o próximo domingo
        );
        try {
            String resultado4 = agendaService.agendar(dadosConsulta4);
            System.out.println("Teste 4: " + resultado4);
        } catch (ValidacaoException e) {
            System.out.println("Teste 4: " + e.getMessage());
        }
    }
}