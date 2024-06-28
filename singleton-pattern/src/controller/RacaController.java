package controller;

import model.Raca;
import service.RacaService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador para gerenciar as operações CRUD da entidade Raca.
 */
public class RacaController {
    private final RacaService racaService;
    private final Scanner scanner;

    /**
     * Construtor que inicializa o serviço de Raca e o scanner para entrada do usuário.
     *
     * @param connection a conexão com o banco de dados.
     */
    public RacaController(Connection connection) {
        this.racaService = new RacaService(connection);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método principal que executa o loop de entrada do usuário para operações CRUD.
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
            scanner.nextLine(); // Consumir a nova linha

            try {
                switch (choice) {
                    case 1:
                        createRaca();
                        break;
                    case 2:
                        readRaca();
                        break;
                    case 3:
                        readAllRacas();
                        break;
                    case 4:
                        deleteRaca();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (SQLException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }

    /**
     * Cria uma nova raça solicitando o nome ao usuário.
     *
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    private void createRaca() throws SQLException {
        System.out.println("Digite o nome da raça:");
        String nome = scanner.nextLine();
        racaService.createRaca(nome);
        System.out.println("Raça criada com sucesso!");
    }

    /**
     * Lê uma raça específica solicitando o ID ao usuário.
     *
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    private void readRaca() throws SQLException {
        System.out.println("Digite o ID da raça:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consumir a nova linha

        Raca raca = racaService.getRaca(id);
        if (raca != null) {
            System.out.println("ID: " + raca.getId());
            System.out.println("Nome: " + raca.getNome());
        } else {
            System.out.println("Raça não encontrada!");
        }
    }

    /**
     * Lê todas as raças e as imprime.
     *
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    private void readAllRacas() throws SQLException {
        List<Raca> racas = racaService.getAllRacas();
        racas.stream().map(raca -> "ID: " + raca.getId() + ", Nome: " + raca.getNome()).forEach(System.out::println);
    }

    /**
     * Deleta uma raça específica solicitando o ID ao usuário.
     *
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    private void deleteRaca() throws SQLException {
        System.out.println("Digite o ID da raça:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consumir a nova linha

        racaService.deleteRaca(id);
        System.out.println("Raça deletada com sucesso!");
    }
}