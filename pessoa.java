package atividade02;
/**
 *
 * @author yslaine
 */
public class Pessoa implements IPrintable {

    protected String nome, cpf, endereco, telefone;

    public Pessoa(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void printInfo() {
        System.out.println(getClass().getSimpleName() + " " + nome + " - Cpf: " + cpf + " - End.: " + endereco + " - Tel.: " + telefone);
    }
}

