package br.com.empresa.pratica2.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "escolaridade")
public class Escolaridade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idescolaridade;
    private String descricaoescolaridade;

    public int getIdescolaridade() {
        return this.idescolaridade;
    }

    public void setIdescolaridade(int idescolaridade) {
        this.idescolaridade = idescolaridade;
    }

    public String getDescricaoescolaridade() {
        return this.descricaoescolaridade;
    }

    public void setDescricaoescolaridade(String descricaoescolaridade) {
        this.descricaoescolaridade = descricaoescolaridade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Escolaridade)) {
            return false;
        }
        Escolaridade escolaridade = (Escolaridade) o;
        return idescolaridade == escolaridade.idescolaridade
                && Objects.equals(descricaoescolaridade, escolaridade.descricaoescolaridade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idescolaridade, descricaoescolaridade);
    }
}