package br.com.empresa.pratica2.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "setor")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsetor;
    private String descricaosetor;

    public int getIdsetor() {
        return this.idsetor;
    }

    public void setIdsetor(int idsetor) {
        this.idsetor = idsetor;
    }

    public String getDescricaosetor() {
        return this.descricaosetor;
    }

    public void setDescricaosetor(String descricaosetor) {
        this.descricaosetor = descricaosetor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Setor)) {
            return false;
        }
        Setor pra_setor = (Setor) o;
        return idsetor == pra_setor.idsetor && Objects.equals(descricaosetor, pra_setor.descricaosetor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idsetor, descricaosetor);
    }
}