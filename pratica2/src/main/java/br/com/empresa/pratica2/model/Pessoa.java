package br.com.empresa.pratica2.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpessoa;
    private String nomepessoa;
    private Date datanascimento;
    private String emailpessoa;
    private String contatopessoa;
    private int sexopessoa;
    private String cpfpessoa;

    @ManyToOne
    @JoinColumn(name = "idestadocivil")
    private EstadoCivil idestadocivil;

    public int getIdpessoa() {
        return this.idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNomepessoa() {
        return this.nomepessoa;
    }

    public void setNomepessoa(String nomepessoa) {
        this.nomepessoa = nomepessoa;
    }

    public Date getDatanascimento() {
        return this.datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getEmailpessoa() {
        return this.emailpessoa;
    }

    public void setEmailpessoa(String emailpessoa) {
        this.emailpessoa = emailpessoa;
    }

    public String getContatopessoa() {
        return this.contatopessoa;
    }

    public void setContatopessoa(String contatopessoa) {
        this.contatopessoa = contatopessoa;
    }

    public int getSexopessoa() {
        return this.sexopessoa;
    }

    public void setSexopessoa(int sexopessoa) {
        this.sexopessoa = sexopessoa;
    }

    public String getCpfpessoa() {
        return this.cpfpessoa;
    }

    public void setCpfpessoa(String cpfpessoa) {
        this.cpfpessoa = cpfpessoa;
    }

    public EstadoCivil getIdestadocivil() {
        return this.idestadocivil;
    }

    public void setIdestadocivil(EstadoCivil idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return idpessoa == pessoa.idpessoa && Objects.equals(nomepessoa, pessoa.nomepessoa)
                && Objects.equals(datanascimento, pessoa.datanascimento)
                && Objects.equals(emailpessoa, pessoa.emailpessoa)
                && Objects.equals(contatopessoa, pessoa.contatopessoa) && sexopessoa == pessoa.sexopessoa
                && Objects.equals(cpfpessoa, pessoa.cpfpessoa) && Objects.equals(idestadocivil, pessoa.idestadocivil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpessoa, nomepessoa, datanascimento, emailpessoa, contatopessoa, sexopessoa, cpfpessoa,
                idestadocivil);
    }

}