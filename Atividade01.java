import java.util.*;

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

// Classe Coordenador (herda de Professor)
class Coordenador extends Professor {
    public Coordenador(String nome, String cpf, String endereco, String telefone, int siape) {
        super(nome, cpf, endereco, telefone, siape);
    }

    public void alterarNota(Estudante estudante, double[] novasNotas, List<String> log) {
        String logEntry = "Alteração de Nota - Aluno: " + estudante.nome + " | Notas anteriores: " + Arrays.toString(estudante.notas) +
                " | Novas Notas: " + Arrays.toString(novasNotas) + " | Alterado por Coordenador: " + nome;
        estudante.setNotas(novasNotas);
        log.add(logEntry);
    }
}

// Classe Curso
class Curso {
    private String nomeCurso;
    private int quantidadeSemestres;
    private Coordenador coordenador;

    public Curso(String nomeCurso, int quantidadeSemestres, Coordenador coordenador) {
        this.nomeCurso = nomeCurso;
        this.quantidadeSemestres = quantidadeSemestres;
        this.coordenador = coordenador;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public Coordenador getCoordenador() {
        return coordenador;
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

// Classe Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> log = new ArrayList<>();

        // Criando coordenador
        Coordenador coordenador = new Coordenador("Carlos Souza", "777.888.999-10", "Rua X, Bairro Y", "(11) 9876-5432", 30001);

        // Criando curso
        Curso cursoEngenharia = new Curso("Engenharia de Computação", 10, coordenador);

        // Criando professor e turma
        Professor professor1 = new Professor("Luis Araujo", "555.666.777-88", "Rua K, Bairro L", "(11) 6789-0123", 10001);
        Turma turma1 = new Turma("Turma A", cursoEngenharia, 1, professor1);

        // Cadastro de estudantes e atribuição de notas
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nCadastro do Estudante " + i);
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
            System.out.print("Digite as três notas do estudante: ");
            double[] notas = {scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()};
            scanner.nextLine(); // limpar o buffer
            estudante.setNotas(notas);
            turma1.addEstudante(estudante);
        }

        // Exibir informações e estatísticas da turma
        turma1.printTurmaInfo();
        turma1.exibirEstatisticas();

        // Adicionando nota de recuperação e exibindo lista final
        for (Estudante estudante : turma1.getEstudantesEmRecuperacao()) {
            System.out.print("\nDigite a nota de recuperação para " + estudante.nome + ": ");
            double notaRecuperacao = scanner.nextDouble();
            scanner.nextLine();
            estudante.setNotaRecuperacao(notaRecuperacao);
        }

        // Log de alteração de nota pelo coordenador
        turma1.getEstudantesEmRecuperacao().forEach(estudante -> {
            double[] novasNotas = {8.0, 7.5, 6.0};
            coordenador.alterarNota(estudante, novasNotas, log);
        });

        // Exibir log
        System.out.println("\nLog de Alterações:");
        log.forEach(System.out::println);

        scanner.close();
