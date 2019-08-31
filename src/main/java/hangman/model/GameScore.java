/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.model;

/**
 *
 * @author 2152030
 */
public interface GameScore {
    public int calculateScore(int correctCount, int incorrectCount);
}
