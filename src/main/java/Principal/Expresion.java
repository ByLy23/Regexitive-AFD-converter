/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
    private Nodo rootThompson;
    private String graficaThompson;
    private int contador=0;

    public String getGraficaThompson() {
        return graficaThompson;
    }

    public void setGraficaThompson(String graficaThompson) {
        this.graficaThompson = graficaThompson;
    }

    public ArrayList<Transicion> getTablaTransicion() {
        return tablaTransicion;
    }

    public void setTablaTransicion(ArrayList<Transicion> tablaTransicion) {
        this.tablaTransicion = tablaTransicion;
    }

    public Nodo getRootThompson() {
        return rootThompson;
    }

    public void setRootThompson(Nodo rootThompson) {
        this.rootThompson = rootThompson;
    }

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
    public void generarArbol() throws IOException{
        System.out.println("Generando");
        listaNodos.add(0, new Nodo("\"#\"","LEXEMA",true));//simbolo de finalizacion
        listaNodos.add(0, new Nodo(".","CONCA"));//concatenacion final
        Stack<Nodo> pilaN= new Stack<>();//pila para lexemas
        Stack<Nodo> pilaT= new Stack<>();//pila para Thompson
        Nodo raiz;//donde se va a depositar todos los contactos del arbol
        int numero=0;
        int temp=0;
        numero = listaNodos.stream().filter((listaNodo) -> (listaNodo.getTipo().equals("LEXEMA"))).map((_item) -> 1)
                .reduce(numero, Integer::sum);
        for(Nodo listaNodo: listaNodos){
            if(listaNodo.getTipo().equals("LEXEMA")){
                listaNodo.setNumero(numero);
                listaNodo.getSiguientes().add(numero);
                listaNodo.getUltimos().add(numero);
                listaSiguientes.add(new Siguiente(listaNodo.getLexema(), numero));
            numero--;
            }
            pilaN.push(listaNodo);
            temp++;
            if(temp>2)
                pilaT.push(listaNodo);
        }
        raiz= anidarNodos(pilaN);
        this.graficaThompson= anidarThompson(pilaT);
        this.root=raiz;
        //graficar tabla de siguientes
        //crea tabla de transiciones
       this.tablaTransicion=generarTabla(root, listaSiguientes);
       //tabla de transicion es una lista de transiciones 
       //graficar todo
       graficar(this.root,this.graficaThompson,this.listaSiguientes,this.tablaTransicion);
    }
    private void graficar(Nodo raiz, String thompson, ArrayList<Siguiente> listaSigs,ArrayList<Transicion> tablaTransicion) throws IOException{
        graficarArbol(raiz);
        graficarThompson(thompson);
        graficarListaSigs(listaSigs);
        System.out.println(listStrings);
        graficarTransicion(tablaTransicion);
        graficarAFD(tablaTransicion);
        //crear grafo de arbol
        contenidoArbol="digraph Arbol{\n"+cuerpoArbol+"\n}";
        try (FileWriter file = new FileWriter("Dot/Arbol"+main.principio.cont+".dot")) {
            PrintWriter impresion= new PrintWriter(file);
            impresion.println(contenidoArbol);
        }
            String comando= "dot -Tpng Dot/Arbol"+main.principio.cont+".dot -o ARBOLES_201700733/Arbol"+main.principio.cont+".png -Gcharset=latin1";
            Runtime rt= Runtime.getRuntime();
            rt.exec(comando);
            
        /*
         FileWriter file= new FileWriter("bTree.dot");
            file.close();
            String comando= "dot -Tjpg bTree.dot -o bTree.jpg -Gcharset=latin1";
            Runtime rt= Runtime.getRuntime();
            */
        //hacer metodo para graficar que no me acuerdo equis de
        //crear grafo de thompson
        //crear grafo de listaSiginetes
        //crear grafo de tablaTrabsicion
        //crear grafo de AFD
        main.principio.cont++;
    }
    String contenidoArbol="";
    String cuerpoArbol="";
    private void graficarArbol(Nodo raiz){
       //
       if(raiz!=null){
       graficarArbol(raiz.getIzquierdo());
       //mostrar en graphviz
       cuerpoArbol+=raiz.hashCode()+"[shape=circle label=\""+raiz.getLexema().replaceAll("[\"{}]", "")+
               "\nNumero: "+raiz.getNumero()+"\nSiguientes: "+
               raiz.getSiguientes().toString()+"\nUltimos: "
               +raiz.getUltimos().toString()+
               "\nAnulable?: "+raiz.isAnulable()+"\"];\n";
       if(raiz.getIzquierdo()!=null)
           cuerpoArbol+=raiz.hashCode()+" -> "+raiz.getIzquierdo().hashCode()+"\n";
       if(raiz.getDerecho()!=null)
           cuerpoArbol+=raiz.hashCode()+" -> "+raiz.getDerecho().hashCode()+"\n";
        graficarArbol(raiz.getDerecho());
       }
    }
    String contenidoThompson="";
    private void graficarThompson(String thompson) throws IOException{
        contenidoThompson="digraph Thompson{\n"+thompson+"\n}";
        //aca hacer metodo de llamar que ahorita lo traigo equis de
        System.out.println(contenidoThompson);
        
        try (FileWriter file = new FileWriter("Dot/Thompson"+main.principio.cont+".dot")) {
            PrintWriter impresion= new PrintWriter(file);
            impresion.println(contenidoThompson);
        }
            String comando= "dot -Tpng Dot/Thompson"+main.principio.cont+".dot -o AFND_201700733/Thompson"+main.principio.cont+".png -Gcharset=latin1";
            Runtime rt= Runtime.getRuntime();
            rt.exec(comando);
    }
    String cuerpoListaSigs="";
    String listStrings="";
    private void graficarListaSigs(ArrayList<Siguiente> listaSigs) throws IOException{
         cuerpoListaSigs+="cabeza[label=\"{Lexema | Estado | Siguientes}";
            listaSigs.stream().map((var) -> {
                cuerpoListaSigs+="| {"+var.getLexema().replaceAll("[\"{}]", "")+" |"+var.getEstado()+"|{";
            return var;
        }).map((var) -> {
            var.getSiguientes().forEach((sig) -> {
                cuerpoListaSigs+=sig;
                });
            return var;
        }).map((_item) -> {
            return _item;
        }).forEachOrdered((_item) -> {
            cuerpoListaSigs+="}}";
        });
            cuerpoListaSigs+="\"];\n";
            listStrings="digraph ListaSiguientes{\nrankdir=LR\n" +
"node[shape= record];\n"+cuerpoListaSigs+"\n}";
            try (FileWriter file = new FileWriter("Dot/ListaSig"+main.principio.cont+".dot")) {
            PrintWriter impresion= new PrintWriter(file);
            impresion.println(listStrings);
        }
            String comando= "dot -Tpng Dot/ListaSig"+main.principio.cont+".dot -o SIGUIENTES_201700733/ListaSig"+main.principio.cont+".png -Gcharset=latin1";
            Runtime rt= Runtime.getRuntime();
            rt.exec(comando);
    }
    
    
    String cuerpoTrans="";
    String todoTrans="";
    private void graficarTransicion(ArrayList<Transicion> tablaTransicion) throws IOException{
        cuerpoTrans+="Trans[label=\"{Estado";
        for(Transicion trans: tablaTransicion){
            trans.getListaTrancisiones().forEach((traans) -> {
                cuerpoTrans+="|"+traans.getNombreTerminal().replaceAll("[\"{}]", "");
            });
           cuerpoTrans+="}";
           break;
        }
        for(Transicion trans:tablaTransicion){
            if(trans.isAceptacion())
                 cuerpoTrans+="|{*"+trans.getNombreEstado()+
                    "\n"+trans.getListaEstados().toString();
            else
                cuerpoTrans+="|{"+trans.getNombreEstado()+
                    "\n"+trans.getListaEstados().toString();
            for(Transicion traans:trans.getListaTrancisiones()){
                cuerpoTrans+="|"+traans.getNombreEstado()+"\n"+traans.getListaEstados().toString();
            }
            cuerpoTrans+="}";
        }
        cuerpoTrans+="\"];\n";
        todoTrans="digraph Transiciones{\nrankdir=LR\n" +
"node[shape= record];\n"+cuerpoTrans+"\n}";
        System.out.println(todoTrans);
        try (FileWriter file = new FileWriter("Dot/Transicion"+main.principio.cont+".dot")) {
            PrintWriter impresion= new PrintWriter(file);
            impresion.println(todoTrans);
        }
            String comando= "dot -Tpng Dot/Transicion"+main.principio.cont+".dot -o TRANSICIONES_201700733/Transicion"+main.principio.cont+".png -Gcharset=latin1";
            Runtime rt= Runtime.getRuntime();
            rt.exec(comando);
    }
    String todoAFD="";
    String cuerpoAFD="";
    private void graficarAFD(ArrayList<Transicion> tablaTransicion) throws IOException{
        for(Transicion trans:tablaTransicion){
            cuerpoAFD+=trans.getNombreEstado()+"[label=\""+trans.getNombreEstado()
                    +"\"";
            if(trans.isAceptacion())
                cuerpoAFD+=" shape=doublecircle];\n";
            else
                cuerpoAFD+=" shape=circle];\n";
            for(Transicion traans: trans.getListaTrancisiones()){
                if(!traans.getNombreEstado().equals(""))
                cuerpoAFD+=trans.getNombreEstado()+" -> "+traans.getNombreEstado()+"[label=\""+traans.getNombreTerminal().replaceAll("[\"{}]", "")+"\"];\n";
            }
        }
        todoAFD="digraph AFD{\n"+cuerpoAFD+"\n}";
        System.out.println(todoAFD);
        try (FileWriter file = new FileWriter("Dot/AFD"+main.principio.cont+".dot")) {
            PrintWriter impresion= new PrintWriter(file);
            impresion.println(todoAFD);
        }
            String comando= "dot -Tpng Dot/AFD"+main.principio.cont+".dot -o AFD_201700733/AFD"+main.principio.cont+".png -Gcharset=latin1";
            Runtime rt= Runtime.getRuntime();
            rt.exec(comando);
    }
    private String anidarThompson(Stack<Nodo> pila){
        Thompson primero;
        String cuerpoThompson="";
        Thompson segundo;
        Thompson auxt;
        Stack<Thompson> auxThompson= new Stack<>();
        while(pila.size()>0){
             Nodo aux= pila.pop();
            switch (aux.getTipo()) {
                case "CONCA":
                    primero=auxThompson.pop();
                    segundo=auxThompson.pop();
                    auxt=concatenacion(primero,segundo,this.contador);
                    cuerpoThompson+=auxt.getGrafo();
                    auxThompson.push(auxt);
                    break;
                case "CERRADKLN":
                    primero=auxThompson.pop();
                    auxt=cerraduraKleene(primero,this.contador);
                    cuerpoThompson+=auxt.getGrafo();
                    auxThompson.push(auxt);
                    break;
                case "DISYUNC":
                    primero=auxThompson.pop();
                    segundo=auxThompson.pop();
                    auxt=disyuncion(primero,segundo,this.contador);
                    cuerpoThompson+=auxt.getGrafo();
                    auxThompson.push(auxt);
                    break;
                case "CERRADPOS":
                    primero=auxThompson.pop();
                    auxt=cerraduraPositiva(primero,this.contador);
                    cuerpoThompson+=auxt.getGrafo();
                    auxThompson.push(auxt);
                    break;
                case "INTERROG":
                    primero=auxThompson.pop();
                    auxt=interrogacion(primero,this.contador);
                    cuerpoThompson+=auxt.getGrafo();
                    auxThompson.push(auxt);
                    break;
                default:
                    auxt=nuevaHoja(aux.getLexema(),this.contador);
                    cuerpoThompson+=auxt.getGrafo();
                    auxThompson.push(auxt);
                    break;
            }
            
        }
        return cuerpoThompson;
    }
    private Thompson concatenacion(Thompson primero, Thompson segundo, int contador){
        String cadena="";
        String inicio=primero.getInicio();
        String fin=segundo.getFin();
        cadena+=primero.getFin()+" -> "+segundo.getInicio()+" [label=\"epsilon\"];\n";
        return new Thompson(cadena,inicio,fin);
    }
    private Thompson disyuncion(Thompson primero, Thompson segundo, int contador){
        String cadena="";
        String inicio="S"+contador;
        contador++;
        String fin="S"+contador;
        contador++;
        this.contador=contador;
        cadena+=inicio+"[label=\""+inicio+"\"];\n"; 
        cadena+= fin+"[label=\""+fin+"\"];\n";
        cadena+=inicio+" -> "+primero.getInicio()+" [label=\"epsilon\"];\n";
        cadena+=inicio+" -> "+segundo.getInicio()+" [label=\"epsilon\"];\n";
        cadena+=primero.getFin()+" -> "+fin+" [label=\"epsilon\"];\n";
        cadena+=segundo.getFin()+" -> "+fin+" [label=\"epsilon\"];\n";
        return new Thompson(cadena,inicio,fin);
    }
     private Thompson interrogacion(Thompson primero, int contador){
        String cadena="";
        String inicio="S"+contador;
        contador++;
        String fin="S"+contador;
        contador++;
        this.contador=contador;
        cadena+=inicio+"[label=\""+inicio+"\"];\n"; 
        cadena+= fin+"[label=\""+fin+"\"];\n";
        cadena+=inicio+" -> "+primero.getInicio()+" [label=\"epsilon\"];\n";
        cadena+=inicio+" -> "+fin+" [label=\"epsilon\"];\n";
        cadena+=primero.getFin()+" -> "+fin+" [label=\"epsilon\"];\n";
        return new Thompson(cadena,inicio,fin);
    }
    private Thompson cerraduraKleene(Thompson primero, int contador){
        String cadena="";
        String inicio="S"+contador;
        contador++;
        String fin="S"+contador;
        contador++;
        this.contador=contador;
        cadena+=inicio+"[label=\""+inicio+"\"];\n"; 
        cadena+= fin+"[label=\""+fin+"\"];\n";
        cadena+=inicio+" -> "+primero.getInicio()+" [label=\"epsilon\"];\n";
        cadena+=inicio+" -> "+fin+" [label=\"epsilon\"];\n";
        cadena+=primero.getFin()+" -> "+primero.getInicio()+" [label=\"epsilon\"];\n";
        cadena+=primero.getFin()+" -> "+fin+" [label=\"epsilon\"];\n";
        return new Thompson(cadena,inicio,fin);
    }
     private Thompson cerraduraPositiva(Thompson primero, int contador){
        String cadena="";
        String inicio="S"+contador;
        contador++;
        String fin="S"+contador;
        contador++;
        this.contador=contador;
        cadena+=inicio+"[label=\""+inicio+"\"];\n"; 
        cadena+= fin+"[label=\""+fin+"\"];\n";
        cadena+=inicio+" -> "+primero.getInicio()+" [label=\"epsilon\"];\n";
        cadena+=primero.getFin()+" -> "+fin+" [label=\"epsilon\"];\n";
        cadena+=primero.getFin()+" -> "+primero.getInicio()+" [label=\"epsilon\"];\n";
        return new Thompson(cadena,inicio,fin);
    }
    private Thompson nuevaHoja(String lexema, int contador){
        String cadena="";
        String inicio="S"+contador;
        contador++;
        String fin="S"+contador;
        contador++;
        cadena+= inicio+"[label=\""+inicio+"\"];\n";
        cadena+= fin+"[label=\""+fin+"\"];\n";
        cadena+= inicio+" -> "+fin+" [label=\""+lexema.replaceAll("[\"{}]", "")+"\"];\n";
       this.contador=contador;
        return new Thompson(cadena, inicio, fin);
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
               //inicio asignacion nombres
               for (int j = 0; j < principal.get(i).getListaTrancisiones().size(); j++) {
                   Transicion trans= principal.get(i).getListaTrancisiones().get(j);
                   if(trans.getListaEstados().size()>0){
                       for (int k = 0; k < principal.size(); k++) {
                           Transicion otra= principal.get(k);
                           if(existeTransicion(trans.getListaEstados(), otra.getListaEstados())){
                               principal.get(i).getListaTrancisiones().get(j).setNombreEstado(otra.getNombreEstado());
                           }
                       }
                   }
               }
               //fin asignacion nombres
               //compare con cada una para abajo ya que estan todas xd
               System.out.println("ayudaa");
           }
           principal.get(i).setVisitado(true);
        }
        System.out.println("fin");
        return principal;
    }
    private boolean existeTransicion(ArrayList<Integer> principal, ArrayList<Integer> secundario){
        if( principal==null || secundario==null) return true;
        if(principal.size()!=secundario.size()) return false;
        Collections.sort(principal);
        Collections.sort(secundario);
        return principal.equals(secundario);
    }
    private void agregarSiguiente(ArrayList<Integer> numero,ArrayList<Integer> siguiente){
        numero.forEach((n) -> {
            listaSiguientes.stream().filter((sig) -> (n==sig.getEstado())).forEachOrdered((sig) -> {
                sig.getSiguientes().addAll(siguiente);
            });
        });
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