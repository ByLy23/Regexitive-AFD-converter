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
public class Transicion {
    private String nombreEstado;
    private boolean visitado;
    private ArrayList<Integer> listatrancisiones;
    private boolean aceptacion;

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public ArrayList<Integer> getListatrancisiones() {
        return listatrancisiones;
    }

    public void setListatrancisiones(ArrayList<Integer> listatrancisiones) {
        this.listatrancisiones = listatrancisiones;
    }

    public boolean isAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(boolean aceptacion) {
        this.aceptacion = aceptacion;
    }

    public Transicion() {
        this.listatrancisiones= new ArrayList<>();
    }
    public Transicion generarTabla(int aceptacion, ArrayList<Integer> raiz, ArrayList<Siguiente> listaSigs){
        Transicion aux=null;
        return aux;
    }
}
