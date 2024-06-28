package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Implementa o padrão Singleton para fornecer uma única instância de conexão com o banco de dados MySQL.
 * Essa classe encapsula os detalhes da conexão, como URL, usuário e senha,
 * e garante que apenas uma instância da conexão seja criada e reutilizada em toda a aplicação.
 */
public class MySQLConnection {

    /**
     * Única instância da classe MySQLConnection.
     */
    private static MySQLConnection instance;

    /**
     * Conexão com o banco de dados.
     */
    private Connection connection;

    /**
     * URL de conexão com o banco de dados.
     */
    private String url;

    /**
     * Nome de usuário para acesso ao banco de dados.
     */
    private String username;

    /**
     * Senha para acesso ao banco de dados.
     */
    private String password;

    /**
     * Construtor privado para evitar a criação de múltiplas instâncias da classe.
     * Estabelece a conexão com o banco de dados utilizando os parâmetros fornecidos.
     *
     * @param dbName   O nome do banco de dados.
     * @param username O nome de usuário para acesso ao banco de dados.
     * @param password A senha para acesso ao banco de dados.
     */
    private MySQLConnection(String dbName, String username, String password) {
        try {
            this.url = "jdbc:mysql://localhost:3306/" + dbName;
            this.username = username;
            this.password = password;
            this.connection = DriverManager.getConnection(url, this.username, this.password);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    /**
     * Retorna a única instância da classe MySQLConnection, criando-a caso ainda não exista.
     *
     * @param dbName   O nome do banco de dados.
     * @param username O nome de usuário para acesso ao banco de dados.
     * @param password A senha para acesso ao banco de dados.
     * @return A instância única da classe MySQLConnection.
     */
    public static MySQLConnection getInstance(String dbName, String username, String password) {
        if (instance == null) {
            instance = new MySQLConnection(dbName, username, password);
        }
        return instance;
    }

    /**
     * Retorna a conexão estabelecida com o banco de dados.
     *
     * @return A conexão com o banco de dados.
     */
    public Connection getConnection() {
        return connection;
    }
}