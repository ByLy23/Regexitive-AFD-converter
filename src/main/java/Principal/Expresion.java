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
    private ArrayList<Siguiente> listaSiguientes;
    private ArrayList<Transicion> tablaTransicion;

    public ArrayList<Siguiente> getListaSiguientes() {
        return listaSiguientes;
    }

    public void setListaSiguientes(ArrayList<Siguiente> listaSiguientes) {
        this.listaSiguientes = listaSiguientes;
    }
    private Nodo root;

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }
    

    public Expresion(String nombreExpresion, ArrayList<Nodo> listaNodos) {
        this.nombreExpresion = nombreExpresion;
        this.listaNodos = listaNodos;
        listaSiguientes=new ArrayList<>();
        tablaTransicion= new ArrayList<>();
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
    public void generarArbol(){
        Transicion auxT= new Transicion();
        System.out.println("Generando");
        listaNodos.add(0, new Nodo("\"#\"","LEXEMA",true));//simbolo de finalizacion
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
        int i=0;
        for(Nodo listaNodo: listaNodos){
            
            if(listaNodo.getTipo().equals("LEXEMA")){
                listaNodo.setNumero(numero);
                listaNodo.getSiguientes().add(numero);
                listaNodo.getUltimos().add(numero);
                listaSiguientes.add(new Siguiente(listaNodo.getLexema(), numero));
                aux.push(listaNodo);
                i++;
                numero--;
            }
        }
        pilaN=aux;
        raiz= anidarNodos(pilaN,colaExp);
         System.out.println(listaSiguientes);
        this.root=raiz;
        //graficar tabla de siguientes
        graficarSiguientes(listaSiguientes);
       this.tablaTransicion=generarTabla(root, listaSiguientes);
       //tabla de transicion es una lista de transiciones 
    }
    private void graficarSiguientes(ArrayList<Siguiente> siguientes){
            System.out.println("Lexema  |  Estado  |  Siguientes");
        for(Siguiente var: siguientes){
            System.out.print("| "+var.getLexema()+" | "+var.getEstado()+" | ");
            for(int sig: var.getSiguientes()){
                System.out.print(sig+", ");
            }
            System.out.println("|");
            System.out.println("-------------------------------------------");
        }
    }
    private ArrayList<Transicion> generarTabla(Nodo raiz, ArrayList<Siguiente> siguientes){
        ArrayList<Transicion> principal= new ArrayList<>();
        String nombreEstado="S";
        int iterador=0;
        Transicion primeraTransicion= new Transicion(nombreEstado+iterador,raiz.getSiguientes());
        principal.add(primeraTransicion);
        for (int i = 0; i < principal.size(); i++) {
            ArrayList<Integer> arrGuardar= new ArrayList<>();
           if(!principal.get(i).isVisitado()){
               for (int j = 0; j < principal.get(i).getListaEstados().size(); j++) {
                   int auxEstado= principal.get(i).getListaEstados().get(j);
                   Transicion nueva=new Transicion();
                   ArrayList<Integer> nuevaArr;
                   //busco en la tabla de siguientes
                   for (int sig = 0; sig < listaSiguientes.size(); sig++) {
                       if(auxEstado==listaSiguientes.get(sig).getEstado()){
                           nuevaArr=listaSiguientes.get(sig).getSiguientes();
                           nueva= new Transicion(listaSiguientes.get(sig).getLexema(), nuevaArr);
                           break;
                       }
                   }
                    if(principal.get(i).getListaTrancisiones().size()<=0){
                        principal.get(i).getListaTrancisiones().add(nueva);
                    }else{
                        //revisa los lexemas en los siguientes, si existe el lexema agrega los que trae
                        //sino esta el lexema crea uno nuevo
                    }
               }
              // if(principal.get(i).getListaTrancisiones().size()<=0){
                   
              // }
              //buscar primero el lexema en la lista, sino esta pues crear uno nuevo, sino se agrega y se revisa si lo contiene
              //if compareto arreglo de transiciones para abajo con la de los guardados, sino existe crea un nuevo estado, si existe solo le asigna la letra, comparando arreglos de numeros
             // principal.add(transicion(nombreEstado+iterador,arrGuardar))
           }
           principal.get(i).setVisitado(true);
        }
        return null;
    }
      /*  ArrayList<Transicion> aux=new ArrayList<>();
        int i=0;
        String nombreEstado= "S";
        aux.add(new Transicion(nombreEstado+""+i,raiz.getSiguientes()));//verificar uno por uno
        for(Transicion trans: aux){
            for(int itm: trans.getListatrancisiones()){
                if(itm==raiz.getDerecho().getNumero())
                    trans.setAceptacion(true);
                Siguiente aux1= buscarSig(itm);
            }
        }
        return aux;
    }
    private Siguiente buscarSig(int numero){
        Siguiente aux;
        ArrayList<Integer> auxI= new ArrayList<>();
        boolean seguir=false;
        String nombreLexema="";
        for(Siguiente list:listaSiguientes){
            
            if(numero==list.getEstado()){
                auxI.addAll(list.getSiguientes());
                if(!seguir){
                nombreLexema=list.getLexema();
                seguir=true;
                }
            }
        }
        aux= new Siguiente(nombreLexema, numero,auxI);
        return aux;
    }
    private Transicion buscar(ArrayList<Siguiente> obtener){
        return null;
    }*/
    private void agregarSiguiente(ArrayList<Integer> numero,ArrayList<Integer> siguiente){
       for(int n: numero){
           for(Siguiente sig: listaSiguientes){
               if(n==sig.getEstado())
                   sig.getSiguientes().addAll(siguiente);
           }
       }
    }
    private Nodo anidarNodos(Stack<Nodo> pila,Queue<Nodo> cola){
        Nodo raiz;
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
                    //asinacion de siguientes en tabla de siguientes
                    agregarSiguiente(izquierdo.getUltimos(),derecho.getSiguientes());
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
                    //asinacion de siguientes en tabla de siguientes
                    agregarSiguiente(izquierdo.getUltimos(),izquierdo.getSiguientes());
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
                    //asinacion de siguientes en tabla de siguientes
                    agregarSiguiente(izquierdo.getUltimos(),izquierdo.getSiguientes());
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