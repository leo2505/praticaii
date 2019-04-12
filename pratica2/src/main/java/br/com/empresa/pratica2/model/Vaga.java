package br.com.empresa.pratica2.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vagas")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvaga;
    private String descricaovaga;
    private String atribuicoesvaga;
    private Setor idsetor;
    private Cargo idcargo;
    private Escolaridade idescolaridade;

    public int getIdvaga() {
        return this.idvaga;
    }

    public void setIdvaga(int idvaga) {
        this.idvaga = idvaga;
    }

    public String getDescricaovaga() {
        return this.descricaovaga;
    }

    public void setDescricaovaga(String descricaovaga) {
        this.descricaovaga = descricaovaga;
    }

    public String getAtribuicoesvaga() {
        return this.atribuicoesvaga;
    }

    public void setAtribuicoesvaga(String atribuicoesvaga) {
        this.atribuicoesvaga = atribuicoesvaga;
    }

    public Setor getIdsetor() {
        return this.idsetor;
    }

    public void setIdsetor(Setor idsetor) {
        this.idsetor = idsetor;
    }

    public Cargo getIdcargo() {
        return this.idcargo;
    }

    public void setIdcargo(Cargo idcargo) {
        this.idcargo = idcargo;
    }

    public Escolaridade getIdescolaridade() {
        return this.idescolaridade;
    }

    public void setIdescolaridade(Escolaridade idescolaridade) {
        this.idescolaridade = idescolaridade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vaga)) {
            return false;
        }
        Vaga vaga = (Vaga) o;
        return idvaga == vaga.idvaga && Objects.equals(descricaovaga, vaga.descricaovaga)
                && Objects.equals(atribuicoesvaga, vaga.atribuicoesvaga) && Objects.equals(idsetor, vaga.idsetor)
                && Objects.equals(idcargo, vaga.idcargo) && Objects.equals(idescolaridade, vaga.idescolaridade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvaga, descricaovaga, atribuicoesvaga, idsetor, idcargo, idescolaridade);
    }
}