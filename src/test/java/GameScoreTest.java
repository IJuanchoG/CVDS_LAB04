/**
 * CLASES DE EQUIVALENCIA
 * PARA ORIGINALSCORE
 * 
|  Número        |Clase de equivalencia (en lenguaje natural o matemático).|Resultado correcto / incorrecto. |
|----------------|---------------------------------------------------------|---------------------------------|
|1		 | Incorrect<0 o Correct<0                                 |(Incorrecto) HangManException    |
|2		 | 0<= Incorrect <= 10	                                   |(Correcto) Valor entre 100 y 0   |
|3		 | Incorrect > 10	                                   |(Correcto) Valor igual a 0       |
 * 
 * PARA BONUSSCORE
 * 
|  Número        |Clase de equivalencia (en lenguaje natural o matemático).|Resultado correcto / incorrecto. 			   |
|----------------|---------------------------------------------------------|-------------------------------------------------------|
|1		 | Incorrect<0 o Correct<0                                 |(Incorrecto) HangManException      			   |
|2		 | 0<= Incorrect <= 2Correct   	                           |(Correcto) Valor entre 10*longitud de la palabra y 0   |
|3		 | 2C < Incorrect y 0<Correct                              |(Correcto) Valor igual a 0     			   |
* 
* PARA POWERSCORE
* 
|  Número        |Clase de equivalencia (en lenguaje natural o matemático).|Resultado correcto / incorrecto. 			   |
|----------------|---------------------------------------------------------|-------------------------------------------------------|
|1		 | Incorrect<0 o Correct<0                                 |(Incorrecto) HangManException      			   |
|2		 | SUM(5^K)<8Incorrect   con K de 1 a Correct   	   |(Correcto) Valor igual a 0     			   |
|3		 | 0<= SUM(5^K)-8Incorrect<=500   con K de 1 a Correct     |(Correcto) Valor entre 500 y 0    			   |
|4		 | 500< SUM(5^K)-8Incorrect   con K de 1 a Correct         |(Correcto) Valor igual a 500   			   |
* 
* 
 */

import hangman.exceptions.*;
import hangman.model.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;


public class GameScoreTest {
    
    @Test
    public void ScoreLimiteMenor0() { 
        try{
            GameScore game = new OriginalScore();
            //valor IncorrectCount erroneo
            game.calculateScore(0, -1);
            //valor CorrectCount erroneo
            game.calculateScore(-1, 0);
            //Ambos valores erroneos
            game.calculateScore(-1, -1);
            
            game = new BonusScore();
            //valor IncorrectCount erroneo
            game.calculateScore(0, -1);
            //valor CorrectCount erroneo
            game.calculateScore(-1, 0);
            //Ambos valores erroneos
            game.calculateScore(-1, -1);
            
            game = new PowerScore();
            //valor IncorrectCount erroneo
            game.calculateScore(0, -1);
            //valor CorrectCount erroneo
            game.calculateScore(-1, 0);
            //Ambos valores erroneos
            game.calculateScore(-1, -1);
            fail("Deberia enviar excepcion");
        }catch(HangmanException ex){
            assertEquals(ex.getMessage(),HangmanException.ARGUMENTOINVALIDO);
        }
    }
    
    @Test
    public void OriginalScoreLimite0_10() { 
        try {
            GameScore game = new OriginalScore();
            //valor IncorrectCount = 0 
            assertEquals(100,game.calculateScore(0, 0));
            //valor IncorrectCount = 1
            assertEquals(90,game.calculateScore(0, 1));
            //valor IncorrectCount = 9
            assertEquals(10,game.calculateScore(0, 9));
            //valor IncorrectCount = 10
            assertEquals(0,game.calculateScore(0, 10));
        } catch (HangmanException ex) {
            fail("No deberia enviar excepcion");
        }
    }
    
    @Test
    public void OriginalScoreLimiteMayor10() { 
        try {
            GameScore game = new OriginalScore();
            //valor IncorrectCount = 11
            assertEquals(0,game.calculateScore(0, 11));            
            //valor IncorrectCount = 132
            assertEquals(0,game.calculateScore(0, 132));            
            //valor IncorrectCount = 3213214
            assertEquals(0,game.calculateScore(0, 3213214));
        } catch (HangmanException ex) {
            fail("No deberia enviar excepcion");
        }
    }
    
    @Test
    public void BonusScoreLimite_Imayor2C() { 
        try {
            GameScore game = new BonusScore();
            //valor IncorrectCount > 2CorrectCount
            assertEquals(0,game.calculateScore(1, 3));
            //valor IncorrectCount = 2*CorrectCount
            assertEquals(0,game.calculateScore(3, 6));
            //valor IncorrectCount = 0 && Valor CorrectCount = 0 
            assertEquals(0,game.calculateScore(0, 0));
            //valor IncorrectCount <= CorrectCount
            assertEquals(20,game.calculateScore(3,2));            
            assertEquals(10,game.calculateScore(2,2));
            // 
        } catch (HangmanException ex) {
            fail("No deberia enviar excepcion");
        }
    }
    
    @Test
    public void BonusScoreLimite0_2C() { 
        try {
            GameScore game = new BonusScore();
            //valor 0 < IncorrectCount < CorrectCount
            assertEquals(20,game.calculateScore(3, 2));
            //valor 0 < IncorrectCount = 2*CorrectCount
            assertEquals(0,game.calculateScore(3, 6));
            //valor IncorrectCount = 0 || Valor CorrectCount = 0 
            assertEquals(0,game.calculateScore(0, 0));
            assertEquals(10,game.calculateScore(1, 0));
            assertEquals(0,game.calculateScore(0, 1));
            //valor 0 <= IncorrectCount < 2*CorrectCount
            assertEquals(30,game.calculateScore(3,0));  
        } catch (HangmanException ex) {
            fail("No deberia enviar excepcion");
        }
    }
    
    @Test
    public void powerScoreTest() {
        try {
            GameScore game = new PowerScore();
            //SUM(5^K)<8Incorrect   con K de 0 a Correct
            assertEquals(0,game.calculateScore(2, 4));
            // 0<= SUM(5^K)-8Incorrect<=500   con K de 0 a Correct  
            assertEquals(500,game.calculateScore(7, 4));
            // 500< SUM(5^K)-8Incorrect   con K de 0 a Correct             
            assertEquals(139,game.calculateScore(3, 2));
            
        } catch (HangmanException ex) {
            fail("No deberia enviar excepcion");
        }
    }
}
