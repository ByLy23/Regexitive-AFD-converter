/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author byron
 */
public class Thompson {
    private String grafo;
    private String inicio;
    private String fin;

    public Thompson(String grafo, String inicio, String fin) {
        this.grafo = grafo;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getGrafo() {
        return grafo;
    }

    public void setGrafo(String grafo) {
        this.grafo = grafo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
