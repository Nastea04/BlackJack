/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack1;

import java.awt.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Emo
 */
public class Deck {

    Card[] cards=new Card[52];

    public Deck() {
        String[] boi = {"C", "D", "H", "S"};
        String[] sili = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A",};
        int[] stoinosti = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,10, 11};
        int ind = 0;

        for(int i=0;i<13;i++){
            for(int k=0;k<4;k++){
                cards[ind]=new Card(boi[k],sili[i], stoinosti[i]);
                ind++;
            }
        }


        
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    
 
}
