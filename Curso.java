package com.mycompany.atividade02;

public class Curso {

    private String nomeCurso;
    private int quantidadeSemestres;
    private Coordenador coordenador;

    public Curso(String nomeCurso, int quantidadeSemestres, Coordenador coordenador) {
        this.nomeCurso = nomeCurso;
        this.quantidadeSemestres = quantidadeSemestres;
        this.coordenador = coordenador;
        
        // Vincula o curso ao coordenador, quando o curso é criado
        if (coordenador != null) {
            coordenador.setCurso(this);
        }
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    // Método para exibir informações do curso
    public void printInfo() {
        System.out.println("Curso: " + nomeCurso + " - Semestres: " + quantidadeSemestres);
        if (coordenador != null) {
            System.out.print("Coordenador: ");
            coordenador.printInfo(); // Exibe as informações do coordenador
        }
    }
}
