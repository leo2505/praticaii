package br.com.empresa.pratica2.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcargo;
    private String descricaocargo;

    public int getIdcargo() {
        return this.idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public String getDescricaocargo() {
        return this.descricaocargo;
    }

    public void setDescricaocargo(String descricaocargo) {
        this.descricaocargo = descricaocargo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cargo)) {
            return false;
        }
        Cargo cargo = (Cargo) o;
        return idcargo == cargo.idcargo && Objects.equals(descricaocargo, cargo.descricaocargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcargo, descricaocargo);
    }
}