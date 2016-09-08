package automatapaq;

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
        String cadenaTest = "accccccccaaaaa"; //cadena de prueba
        char[] cadenaArray = cadenaTest.toCharArray(); //convierto la cadena a un array de caracteres

        estado currentState, //INICIALIZO LOS ESTADOS DEL AUTOMATA
                q0 = new estado('0', false, true),
                q1 = new estado('1', false, false),
                q2 = new estado('2', true, false), 
                q3 = new estado('3', true, false), 
                q4 = new estado('4', true, false), 
                q5 = new estado('5', true, false);
        
        //GENERO LA TABLA DE TRANSICIONES
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
        
        currentState = q0; //VARIABLE CURRENTSTATE PERMITE RECORRER LA TABLA DE TRANSICIONES
        for ( int i = 0; i < cadenaArray.length; i++ ) { //FOR PARA REVISAR LOS CARACTERES DE LA CADENA ESTADO POR ESTADO
            if(currentState.getMap().containsKey(cadenaArray[i])){//SI EL CARACTER ACTUAL DEL ARRAY ESTÁ EN LA TABLA DE TRANSICIONES DEL ESTADO ACTUAL
                System.out.println(currentState.saluda()); //EL ESTADO SE IMPRIME PARA INDICAR EL LUGAR
                currentState = currentState.getMap().get(cadenaArray[i]); //NOS MOVEMOS EN EL AUTOMATA
            }else{
                System.out.println("cadena no válida");
                break;
            }
        }
    }
}
