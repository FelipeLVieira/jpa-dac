package jpa.entities;

import javax.persistence.*;
/**
 *
 * @author felip
 */
@Entity
public class Aluno extends Pessoa{
    private String matricula;

    public Aluno() {
    }
    
    public Aluno(String nome, String matricula) {
        super(nome);
        this.matricula = matricula;
    }

    public Aluno(String nome, String email, String matricula) {
        super(nome, email);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    
}
