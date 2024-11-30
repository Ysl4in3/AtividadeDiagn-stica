/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.coordenador;

/**
 *
 * @author yslai
 */
public class Coordenador {

 // Vincula o curso ao coordenador, quando o curso é criado
        if (coordenador != null) {
            coordenador.setCurso(this);
        }
    }

    public String getNomeCurso() {
@@ -126,92 +134,102 @@
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
