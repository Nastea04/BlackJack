/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack1;

/**
 *
 * @author Emo
 */
public class Player {
    
    private String name;      //imeto na igracah
    private Card[] rukaPl;      // rukata na igracha
    private int cntCards;    // Брой карти в ръката
    private int score;        // Текущ резултат

    
    public Player(String _name) {
        this.name = name;
        this.rukaPl= new Card[6]; 
        this.cntCards = 0;
        this.score = 0;
    }

    
    public void addCard(Card card) {
        if (cntCards < 6) {
            rukaPl[cntCards] = card; 
            cntCards++;      
            if(card.sila=="A"&&score+11>21){
                score++;
            }else{
                score+= card.getStoinost(); 
            }
        }
    }

    public void newGamePlayer(){
        score=0;
        cntCards=0;
    }
   
    public int getScore(){
        return score;
    }
 
}