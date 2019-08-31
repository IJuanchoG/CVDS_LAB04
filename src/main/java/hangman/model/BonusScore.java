/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.model;

import hangman.exceptions.HangmanException;

/**
 *
 * @author 2152030
 */
public class BonusScore implements GameScore {
    /**
     * @pre El puntaje empieza en 0 puntos
     * @pos El puntaje esta en un rango entre [0,len*10], donde len es la longitud de la palabra
     * @param correctCount - Cantidad de aciertos
     * @param incorrectCount - Cantidad de errores
     * @return
     * @throws HangmanException
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws HangmanException{
        return 0;
    }
    
}
