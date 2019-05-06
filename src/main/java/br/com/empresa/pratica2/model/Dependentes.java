package br.com.empresa.pratica2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dependentes")
public class Dependentes {

private String tipoDependente;
private String nomeDependente;
private int rgDependente;
private int cpfDependente; 

    public String getTipoDependente() {
        return this.tipoDependente;
    }

    public void setTipoDependente(String TipoDependente) {
        this.tipoDependente = TipoDependente;
    }

    public String getNomeDependente() {
        return this.nomeDependente;
    }

    public void setNomeDependente(String NomeDependente) {
        this.nomeDependente = NomeDependente;
    }

    public int getRGdependente() {
        return this.rgDependente;
    }

    public void setRGdependente(int RGdependente) {
        this.rgDependente = RGdependente;
    }

    public int getCPFdependente() {
        return this.cpfDependente;
    }

    public void setCPFdependente(int CPFdependente) {
        this.cpfDependente = CPFdependente;
    }

    public Funcionario getIdfunc() {
        return this.idfunc;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dependentes)) {
            return false;
        }
        Dependentes dependentes = (Dependentes) o;
        return Objects.equals(tipoDependente, dependentes.tipoDependente) && Objects.equals(nomeDependente, dependentes.nomeDependente) && rgDependente == dependentes.rgDependente && cpfDependente == dependentes.cpfDependente && Objects.equals(idfunc, dependentes.idfunc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDependente, nomeDependente, rgDependente, cpfDependente, idfunc);
    }

    public void setIdfunc(Funcionario idfunc) {
        this.idfunc = idfunc;
    }
private Funcionario idfunc;

}