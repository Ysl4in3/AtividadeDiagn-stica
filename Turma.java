package com.mycompany.atividade02;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String identificacao;
    private Curso curso;
    private int semestre;
    private Professor professor;
    private List<Estudante> estudantes = new ArrayList<>();
    private List<String> log = new ArrayList<>(); // Lista para armazenar o log

    public Turma(String identificacao, Curso curso, int semestre, Professor professor) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.semestre = semestre;
        this.professor = professor;
    }

    // Método para adicionar estudante à turma e registrar no log
    public void addEstudante(Estudante estudante) {
        estudantes.add(estudante);
        log.add("Estudante " + estudante.getNome() + " adicionado à turma " + identificacao);
    }

    // Método para exibir informações gerais da turma
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

    // Método para exibir as estatísticas da turma (aprovados, recuperação, reprovados)
    public void exibirEstatisticas() {
        long aprovados = estudantes.stream().filter(e -> e.getSituacao().equals("APROVADO")).count();
        long recuperacao = estudantes.stream().filter(e -> e.getSituacao().contains("RECUPERAÇÃO")).count();
        long reprovados = estudantes.stream().filter(e -> e.getSituacao().equals("REPROVADO")).count();

        System.out.println("\nEstatísticas da Turma " + identificacao);
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Recuperação: " + recuperacao);
        System.out.println("Reprovados: " + reprovados);
    }

    // Método para obter a lista de estudantes em recuperação
    public List<Estudante> getEstudantesEmRecuperacao() {
        List<Estudante> recuperacao = new ArrayList<>();
        for (Estudante estudante : estudantes) {
            if (estudante.getSituacao().contains("RECUPERAÇÃO")) {
                recuperacao.add(estudante);
            }
        }
        return recuperacao;
    }

    // Método para obter a lista de estudantes aprovados
    public List<Estudante> getEstudantesAprovados() {
        List<Estudante> aprovados = new ArrayList<>();
        for (Estudante estudante : estudantes) {
            if (estudante.getSituacao().equals("APROVADO")) {
                aprovados.add(estudante);
            }
        }
        return aprovados;
    }

    // Método para obter a lista final (após recuperação)
    public List<Estudante> getEstudantesFinal() {
        return estudantes;
    }

    // Método para exibir a lista de estudantes com suas notas
    public void exibirListaEstudantesComNotas() {
        System.out.println("\nLista de Estudantes e suas Notas:");
        for (Estudante estudante : estudantes) {
            System.out.println("Nome: " + estudante.getNome() + " - Notas: " + estudante.getNotas() + " - Situação: " + estudante.getSituacao());
        }
    }

    // Método para exibir lista de estudantes em recuperação
    public void exibirEstudantesEmRecuperacao() {
        System.out.println("\nEstudantes em Recuperação:");
        for (Estudante estudante : getEstudantesEmRecuperacao()) {
            System.out.println("Nome: " + estudante.getNome() + " - Situação: " + estudante.getSituacao());
        }
    }

    // Método para exibir lista de estudantes aprovados
    public void exibirEstudantesAprovados() {
        System.out.println("\nEstudantes Aprovados:");
        for (Estudante estudante : getEstudantesAprovados()) {
            System.out.println("Nome: " + estudante.getNome() + " - Situação: " + estudante.getSituacao());
        }
    }

    // Método para exibir a lista final pós-recuperação
    public void exibirListaFinal() {
        System.out.println("\nLista Final (Pós-Recuperação):");
        for (Estudante estudante : getEstudantesFinal()) {
            System.out.println("Nome: " + estudante.getNome() + " - Situação: " + estudante.getSituacao());
        }
    }

    // Método para adicionar um log de alteração de notas
    public void adicionarLogAlteracaoNotas(Estudante estudante, double[] novasNotas) {
        log.add("Notas alteradas para o estudante " + estudante.getNome() + ": " + estudante.getNotas() + " -> Novas Notas: " + novasNotas);
    }

    // Exibir o log de todas as ações realizadas
    public void exibirLog() {
        System.out.println("\nLog de Ações:");
        for (String entry : log) {
            System.out.println(entry);
        }
    }
}
