/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hangman.exceptions.*;
import hangman.model.*;
import org.junit.Test;
import static org.junit.Assert.*;


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
            assertEquals(10,game.calculateScore(3,2));            
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
            assertEquals(20,game.calculateScore(3, 1));
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
        /**
        *
        * 
        */
        try {
            GameScore game = new PowerScore();
            //valor 0 < IncorrectCount < CorrectCount
            assertEquals(20,game.calculateScore(3, 1));
        } catch (HangmanException ex) {
            fail("No deberia enviar excepcion");
        }
    }
}
