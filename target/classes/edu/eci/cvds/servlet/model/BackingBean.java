/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet.model;


import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.*;



/**
 *
 *
 * El número que actualmente debe adivinar (debe ser un número aleatorio).
 *
 * El número de intentos realizados.
 *
 * El premio acumulado hasta el momento.
 *
 * El estado del juego, que sería una cadena de texto que indica si ya ganó o
 * no, y si ganó de cuanto es el premio.
 * 
 * El juego consiste en adivinar un numero al azar de 1 a 10, cada intento resta 10.000
 * al premio final, el premio comienza siendo 100.000. Al llegar a un premio de 0 o menos
 * el juego se pierde y tendra que ser reiniciado

 */
@ManagedBean(name = "guessBean")
@ApplicationScoped
public class BackingBean {
    
    private int guessNumber;
    private int attempts;
    private int price;
    private String state;
    private int inputNumber;    
    private ArrayList<Integer> attemptedNumbers;
    
    private final String winState="YOU WIN!!!"; 
    private final String loseState="YOU LOSE!!!";
    private final String initialState="Try to guess the number!";
    private final String wrongState="That's the wrong number";
    private final String invalidState="You are using an invalid number";
       
        
    public BackingBean(){ 
        Random randNumber = new Random();
        guessNumber = 1+randNumber.nextInt(15);
        attempts = 0;
        price=100000;
        state=initialState;        
        attemptedNumbers = new ArrayList<Integer>();
    }

    
    public void guess(int inputNumber){
        
        if (!state.equals(winState)){
            if (inputNumber==guessNumber & price>0){
                attempts +=1;                                
                setState(winState);
            }
            else if (inputNumber!=guessNumber & price>0){
                attempts +=1;                
                attemptedNumbers.add(inputNumber);
                price -=10000;
                setState(wrongState);
            }
            else if (price<=0){
                setState(loseState);
            }
        }else{
            setState(winState);
            
        }

       
    }
    public void guess(String inputNumber){
        try{
            
            this.inputNumber = Integer.parseInt(inputNumber);  
            guess(this.inputNumber);
        
        }catch(Exception e){
            setState(invalidState);
        }
    }
    public void restart (){
        Random randNumber = new Random();
        guessNumber = 1+randNumber.nextInt(10);
        attempts = 0;
        price=100000;
        state=initialState; 
        attemptedNumbers.clear();
    }

    public ArrayList<Integer> getAttemptedNumbers() {
        return attemptedNumbers;
    }

    public void setAttemptedNumbers(ArrayList<Integer> attemptedNumbers) {
        this.attemptedNumbers = attemptedNumbers;
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }    

    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}
