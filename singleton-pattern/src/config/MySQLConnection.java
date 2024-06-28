package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para gerenciar a conexão com o banco de dados usando o padrão Singleton.
 */
public class MySQLConnection {
    private static MySQLConnection instance;
    private Connection connection;
    private String url;
    private String username;
    private String password;

    /**
     * Construtor privado para inicializar a conexão com o banco de dados.
     *
     * @param dbName   o nome do banco de dados.
     * @param username o nome de usuário para acessar o banco de dados.
     * @param password a senha para acessar o banco de dados.
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
     * Retorna a instância única da conexão com o banco de dados.
     * Se a instância ainda não foi criada, uma nova instância é criada.
     *
     * @param dbName   o nome do banco de dados.
     * @param username o nome de usuário para acessar o banco de dados.
     * @param password a senha para acessar o banco de dados.
     * @return a instância única de DatabaseConnection.
     */
    public static MySQLConnection getInstance(String dbName, String username, String password) {
        if (instance == null)
            instance = new MySQLConnection(dbName, username, password);
        return instance;
    }

    /**
     * Retorna a conexão com o banco de dados.
     *
     * @return a conexão com o banco de dados.
     */
    public Connection getConnection() {
        return connection;
    }
}
