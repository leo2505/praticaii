package br.com.empresa.pratica2.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anexos") 
public class Anexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idanexo;
    private int anexoarquivo;

    public int getIdanexo()  {
         return this.idanexo;
    }

    public void setIdanexo(int idanexo) {
        this.idanexo = idanexo;
    }

    public int getAnexoarquivo() {
        return this.anexoarquivo;
    }

    public void setAnexoarquivo(int anexoarquivo) {
        this.anexoarquivo = anexoarquivo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Anexo)) {
            return false;
        }
        Anexo anexo = (Anexo) o;
        return idanexo == anexo.idanexo && anexoarquivo == anexo.anexoarquivo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idanexo, anexoarquivo);
    }
}