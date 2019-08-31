/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.exceptions;


public class HangmanException extends Exception{
    public static final String ARGUMENTOINVALIDO = "El valor ingresado como argumento no es valido";
    
    /**
     *
     * @param message
     */
    public HangmanException(String message){
        super(message);
    }
}
