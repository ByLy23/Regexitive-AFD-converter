/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author byron
 */
public class main {
    public static void main(String[] args){
        interprete("prueba.txt");
        try{
            new Inicio().setVisible(true);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    private static void interprete(String path){
        Analizador.Sintactico scanner;
        Analizador.Lexico scn;
        try {
            scn=new Analizador.Lexico(new BufferedReader(new FileReader(path)));
            scanner=  new Analizador.Sintactico(scn);
            scanner.parse();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: "+ex);
        }
    }
}
