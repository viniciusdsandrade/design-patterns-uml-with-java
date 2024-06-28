package model;

import java.util.Objects;

/**
 * Classe que representa a entidade Raca.
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
     * Construtor padrão.
     */
    public Raca() {
    }

    /**
     * Construtor que inicializa a raça com um ID e nome.
     *
     * @param id   o ID da raça.
     * @param nome o nome da raça.
     */
    public Raca(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * Construtor de cópia.
     *
     * @param modelo a raça a ser copiada.
     */
    public Raca(Raca modelo) {
        this.id = modelo.id;
        this.nome = modelo.nome;
    }

    /**
     * Cria e retorna uma cópia deste objeto.
     *
     * @return uma cópia deste objeto.
     */
    @Override
    public Object clone() {
        Raca clone = null;
        try {
            clone = new Raca(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    /**
     * Calcula e retorna o código hash para este objeto.
     *
     * @return o código hash para este objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + (int) id;
        hash *= prime + ((nome == null) ? 0 : nome.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    /**
     * Compara este objeto com o objeto especificado.
     *
     * @param obj o objeto a ser comparado.
     * @return {@code true} se os objetos são iguais; {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Raca other = (Raca) obj;

        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.nome, other.nome);
    }

    /**
     * Retorna uma representação em string deste objeto.
     *
     * @return uma representação em string deste objeto.
     */
    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
