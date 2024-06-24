package Exception;

public class ValidacaoException extends RuntimeException {

    /**
     * Construtor para criar uma nova instância de Exception.ValidacaoException com uma mensagem de erro personalizada.
     *
     * @param message A mensagem de erro detalhando a natureza do problema.
     */
    public ValidacaoException(String message) {
        super(message);
    }
}