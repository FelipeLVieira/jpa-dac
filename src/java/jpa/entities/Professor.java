package jpa.entities;

import javax.persistence.*;
/**
 *
 * @author felip
 */
@Entity
public class Professor extends Pessoa{
    private String titulacao;
    
    public Professor(String titulacao, String nome) {
        super(nome);
        this.titulacao = titulacao;
    }

    public Professor() {
    }

    public Professor(String titulacao, String nome, String email) {
        super(nome, email);
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

}
