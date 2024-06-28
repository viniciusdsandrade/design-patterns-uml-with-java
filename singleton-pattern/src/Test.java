import config.MySQLConnection;
import controller.RacaController;

import java.sql.Connection;

public class Test {

    public static void main(String[] args) {
        // Define o nome do banco de dados, nome de usuário e senha
        String dbName = "db_test_singleton_pattern";
        String user = "root";
        String password = "GhostSthong567890@";

        // Obtém a instância da conexão singleton com o banco de dados
        MySQLConnection dbConnection = MySQLConnection
                .getInstance(dbName, user, password, 3307);

        // Obtém a conexão a partir da instância singleton
        Connection connection = dbConnection.getConnection();

        // Verifica se a conexão foi estabelecida com sucesso
        if (connection != null) {
            RacaController controller = new RacaController(connection); // Cria um controlador de Raca com a conexão
            controller.run(); // Executa o metodo run do controlador, que gerencia as operações CRUD
        } else {
            System.err.println("Erro ao conectar ao banco de dados.");
        }
    }
}