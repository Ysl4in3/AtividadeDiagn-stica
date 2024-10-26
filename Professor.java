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
public class Professor {
    class Professor extends Atividade01.Pessoa {
    private int siape;

    public Professor(String nome, String cpf, String endereco, String telefone, int siape) {
        super(nome, cpf, endereco, telefone);
        this.siape = siape;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" - SIAPE: " + siape);
    }
}
}
