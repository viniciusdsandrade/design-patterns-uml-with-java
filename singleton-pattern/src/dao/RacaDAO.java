package dao;

import model.Raca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) para a entidade 'Raca'.
 * <p>
 * Provê métodos para acessar e manipular dados de raças no banco de dados.
 */
public class RacaDAO {

    private final Connection connection;

    /**
     * Construtor da classe 'RacaDAO'.
     *
     * @param connection A conexão com o banco de dados.
     */
    public RacaDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Cria uma nova raça no banco de dados.
     *
     * @param raca A raça a ser criada.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void create(Raca raca) throws SQLException {
        String sql = "INSERT INTO tb_raca (nome) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, raca.getNome());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next())
                    raca.setId(rs.getLong(1));
            }
        }
    }

    /**
     * Lê uma raça do banco de dados com base no ID fornecido.
     *
     * @param id O ID da raça a ser lida.
     * @return A raça correspondente ao ID fornecido, ou 'null' se não encontrada.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public Raca read(long id) throws SQLException {
        String sql = "SELECT * FROM tb_raca WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Raca raca = new Raca();
                    raca.setId(rs.getLong("id"));
                    raca.setNome(rs.getString("nome"));
                    return raca;
                }
            }
        }
        return null;
    }

    /**
     * Lê todas as raças do banco de dados.
     *
     * @return Uma lista contendo todas as raças encontradas.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public List<Raca> readAll() throws SQLException {
        List<Raca> racas = new ArrayList<>();
        String sql = "SELECT * FROM tb_raca";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Raca raca = new Raca();
                raca.setId(rs.getLong("id"));
                raca.setNome(rs.getString("nome"));
                racas.add(raca);
            }
        }
        return racas;
    }

    /**
     * Remove uma raça do banco de dados com base no ID fornecido.
     *
     * @param id O ID da raça a ser removida.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM tb_raca WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}