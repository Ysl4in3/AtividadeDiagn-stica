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
public class Estudante {
    
    class Estudante extends Atividade01.Pessoa {
    private String matricula;
    private Atividade01.Curso curso;

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula, Atividade01.Curso curso) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" - Matrícula: " + matricula);
    }
}
}
