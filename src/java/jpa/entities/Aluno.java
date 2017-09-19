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

    public Aluno(Long id, String nome, String email, String matricula) {
        super(id, nome, email);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    
}
