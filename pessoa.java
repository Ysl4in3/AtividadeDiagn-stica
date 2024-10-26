/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.pkg01;

/**
 *
 * @author aluno
 */
public class pessoa {
    abstract class Pessoa implements Atividade01.Printable {
    protected String nome, cpf, endereco, telefone;

    public Pessoa(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    @Override
    public void printInfo() {
        System.out.println(getClass().getSimpleName() + " " + nome + " - Cpf: " + cpf + " - End.: " + endereco + " - Tel.: " + telefone);
    }
}

    
}
