/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.model;

import hangman.exceptions.*;


public interface GameScore {
    
    /**
     *
     * @param correctCount
     * @param incorrectCount
     * @return
     * @throws HangmanException
     */
    public int calculateScore(int correctCount, int incorrectCount)throws HangmanException;
}
