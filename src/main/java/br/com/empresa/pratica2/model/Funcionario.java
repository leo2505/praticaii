package br.com.empresa.pratica2.model;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Funcionario {
   
    String endereco;
    String telefone;
    int numeroDependentes;



    @ManyToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa idpessoa;
   
    @ManyToOne
    @JoinColumn (name = "idescolaridade")
    private Escolaridade idescolaridade;

    @ManyToOne
    @JoinColumn (name = "idcargo")
    private Cargo idcargo;

    @ManyToOne
    @JoinColumn (name = "idsetor")
    private Setor idsetor;
}