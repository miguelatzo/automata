/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automataID;

/**
 *
 * @author mike
 */
public class validacion {
    
    public static int validar(char x){    //el parametro x es el char del array que
      //*forzando x a int con (int)x*       conforma la cadena ingresada
        if((int)x == 59) //si x es igual a ';' 
            return 1;
        else if((int)x >= 48 && (int)x <= 57) //si x esta entre 0 y 9
            return 2;
        else if((int)x >= 97 && (int)x <= 122) //si x esta entre 'a' y 'z'
            return 3;
        else if((int)x == 61) //si x es una asignacion '='
            return 4;        
        else if((int)x == 32) //si es un espacio
            return 5;
        return 0;
    }
}
