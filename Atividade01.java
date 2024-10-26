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
public class Atividade01 {



// Interface para exibir dados
interface Printable {
    void printInfo();
}

// Classe abstrata Pessoa
abstract class Pessoa implements Printable {
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

// Classe Estudante
class Estudante extends Pessoa {
    private String matricula;
    private Curso curso;

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula, Curso curso) {
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

// Classe Professor
class Professor extends Pessoa {
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

// Classe Curso
class Curso {
    private String nomeCurso;
    private int quantidadeSemestres;

    public Curso(String nomeCurso, int quantidadeSemestres) {
        this.nomeCurso = nomeCurso;
        this.quantidadeSemestres = quantidadeSemestres;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }
}

// Classe Turma
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
}

// Classe Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando cursos
        Curso cursoEngenharia = new Curso("Engenharia de Computação", 10);

        // Criando professores
        Professor professor1 = new Professor("Luis Araujo", "555.666.777-88", "Rua K, Bairro L", "(11) 6789-0123", 10001);

        // Criando turma
        Turma turma1 = new Turma("Turma A", cursoEngenharia, 1, professor1);

        // Cadastro de estudantes
        System.out.println("Cadastro de Estudantes:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nEstudante " + i);
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();

            Estudante estudante = new Estudante(nome, cpf, endereco, telefone, matricula, cursoEngenharia);
            turma1.addEstudante(estudante);
        }

        // Exibindo informações da turma
        turma1.printTurmaInfo();

        scanner.close();
    }
}


