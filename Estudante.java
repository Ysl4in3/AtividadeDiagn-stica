package com.mycompany.atividadediagnostica2;

/**
 *
 * @author yslaine
 */
public class Estudante {

    String nome;

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula, Curso cursoEngenharia) {
    }

    void setNotas(double[] notas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    class Estudante extends Pessoa {
    private String matricula;
    private Curso curso;
    private double[] notas = new double[3];
    private double notaRecuperacao = -1; // -1 indica que não foi atribuída
    private String situacao = "Sem Avaliação";

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula, Curso curso) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
        this.curso = curso;
    }

    public void setNotas(double[] notas) {
        System.arraycopy(notas, 0, this.notas, 0, notas.length);
        calcularSituacao();
    }

    public void setNotaRecuperacao(double nota) {
        this.notaRecuperacao = nota;
        calcularSituacaoFinal();
    }

    public double calcularMedia() {
        double media = (notas[0] + notas[1] + notas[2]) / 3;
        return media;
    }

    private void calcularSituacao() {
        double media = calcularMedia();
        if (media >= 7) situacao = "APROVADO";
        else if (media >= 2.5) situacao = "RECUPERAÇÃO";
        else situacao = "REPROVADO";
    }

    private void calcularSituacaoFinal() {
        if (notaRecuperacao != -1) {
            situacao = (notaRecuperacao >= 5) ? "APROVADO" : "REPROVADO";
        } else {
            situacao = "RECUPERAÇÃO (SN)";
        }
    }

    public String getSituacao() {
        return situacao;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" - Matrícula: " + matricula + " - Situação: " + situacao + " - Média: " + calcularMedia());
    }
}
    
}
