/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Khu {
    private int KhuID;
    private String Name;
    private int AccountID;

    public Khu() {
    }

    public Khu(int KhuID, String Name, int AccountID) {
        this.KhuID = KhuID;
        this.Name = Name;
        this.AccountID = AccountID;
    }

    public int getKhuID() {
        return KhuID;
    }

    public void setKhuID(int KhuID) {
        this.KhuID = KhuID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    @Override
    public String toString() {
        return "Khu{" + "KhuID=" + KhuID + ", Name=" + Name + ", AccountID=" + AccountID + '}';
    }
    
    
}
