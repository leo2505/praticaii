package br.com.empresa.pratica2.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estadocivil")
public class EstadoCivil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idestadocivil;
    private String descricaoestadocivil;

    public int getIdestadocivil() {
        return this.idestadocivil;
    }

    public void setIdestadocivil(int idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    public String getDescricaoestadocivil() {
        return this.descricaoestadocivil;
    }

    public void setDescricaoestadocivil(String descricaoestadocivil) {
        this.descricaoestadocivil = descricaoestadocivil;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil estadoCivil = (EstadoCivil) o;
        return idestadocivil == estadoCivil.idestadocivil
                && Objects.equals(descricaoestadocivil, estadoCivil.descricaoestadocivil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idestadocivil, descricaoestadocivil);
    }
}