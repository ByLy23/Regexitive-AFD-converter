/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author byron
 */
public class Expresion {
    private String nombreExpresion;
    private ArrayList<Nodo> listaNodos;
    private Arbol arbolExpresiones;

    public Expresion(String nombreExpresion, ArrayList<Nodo> listaNodos) {
        this.nombreExpresion = nombreExpresion;
        this.listaNodos = listaNodos;
    }
    

    public String getNombreExpresion() {
        return nombreExpresion;
    }

    public void setNombreExpresion(String nombreExpresion) {
        this.nombreExpresion = nombreExpresion;
    }

    public ArrayList<Nodo> getListaNodos() {
        return listaNodos;
    }

    public void setListaNodos(ArrayList<Nodo> listaNodos) {
        this.listaNodos = listaNodos;
    }

    public Arbol getArbolExpresiones() {
        return arbolExpresiones;
    }

    public void setArbolExpresiones(Arbol arbolExpresiones) {
        this.arbolExpresiones = arbolExpresiones;
    }
    public void generarArbol(){
        System.out.println("Generando");
        listaNodos.add(0, new Nodo("\"#\"","LEXEMA"));//simbolo de finalizacion
        listaNodos.add(listaNodos.size(), new Nodo(".","CONCA"));//concatenacion final
        Stack<Nodo> pilaN= new Stack<>();//pila para lexemas
        Queue<Nodo> colaExp= new LinkedList<>();//cola para expresiones
        Stack<Nodo> aux= new Stack<>();//pila auxiliar para colocar todos los valroes
        Nodo raiz;//donde se va a depositar todos los contactos del arbol
        for (Nodo listaNodo : listaNodos) {
            if(listaNodo.getTipo().equals("LEXEMA"))
                pilaN.push(listaNodo);
            else{
                colaExp.add(listaNodo);
            }
            
        }
        int numero= pilaN.size();
        for(Nodo listaNodo: listaNodos){
            if(listaNodo.getTipo().equals("LEXEMA")){
                listaNodo.setNumero(numero);
                listaNodo.getSiguientes().add(numero);
                listaNodo.getUltimos().add(numero);
                aux.push(listaNodo);
                numero--;
            }
        }
        pilaN=aux;
        raiz= anidarNodos(pilaN,colaExp);
        System.out.println(raiz);
    }
    private Nodo anidarNodos(Stack<Nodo> pila,Queue<Nodo> cola){
        Nodo raiz;
        ArrayList<Nodo> fd;
        while(cola.size()>0){
            Nodo aux= cola.poll();
                Nodo izquierdo;
                Nodo derecho;
            switch (aux.getTipo()) {
                case "CONCA":
                    izquierdo=pila.pop();
                    derecho=pila.pop();
                    aux.setIzquierdo(izquierdo);
                    aux.setDerecho(derecho);
                    if (izquierdo.isAnulable() && derecho.isAnulable())//coloco si es anulable el izq y el derecho, de lo contrario es falso
                        aux.setAnulable(true);
                    //asignacion siguientes
                    if(izquierdo.isAnulable())
                        aux.getSiguientes().addAll(derecho.getSiguientes());
                    aux.getSiguientes().addAll(izquierdo.getSiguientes());
                    //asignacion ultimos
                    if(derecho.isAnulable())
                        aux.getUltimos().addAll(izquierdo.getUltimos());
                    aux.getUltimos().addAll(derecho.getUltimos());
                    
                    pila.push(aux);
                    break;
                case "CERRADKLN":
                    izquierdo=pila.pop();
                    aux.setIzquierdo(izquierdo);
                    aux.setAnulable(true);
                    pila.push(aux);
                    //asignacion siguientes
                    aux.getSiguientes().addAll(izquierdo.getSiguientes());
                    //asignacion ultimos
                    aux.getUltimos().addAll(izquierdo.getUltimos());
                    break;
                case "DISYUNC":
                    izquierdo=pila.pop();
                    derecho=pila.pop();
                    aux.setIzquierdo(izquierdo);
                    aux.setDerecho(derecho);
                    if (izquierdo.isAnulable() || derecho.isAnulable())//coloco si es anulable el izq o el derecho, de lo contrario es falso
                        aux.setAnulable(true);
                    //asignacion siguientes
                    aux.getSiguientes().addAll(izquierdo.getSiguientes());
                    aux.getSiguientes().addAll(derecho.getSiguientes());
                    //asignacion ultimos
                    aux.getUltimos().addAll(izquierdo.getUltimos());
                    aux.getUltimos().addAll(derecho.getUltimos());
                    pila.push(aux);
                    break;
                case "CERRADPOS":
                    izquierdo=pila.pop();
                    aux.setIzquierdo(izquierdo);
                    if (izquierdo.isAnulable())//coloco si es anulable el izq, de lo contrario es falso
                        aux.setAnulable(true);
                    //asignacion siguientes
                    aux.getSiguientes().addAll(izquierdo.getSiguientes());
                    //asignacion ultimos
                    aux.getUltimos().addAll(izquierdo.getUltimos());
                    pila.push(aux);
                    break;
                case "INTERROG":
                    izquierdo=pila.pop();
                    aux.setIzquierdo(izquierdo);
                    aux.setAnulable(true);
                    //asignacion siguientes
                    aux.getSiguientes().addAll(izquierdo.getSiguientes());
                    //asignacion ultimos
                    aux.getUltimos().addAll(izquierdo.getUltimos());
                    pila.push(aux);
                    break;
                default:
                    break;
            }
        }
        raiz=pila.pop();
        return raiz;
    }
}