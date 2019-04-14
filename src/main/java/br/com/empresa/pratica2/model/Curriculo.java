package br.com.empresa.pratica2.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "curriculos")
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcurriculo;
    private String experienciascurriculo;
    private String habilidadescurriculo;

    @ManyToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa idpessoa;

    @ManyToOne
    @JoinColumn(name = "idvaga")
    private Vaga idvaga;

    public int getIdcurriculo() {
        return this.idcurriculo;
    }

    public void setIdcurriculo(int idcurriculo) {
        this.idcurriculo = idcurriculo;
    }

    public String getExperienciascurriculo() {
        return this.experienciascurriculo;
    }

    public void setExperienciascurriculo(String experienciascurriculo) {
        this.experienciascurriculo = experienciascurriculo;
    }

    public String getHabilidadescurriculo() {
        return this.habilidadescurriculo;
    }

    public void setHabilidadescurriculo(String habilidadescurriculo) {
        this.habilidadescurriculo = habilidadescurriculo;
    }

    public Pessoa getIdpessoa() {
        return this.idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
    }

    public Vaga getIdvaga() {
        return this.idvaga;
    }

    public void setIdvaga(Vaga idvaga) {
        this.idvaga = idvaga;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Curriculo)) {
            return false;
        }
        Curriculo curriculo = (Curriculo) o;
        return idcurriculo == curriculo.idcurriculo
                && Objects.equals(experienciascurriculo, curriculo.experienciascurriculo)
                && Objects.equals(habilidadescurriculo, curriculo.habilidadescurriculo)
                && Objects.equals(idpessoa, curriculo.idpessoa) && Objects.equals(idvaga, curriculo.idvaga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcurriculo, experienciascurriculo, habilidadescurriculo, idpessoa, idvaga);
    }
}