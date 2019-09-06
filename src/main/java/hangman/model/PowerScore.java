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
public class PowerScore implements GameScore {
    /**
     * @throws hangman.exceptions.HangmanException
     * @pre El puntaje empieza en 0 puntos
     * @pos El puntaje esta en un rango entre [0,SUM(5^i)] con i variando de 1 hasta el len
     * @param correctCount - Cantidad de aciertos
     * @param incorrectCount - Cantidad de errores
     * @return
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {
        if(correctCount<0 || incorrectCount<0) throw new HangmanException(HangmanException.ARGUMENTOINVALIDO);
        int sumatoria = 0;
        for(int i=1;i<=correctCount;i++) sumatoria+= Math.pow(5, i);
        int ans = sumatoria-8*incorrectCount;
        
        if(ans>500) ans=500;
        else if(ans<0) ans = 0;
        
        return ans;
    }
}
