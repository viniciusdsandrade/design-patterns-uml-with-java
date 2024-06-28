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
                .getInstance(dbName, user, password);

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

//    public static void main(String[] args) {
//        // Substitua pelos seus dados de conexão
//        String dbName = "db_test_singleton_pattern";
//        String user = "root";
//        String password = "GhostSthong567890@";
//
//        // Obtenha a instância da conexão
//        config.DatabaseConnection dbConnection = config.DatabaseConnection.getInstance(dbName, user, password);
//        Connection connection = dbConnection.getConnection();
//
//        if (connection != null) {
//            try {
//                // Crie um Statement para executar uma consulta
//                Statement statement = connection.createStatement();
//
//                // Execute uma consulta simples (substitua pela sua consulta)
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM tb_raca ORDER BY id");
//
//                // Imprima os resultados
//                while (resultSet.next())
//                    System.out.println(resultSet.getLong("id") + " - " + resultSet.getString("nome"));
//
//                // Feche o ResultSet, Statement e conexão
//                resultSet.close();
//                statement.close();
//                connection.close();
//
//            } catch (SQLException e) {
//                System.err.println("Erro ao executar consulta: " + e.getMessage());
//            }
//        }
//    }
}