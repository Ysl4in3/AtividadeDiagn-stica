/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.pkg01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Turma {
    class Turma {
    private String identificacao;
    private Atividade01.Curso curso;
    private int semestre;
    private Atividade01.Professor professor;
    private List<Atividade01.Estudante> estudantes = new ArrayList<>();

    public Turma(String identificacao, Atividade01.Curso curso, int semestre, Atividade01.Professor professor) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.semestre = semestre;
        this.professor = professor;
    }

    public void addEstudante(Atividade01.Estudante estudante) {
        estudantes.add(estudante);
    }

    public void printTurmaInfo() {
        System.out.println("\nTurma " + identificacao + " - Curso: " + curso.getNomeCurso() + " - Semestre: " + semestre);
        if (professor != null) {
            System.out.print("Professor: ");
            professor.printInfo();
        }
        System.out.println("Estudantes:");
        for (Atividade01.Estudante estudante : estudantes) {
            estudante.printInfo();
        }
    }
}
}
