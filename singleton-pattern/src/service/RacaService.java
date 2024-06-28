package service;

import dao.RacaDAO;
import model.Raca;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Serviço para gerenciar as operações CRUD da entidade Raca.
 */
public class RacaService {
    private final RacaDAO racaDAO;

    /**
     * Construtor que inicializa o DAO de Raca com a conexão fornecida.
     *
     * @param connection a conexão com o banco de dados.
     */
    public RacaService(Connection connection) {
        this.racaDAO = new RacaDAO(connection);
    }

    /**
     * Cria uma nova raça com o nome fornecido.
     *
     * @param nome o nome da nova raça.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public void createRaca(String nome) throws SQLException {
        Raca raca = new Raca();
        raca.setNome(nome);
        racaDAO.create(raca);
    }

    /**
     * Retorna a raça com o ID fornecido.
     *
     * @param id o ID da raça a ser retornada.
     * @return a raça com o ID fornecido.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public Raca getRaca(long id) throws SQLException {
        return racaDAO.read(id);
    }

    /**
     * Retorna uma lista de todas as raças.
     *
     * @return uma lista de todas as raças.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public List<Raca> getAllRacas() throws SQLException {
        return racaDAO.readAll();
    }

    /**
     * Deleta a raça com o ID fornecido.
     *
     * @param id o ID da raça a ser deletada.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public void deleteRaca(long id) throws SQLException {
        racaDAO.delete(id);
    }
}