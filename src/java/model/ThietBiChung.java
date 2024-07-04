/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ngoc Lan
 */
public class ThietBiChung {
    private int ThietBiChungID;
    private int KhuID;
    private String Ten;
    private int SoLuong;
    private String TinhTrang;
    private int Gia;

    public ThietBiChung() {
    }

    public ThietBiChung(int ThietBiChungID, int KhuID, String Ten, int SoLuong, String TinhTrang, int Gia) {
        this.ThietBiChungID = ThietBiChungID;
        this.KhuID = KhuID;
        this.Ten = Ten;
        this.SoLuong = SoLuong;
        this.TinhTrang = TinhTrang;
        this.Gia = Gia;
    }

    public int getThietBiChungID() {
        return ThietBiChungID;
    }

    public void setThietBiChungID(int ThietBiChungID) {
        this.ThietBiChungID = ThietBiChungID;
    }

    public int getKhuID() {
        return KhuID;
    }

    public void setKhuID(int KhuID) {
        this.KhuID = KhuID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    @Override
    public String toString() {
        return "ThietBiChung{" + "ThietBiChungID=" + ThietBiChungID + ", KhuID=" + KhuID + ", Ten=" + Ten + ", SoLuong=" + SoLuong + ", TinhTrang=" + TinhTrang + ", Gia=" + Gia + '}';
    }
    
}
