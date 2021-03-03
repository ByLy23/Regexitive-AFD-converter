/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;

/**
 *
 * @author byron
 */
public class Siguiente {

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Integer> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(ArrayList<Integer> siguientes) {
        this.siguientes = siguientes;
    }

    public Siguiente(String lexema, int estado) {
        this.lexema = lexema;
        this.estado = estado;
        this.siguientes= new ArrayList<>();
    }
    
    public Siguiente(String lexema, int estado,ArrayList<Integer> siguientes) {
        this.lexema = lexema;
        this.estado = estado;
        this.siguientes=siguientes;
    }
    
    
    private String lexema;
    private int estado;
    private ArrayList<Integer> siguientes;
    
}

