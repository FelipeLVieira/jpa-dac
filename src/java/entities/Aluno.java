/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author felip
 */
@Entity
public class Aluno extends Pessoa{
    public String matricula;
}
