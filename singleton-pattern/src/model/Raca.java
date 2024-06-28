package model;

import java.util.Objects;

/**
 * Representa a entidade "Raça", que possui um ID e um nome.
 * <p>
 * Esta classe implementa a interface {@link Cloneable} para permitir a criação de cópias.
 */
public class Raca implements Cloneable {

    private long id;
    private String nome;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Construtor padrão. Inicializa uma nova instância da raça com ID 0 e nome vazio.
     */
    public Raca() {
    }

    /**
     * Construtor que inicializa a raça com o ID e nome fornecidos.
     *
     * @param id   O ID da raça.
     * @param nome O nome da raça.
     */
    public Raca(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * Construtor de cópia. Cria uma nova instância da raça com os mesmos dados da raça fornecida.
     *
     * @param modelo A raça a ser copiada.
     */
    public Raca(Raca modelo) {
        this.id = modelo.id;
        this.nome = modelo.nome;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Cria e retorna uma cópia deste objeto.
     */
    @Override
    public Object clone() {
        try {
            return new Raca(this);
        } catch (Exception ignored) {
            return null; // Em caso de erro, retorna null
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * Calcula e retorna o código hash para este objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash *= prime  + Long.hashCode(id);
        hash *= prime  + ((nome == null) ? 0 : nome.hashCode());
        return hash;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Compara este objeto com o objeto especificado.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;

        Raca that = (Raca) obj;

        return this.id == that.id &&
                Objects.equals(this.nome, that.nome);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Retorna uma representação em string deste objeto no formato "ID - Nome".
     */
    @Override
    public String toString() {
        return id + " - " + nome;
    }
}