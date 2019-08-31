/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.model;


public class OriginalScore implements GameScore {    
    /**
     * @pre El puntaje empieza en 100 puntos
     * @pos El puntaje esta en un rango entre [0,100]
     * @param correctCount - Cantidad de aciertos
     * @param incorrectCount - Cantidad de errores
     * @return
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    }
}
