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
public class Nodo {
    private Nodo izquierdo;
    private Nodo derecho;    
    private ArrayList<Integer> siguientes;
    private ArrayList<Integer> ultimos;
    private String lexema;
    private String tipo;
    private boolean aceptacion;
    private boolean esHoja;
    private boolean anulable;

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }
    int numero;

    public Nodo(String lexema, String tipo) {
        this.lexema = lexema;
        this.tipo = tipo;
        this.anulable=false;
        this.siguientes= new ArrayList<>();
        this.ultimos= new ArrayList<>();
        this.esHoja=false;
        this.aceptacion=false;
        //verificar que tipo de lexema es para agregar un verdadero o falso en hoja
        //verificar que tipo de lexema es para asignar anulables, pero solo en los que si son, de lo contrario se hace ya cuando este el arbol armado
    }
    

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public ArrayList<Integer> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(ArrayList<Integer> siguientes) {
        this.siguientes = siguientes;
    }

    public ArrayList<Integer> getUltimos() {
        return ultimos;
    }

    public void setUltimos(ArrayList<Integer> ultimos) {
        this.ultimos = ultimos;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(boolean aceptacion) {
        this.aceptacion = aceptacion;
    }

    public boolean isEsHoja() {
        return esHoja;
    }

    public void setEsHoja(boolean esHoja) {
        this.esHoja = esHoja;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

/*
lista de siguientes
lista de ultimos
lexema
tipo de nodo
aceptacion
eshoja
numero
*/