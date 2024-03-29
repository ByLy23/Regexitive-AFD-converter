/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author byron
 */
public class General {
    
    /*
    clase nodo que va a tener lista de siguientes, lista de ultimos, si es hoja, el lexema, el tipo
clase arbol que va a tener nodo izquierdo y derecho y que va a actuar como ramificacion
clase expresion que va a guardar el arbol, y el identificador de la expresion
clae conjunto que va a guardar el nombre del conjunto, la lista de conjuntos y ya creo xD
*/
    private  ArrayList<Token> listaTokens;
    private  ArrayList<Transicion> err;
    private  ArrayList<Expresion> listaExpresiones;
    private ArrayList<Errores> listaErrores;

    public ArrayList<Errores> getListaErrores() {
        return listaErrores;
    }

    public void setListaErrores(ArrayList<Errores> listaErrores) {
        this.listaErrores = listaErrores;
    }
    public int cont=0;
    public ArrayList<Token> getListaTokens() {
        return listaTokens;
    }

    public void setListaTokens(ArrayList<Token> listaTokens) {
        this.listaTokens = listaTokens;
    }

    public ArrayList<Transicion> getError() {
        return err;
    }

    public void setError(ArrayList<Transicion> error) {
        this.err = error;
    }
    
    public General(){
        listaTokens= new ArrayList<>();
        err=new ArrayList<>();
        listaExpresiones= new ArrayList<>();
        listaErrores= new ArrayList<>();
    }

    public ArrayList<Expresion> getListaExpresiones() {
        return listaExpresiones;
    }

    public void setListaExpresiones(ArrayList<Expresion> listaExpresiones) {
        this.listaExpresiones = listaExpresiones;
    }
    
    public void generarArbol() throws IOException{
        System.out.println("Estoy generandome awanta un casho");
        for(Expresion itm:listaExpresiones){
            System.out.println(itm.getNombreExpresion());
            itm.generarArbol();
        }
    }
    
}
