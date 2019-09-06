/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.model;

import hangman.exceptions.HangmanException;


public class OriginalScore implements GameScore {
    public final int MAX_ORIGINAL_SCORE = 100;
    /**
     * @throws hangman.exceptions.HangmanException
     * @pre El puntaje empieza en 100 puntos
     * @pos El puntaje esta en un rango entre [0,100]
     * @param correctCount - Cantidad de aciertos
     * @param incorrectCount - Cantidad de errores
     * @return
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount)throws HangmanException {
        if(correctCount<0 || incorrectCount<0) throw new HangmanException(HangmanException.ARGUMENTOINVALIDO);
        int ans = MAX_ORIGINAL_SCORE-10*incorrectCount;
        return ans<0?0:ans;
        
    }
    @Override
    public int getPuntajeInicial(){
        return 100;
    }
}
