package controller;

import model.Raca;
import service.RacaService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador responsável por gerenciar as interações do usuário com as operações relacionadas à entidade 'Raca'.
 * <p>
 * Esta classe recebe as ações do usuário, delega as operações de negócio para o 'RacaService'
 * e apresenta os resultados ao usuário.
 */
public class RacaController {
    private final RacaService racaService;
    private final Scanner scanner;

    /**
     * Construtor da classe `RacaController`.
     *
     * @param connection A conexão com o banco de dados.
     */
    public RacaController(Connection connection) {
        this.racaService = new RacaService(connection);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia o loop principal de interação com o usuário,
     * apresentando um menu de opções e processando as escolhas do usuário.
     */
    public void run() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar raça");
            System.out.println("2. Ler raça");
            System.out.println("3. Ler todas as raças");
            System.out.println("4. Deletar raça");
            System.out.println("5. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> createRaca();
                    case 2 -> readRaca();
                    case 3 -> readAllRacas();
                    case 4 -> deleteRaca();
                    case 5 -> {
                        System.out.println("Saindo...");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (SQLException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }

    /**
     * Solicita ao usuário os dados da nova raça e a cria utilizando o 'RacaService'.
     *
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    private void createRaca() throws SQLException {
        System.out.println("Digite o nome da raça:");
        String nome = scanner.nextLine();
        racaService.createRaca(nome);
        System.out.println("Raça criada com sucesso!");
    }

    /**
     * Solicita ao usuário o ID da raça e a exibe, caso exista.
     *
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    private void readRaca() throws SQLException {
        System.out.println("Digite o ID da raça:");
        long id = scanner.nextLong();
        scanner.nextLine();

        Raca raca = racaService.getRaca(id);
        if (raca != null) {
            System.out.println("ID: " + raca.getId());
            System.out.println("Nome: " + raca.getNome());
        } else {
            System.out.println("Raça não encontrada!");
        }
    }

    /**
     * Exibe todas as raças existentes no banco de dados.
     *
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    private void readAllRacas() throws SQLException {
        List<Raca> racas = racaService.getAllRacas();
        racas.forEach(raca -> System.out.println("ID: " + raca.getId() + ", Nome: " + raca.getNome()));
    }

    /**
     * Solicita ao usuário o ID da raça e a remove, caso exista.
     *
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    private void deleteRaca() throws SQLException {
        System.out.println("Digite o ID da raça:");
        long id = scanner.nextLong();
        scanner.nextLine();

        racaService.deleteRaca(id);
        System.out.println("Raça deletada com sucesso!");
    }
}