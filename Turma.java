package com.mycompany.atividadediagnostica2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yslaine
 */
public class Turma {

    public Turma(String turma_A, Curso cursoEngenharia, int par, Professor professor1) {
    }

    void addEstudante(Estudante estudante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void printTurmaInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void exibirEstatisticas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Iterable<Estudante> getEstudantesEmRecuperacao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    class Turma {
    private String identificacao;
    private Curso curso;
    private int semestre;
    private Professor professor;
    private List<Estudante> estudantes = new ArrayList<>();

    public Turma(String identificacao, Curso curso, int semestre, Professor professor) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.semestre = semestre;
        this.professor = professor;
    }

    public void addEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    public void printTurmaInfo() {
        System.out.println("\nTurma " + identificacao + " - Curso: " + curso.getNomeCurso() + " - Semestre: " + semestre);
        if (professor != null) {
            System.out.print("Professor: ");
            professor.printInfo();
        }
        System.out.println("Estudantes:");
        for (Estudante estudante : estudantes) {
            estudante.printInfo();
        }
    }

    public void exibirEstatisticas() {
        long aprovados = estudantes.stream().filter(e -> e.getSituacao().equals("APROVADO")).count();
        long recuperacao = estudantes.stream().filter(e -> e.getSituacao().contains("RECUPERAÇÃO")).count();
        long reprovados = estudantes.stream().filter(e -> e.getSituacao().equals("REPROVADO")).count();

        System.out.println("\nEstatísticas da Turma " + identificacao);
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Recuperação: " + recuperacao);
        System.out.println("Reprovados: " + reprovados);
    }

    public List<Estudante> getEstudantesEmRecuperacao() {
        List<Estudante> recuperacao = new ArrayList<>();
        for (Estudante estudante : estudantes) {
            if (estudante.getSituacao().contains("RECUPERAÇÃO")) {
                recuperacao.add(estudante);
            }
        }
        return recuperacao;
    }
}

    
}
