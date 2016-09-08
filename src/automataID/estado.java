/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automataID;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author acer_
 */
public class estado {
    public char nombre;
    private boolean estadoFinal;
    private boolean estadoInicial;
    private Map<Character, estado> transiciones;
    
    public estado(char nombre, boolean estadoFinal, boolean estadoInicial){
        this.nombre = nombre;
        this.estadoFinal = estadoFinal;
        this.estadoInicial = estadoInicial;
        transiciones = new HashMap<>();
    }
    public char getNombre(){
        return this.nombre;
    }
    public void setNombre(char nombre){
        this.nombre = nombre;
    }
    public String saluda(){
        if(this.estadoFinal)
            return "soy el estado "+this.nombre+" y soy un estado final";
        return "soy el estado "+this.nombre;
    }
    public void setEfinal(boolean efinal){
        this.estadoFinal = efinal;
    }
    public void setEinicial(boolean einicial){
        this.estadoInicial = einicial;
    }
    public boolean getEfinal(){
       return this.estadoFinal;
    }
    public boolean getEinicial(){
        return this.estadoInicial;
    }
    public Map<Character, estado> getMap(){
        return transiciones;
    }
    public boolean agregarTransicion(char caracter, estado state){
        this.transiciones.put(caracter, state);
        if(this.transiciones.get(caracter)==state)
            return true;
        return false;
    }
}
