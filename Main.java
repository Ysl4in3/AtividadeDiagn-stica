package com.mycompany.atividadediagnostica2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yslaine
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
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
        }
    
}
