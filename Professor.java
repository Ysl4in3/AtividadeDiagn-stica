package com.mycompany.atividadediagnostica2;

/**
 *
 * @author yslaine
 */
public class Professor {

    public Professor(String luis_Araujo, String string, String rua_K_Bairro_L, String _67890123, int par) {
    }
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

    
}
