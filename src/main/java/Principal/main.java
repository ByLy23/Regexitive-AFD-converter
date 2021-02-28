/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author byron
 */
public class main {
    public static General principio;
    public static void main(String[] args){
        principio= new General();
        try{
            new Inicio().setVisible(true);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
