package service;

import dao.RacaDAO;
import model.Raca;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Serviço que encapsula as operações de negócio relacionadas à entidade `Raca`.
 * <p>
 * Esta classe fornece uma camada de abstração sobre o DAO (`RacaDAO`),
 * expondo métodos para interagir com dados de raças no banco de dados.
 */
public class RacaService {
    private final RacaDAO racaDAO;

    /**
     * Construtor da classe `RacaService`.
     *
     * @param connection A conexão com o banco de dados.
     */
    public RacaService(Connection connection) {
        this.racaDAO = new RacaDAO(connection);
    }

    /**
     * Cria uma nova raça no banco de dados.
     *
     * @param nome O nome da nova raça.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void createRaca(String nome) throws SQLException {
        Raca raca = new Raca();
        raca.setNome(nome);
        racaDAO.create(raca);
    }

    /**
     * Retorna a raça correspondente ao ID fornecido.
     *
     * @param id O ID da raça a ser buscada.
     * @return A raça encontrada, ou `null` se não existir raça com o ID informado.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public Raca getRaca(long id) throws SQLException {
        return racaDAO.read(id);
    }

    /**
     * Retorna todas as raças existentes no banco de dados.
     *
     * @return Uma lista contendo todas as raças encontradas.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public List<Raca> getAllRacas() throws SQLException {
        return racaDAO.readAll();
    }

    /**
     * Remove a raça correspondente ao ID fornecido.
     *
     * @param id O ID da raça a ser removida.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void deleteRaca(long id) throws SQLException {
        racaDAO.delete(id);
    }
}