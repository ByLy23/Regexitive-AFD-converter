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
    private String nombreTerminal;

    public String getNombreTerminal() {
        return nombreTerminal;
    }

    public void setNombreTerminal(String nombreTerminal) {
        this.nombreTerminal = nombreTerminal;
    }
    private boolean visitado;
    private ArrayList<Integer> listaEstados;
    private boolean aceptacion;
    private ArrayList<Transicion> listaTrancisiones;

    public ArrayList<Integer> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(ArrayList<Integer> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public ArrayList<Transicion> getListaTrancisiones() {
        return listaTrancisiones;
    }

    public void setListaTrancisiones(ArrayList<Transicion> listaTrancisiones) {
        this.listaTrancisiones = listaTrancisiones;
    }


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
        return listaEstados;
    }

    public void setListatrancisiones(ArrayList<Integer> listatrancisiones) {
        this.listaEstados = listatrancisiones;
    }

    public boolean isAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(boolean aceptacion) {
        this.aceptacion = aceptacion;
    }

    public Transicion() {
        this.listaEstados= new ArrayList<>();
    }
  public Transicion(String nombre, ArrayList<Integer> estados){
      this.nombreTerminal=nombre;
      this.listaEstados= estados;
      this.listaTrancisiones=new ArrayList<>();
    }
  public Transicion(String terminal){
      this.nombreTerminal=terminal;
      this.listaTrancisiones=new ArrayList<>();
      this.listaEstados=new ArrayList<>();
      this.nombreEstado="";
    }
  public Transicion(String nombreT,String nombre, ArrayList<Integer> estados){
      this.nombreTerminal=nombre;
      this.nombreEstado=nombreT;
      this.listaEstados= estados;
      this.listaTrancisiones=new ArrayList<>();
    }
}
