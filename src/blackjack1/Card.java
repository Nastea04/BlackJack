/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack1;

/**
 *
 * @author Emo
 */
public class Card {

    String boq;  // Боя на картата
    String sila;  // Стойност на картата демек числото дето си пише на картата
    private int stoinost;    //Самата стойност както асо е 1 или 11

    public Card() {
        this.boq = "";
        this.sila = "Unknown";
        this.stoinost = 0;
    }

    public Card(String boq, String sila, int stoinost) {
        this.boq = boq;
        this.sila = sila;
        this.stoinost = stoinost;
    }

    public String getBoq() {
        return boq;
    }

    public void setBoq(String boq) {
        this.boq = boq;
    }

    public String getSila() {
        return sila;
    }

    public void setSila(String sila) {
        this.sila = sila;
    }

    public int getStoinost() {
        return stoinost;
    }

    public void setStoinost(int stoinost) {
        this.stoinost = stoinost;
    }

    public String CardImgName() {
        return sila + "-" + boq+".png";
    }
}