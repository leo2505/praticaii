package br.com.empresa.pratica2.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "anexoscurriculos")
public class AnexoCurriculo {
    @ManyToOne
    @JoinColumn(name = "curriculos")
    private Curriculo idcurriculo;

    @ManyToOne
    @JoinColumn(name = "anexos")
    private Anexo idanexo;

    public Curriculo getIdcurriculo() {
        return this.idcurriculo;
    }

    public void setIdcurriculo(Curriculo idcurriculo) {
        this.idcurriculo = idcurriculo;
    }

    public Anexo getIdanexo() {
        return this.idanexo;
    }

    public void setIdanexo(Anexo idanexo) {
        this.idanexo = idanexo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AnexoCurriculo)) {
            return false;
        }
        AnexoCurriculo anexoCurriculo = (AnexoCurriculo) o;
        return Objects.equals(idcurriculo, anexoCurriculo.idcurriculo)
                && Objects.equals(idanexo, anexoCurriculo.idanexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcurriculo, idanexo);
    }
}