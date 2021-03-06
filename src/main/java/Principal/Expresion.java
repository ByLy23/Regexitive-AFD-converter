/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        listaNodos.add(0, new Nodo(".","CONCA"));//concatenacion final
        Stack<Nodo> pilaN= new Stack<>();//pila para lexemas
        Stack<Nodo> aux= new Stack<>();//pila auxiliar para colocar todos los valroes
        Nodo raiz;//donde se va a depositar todos los contactos del arbol
        int numero=0;
        for (Nodo listaNodo : listaNodos) {
            if(listaNodo.getTipo().equals("LEXEMA"))
                numero++;
        }
        for(Nodo listaNodo: listaNodos){
            if(listaNodo.getTipo().equals("LEXEMA")){
                listaNodo.setNumero(numero);
                listaNodo.getSiguientes().add(numero);
                listaNodo.getUltimos().add(numero);
                listaSiguientes.add(new Siguiente(listaNodo.getLexema(), numero));
            numero--;
            }
            aux.push(listaNodo);
        }
        pilaN=aux;
        raiz= anidarNodos(pilaN);
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
        int aceptacion= raiz.getDerecho().getNumero();
        Transicion primeraTransicion= new Transicion(nombreEstado+iterador,"",raiz.getSiguientes());
        principal.add(primeraTransicion);
        for (int i = 0; i < principal.size(); i++) {
           if(!principal.get(i).isVisitado()){
               //colocar aceptacion a la transicion
               if(principal.get(i).getListaEstados().contains(aceptacion))
                   principal.get(i).setAceptacion(true);
               //fin de colocar aceptacion
               //agregar todos los lexemas a esto
               for (int prim = 0; prim < listaSiguientes.size(); prim++) {
                   String nombreLista= listaSiguientes.get(prim).getLexema();
                   if(principal.get(i).getListaTrancisiones().isEmpty()){
                       principal.get(i).getListaTrancisiones().add(new Transicion(nombreLista));
                   }else{
                       boolean bandera=true;
                   for (int lex = 0; lex < principal.get(i).getListaTrancisiones().size(); lex++) {
                       String nombreTrans= principal.get(i).getListaTrancisiones().get(lex).getNombreTerminal();
                       if(nombreLista.equals(nombreTrans)){
                           bandera=false;
                       }
                   }  
                   if(bandera)
                    principal.get(i).getListaTrancisiones().add(new Transicion(nombreLista));
                }
               }
               //fin de agregar lexemas a el conjutno, ya con esto solo verifico los estados en vez de crear nuevos
               //agregando estados a la lista de las transiciones
               for (int j = 0; j < principal.get(i).getListaEstados().size(); j++) {//revisar cada uno de los estados de la lista de el principal
                   int sigo=principal.get(i).getListaEstados().get(j);//asigna ese numero a una variable
                   for (int sig = 0; sig < listaSiguientes.size(); sig++) {//empieza a revisar en la lista de siguientes
                       int lisS= listaSiguientes.get(sig).getEstado();//asigna el valor de la lista en una variable
                       Siguiente auxS= listaSiguientes.get(sig);//guardo ese siguiente para tener valores mas rapido
                       if(sigo==lisS){//comparo el estado de la lista de siguientes con el de la lista de estados del principal
                           for (int k = 0; k < principal.get(i).getListaTrancisiones().size(); k++) {//si son iguales recorro las transiciones
                               Transicion trans= principal.get(i).getListaTrancisiones().get(k);//empiezo a buscar el nombre de la transicion
                               if(trans.getNombreTerminal().equals(auxS.getLexema())){//si el nombre es igual a la del siguiente ingreso aca
                                   for (int l = 0; l < auxS.getSiguientes().size(); l++) {//empiezo a recorrer los estados de la lista de siguientes
                                       if(!trans.getListaEstados().contains(auxS.getSiguientes().get(l)))//si algun estado no se encuentra ahi lo agrega de lo contrario no
                                           principal.get(i).getListaTrancisiones().get(k).getListaEstados().add(auxS.getSiguientes().get(l));
                                   }
                               }
                           }
                       }
                   }
               }
               //fin de agregar estados
               
               //inicio de asignacion de estados
               for (int j = 0; j < principal.get(i).getListaTrancisiones().size(); j++) {
                   boolean bandera=true;
                   Transicion trans= principal.get(i).getListaTrancisiones().get(j);//tomo la transicion de este estado para comparar
                   if(trans.getListaEstados().size()>0){
                   for (int k = 0; k < principal.size(); k++) {//ahora reviso en la principal si existe este estado
                       Transicion otra= principal.get(k);
                       if(existeTransicion(trans.getListaEstados(), otra.getListaEstados())){
                           bandera=false;
                       }
                   }
                   if(bandera){
                    iterador++;
                    Transicion otraTrans= new Transicion(nombreEstado+iterador,"",trans.getListaEstados());
                    principal.add(otraTrans);
                   }
               }
               }
               //fin asignacion de estados
               
               System.out.println("ayudaa");
           }
           principal.get(i).setVisitado(true);
        }
        System.out.println("fin");
        return null;
    }
    private boolean existeTransicion(ArrayList<Integer> principal, ArrayList<Integer> secundario){
        if( principal==null || secundario==null) return true;
        if(principal.size()!=secundario.size()) return false;
        Collections.sort(principal);
        Collections.sort(secundario);
        return principal.equals(secundario);
    }
    private void agregarSiguiente(ArrayList<Integer> numero,ArrayList<Integer> siguiente){
       for(int n: numero){
           for(Siguiente sig: listaSiguientes){
               if(n==sig.getEstado())
                   sig.getSiguientes().addAll(siguiente);
           }
       }
    }
    private Nodo anidarNodos(Stack<Nodo> pila){
        Nodo raiz;
        Stack<Nodo> auxPila=new Stack<>();
        while(pila.size()>0){
            Nodo aux= pila.pop();
                Nodo izquierdo;
                Nodo derecho;
            switch (aux.getTipo()) {
                case "CONCA":
                    derecho=auxPila.pop();
                    izquierdo=auxPila.pop();
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
                    auxPila.push(aux);
                    break;
                case "CERRADKLN":
                    derecho=auxPila.pop();
                    aux.setDerecho(derecho);
                    aux.setAnulable(true);
                    //asignacion siguientes
                    aux.getSiguientes().addAll(derecho.getSiguientes());
                    //asignacion ultimos
                    aux.getUltimos().addAll(derecho.getUltimos());
                    //asinacion de siguientes en tabla de siguientes
                    agregarSiguiente(derecho.getUltimos(),derecho.getSiguientes());
                    auxPila.push(aux);//ver que pasa xD
                    break;
                case "DISYUNC":
                    derecho=auxPila.pop();
                    izquierdo=auxPila.pop();
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
                    auxPila.push(aux);
                    break;
                case "CERRADPOS":
                    derecho=auxPila.pop();
                    aux.setDerecho(derecho);
                    if (derecho.isAnulable())//coloco si es anulable el izq, de lo contrario es falso
                        aux.setAnulable(true);
                    //asignacion siguientes
                    aux.getSiguientes().addAll(derecho.getSiguientes());
                    //asignacion ultimos
                    aux.getUltimos().addAll(derecho.getUltimos());
                    //asinacion de siguientes en tabla de siguientes
                    agregarSiguiente(derecho.getUltimos(),derecho.getSiguientes());
                    auxPila.push(aux);
                    break;
                case "INTERROG":
                    derecho=auxPila.pop();
                    aux.setDerecho(derecho);
                    aux.setAnulable(true);
                    //asignacion siguientes
                    aux.getSiguientes().addAll(derecho.getSiguientes());
                    //asignacion ultimos
                    aux.getUltimos().addAll(derecho.getUltimos());
                    auxPila.push(aux);
                    break;
                default:
                    auxPila.push(aux);
                    break;
            }
        }
        raiz=auxPila.pop();
        return raiz;
    }
}