package dao;

import model.Raca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RacaDAO {
    private final Connection connection;

    public RacaDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Raca raca) throws SQLException {
        String sql = "INSERT INTO tb_raca (nome) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, raca.getNome());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    raca.setId(rs.getLong(1));
                }
            }
        }
    }

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

    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM tb_raca WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
