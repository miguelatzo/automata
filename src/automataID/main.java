package automataID;

import automataID.estado;
import static automataID.validacion.validar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer_
 */
public class main {
    public static void main(String[] args) {
        String cadenaTest = "int var = 4 ; "; //cadena de prueba
        char[] cadenaArray = cadenaTest.toCharArray(); //convierto la cadena a un array de caracteres
        String token = "";
        estado currentState, lastState, //INICIALIZO LOS ESTADOS DEL AUTOMATA
                q0 = new estado('0', false, true),
                q1 = new estado('1', false, false),
                q2 = new estado('2', false, false), 
                q3 = new estado('3', false, false), 
                q4 = new estado('4', false, false), 
                q5 = new estado('5', true, false);
        //GENERO LA TABLA DE TRANSICIONES
        q0.getMap().put('4', q1);//q0(=)->q1
        q0.getMap().put('3', q2);//q0(letra)->q2
        q0.getMap().put('2', q3);//q0(num)->q3
        q0.getMap().put('1', q4);//q0(delimitador)->q4
        q0.getMap().put('5', q0);//q0(espacio)->q0
        
        q1.getMap().put('5', q5);//q1(espacio)->q5
        
        q2.getMap().put('2', q2);//q2(num)->q2
        q2.getMap().put('3', q2);//q2(letra)->q2
        q2.getMap().put('5', q5);//q2(num)->q2
        
        q3.getMap().put('2', q3);//q2(num)->q2
        q3.getMap().put('5', q5);//q2(num)->q2

        q4.getMap().put('5', q5);//q1(espacio)->q1
        
        q5.getMap().put('1', q0);
        q5.getMap().put('2', q0);
        q5.getMap().put('3', q0);
        q5.getMap().put('4', q0);
        q5.getMap().put('5', q0);
        
        /*
        q0.getMap().put('a', q1);
        q0.getMap().put('b', q1);
        q1.getMap().put('a', q2);
        q1.getMap().put('c', q4);
        q2.getMap().put('b', q2);
        q3.getMap().put('a', q3);
        q4.getMap().put('a', q5);
        q4.getMap().put('c', q4);
        q5.getMap().put('a', q3);
        q5.getMap().put('b', q2);
        */
        currentState = q0; //VARIABLE CURRENTSTATE PERMITE RECORRER LA TABLA DE TRANSICIONES
        lastState = currentState;
        for ( int i = 0; i < cadenaArray.length; i++ ) { //FOR PARA REVISAR LOS CARACTERES DE LA CADENA ESTADO POR ESTADO
            
            char clave = (char)(validar(cadenaArray[i])+'0');
            if(currentState.getMap().containsKey(clave)){//SI EL CARACTER ACTUAL DEL ARRAY ESTÁ EN LA TABLA DE TRANSICIONES DEL ESTADO ACTUAL
                token += cadenaArray[i];
                System.out.println(currentState.saluda()); //EL ESTADO SE IMPRIME PARA INDICAR EL LUGAR
                if(clave == '5'){
                    System.out.println("token: "+token);
                    token = "";
                }
                lastState = currentState;
                currentState = currentState.getMap().get(clave); //NOS MOVEMOS EN EL AUTOMATA
            }else{
                System.out.println("cadena no válida");
                break;
            }
        }
    }
}
