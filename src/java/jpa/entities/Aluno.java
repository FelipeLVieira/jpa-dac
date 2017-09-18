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
    
    public Aluno(String matricula, String nome) {
        super(nome);
        this.matricula = matricula;
    }

    public Aluno(String matricula, String nome, String email) {
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
