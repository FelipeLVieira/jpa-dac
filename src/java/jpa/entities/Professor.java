package jpa.entities;

import javax.persistence.*;
/**
 *
 * @author felip
 */
@Entity
public class Professor extends Pessoa{
    private String titulacao;

    public Professor() {
    }

    public Professor(Long id, String nome, String titulacao, String email) {
        super(id, nome, email);
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

}
