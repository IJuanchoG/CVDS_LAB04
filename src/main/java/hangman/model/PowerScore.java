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
public class PowerScore implements GameScore {
    /**
     * @pre El puntaje empieza en 100 puntos
     * @pos El puntaje esta en un rango entre [0,SUM(5^i)] con i variando de 1 hasta el len
     * @param correctCount - Cantidad de aciertos
     * @param incorrectCount - Cantidad de errores
     * @return
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    }
    
}