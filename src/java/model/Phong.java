/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Phong {

    private int PhongID;
    private int SoPhong;
    private int KhuID;
    private String LoaiPhong;
    private int PhongConTrong;
    private int Gia;

    public Phong() {
    }

    public Phong(int PhongID, int SoPhong, int KhuID, String LoaiPhong, int PhongConTrong, int Gia) {
        this.PhongID = PhongID;
        this.SoPhong = SoPhong;
        this.KhuID = KhuID;
        this.LoaiPhong = LoaiPhong;
        this.PhongConTrong = PhongConTrong;
        this.Gia = Gia;
    }

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int PhongID) {
        this.PhongID = PhongID;
    }

    public int getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(int SoPhong) {
        this.SoPhong = SoPhong;
    }

    public int getKhuID() {
        return KhuID;
    }

    public void setKhuID(int KhuID) {
        this.KhuID = KhuID;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public int getPhongConTrong() {
        return PhongConTrong;
    }

    public void setPhongConTrong(int PhongConTrong) {
        this.PhongConTrong = PhongConTrong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    @Override
    public String toString() {
        return "Phong{" + "PhongID=" + PhongID + ", SoPhong=" + SoPhong + ", KhuID=" + KhuID + ", LoaiPhong=" + LoaiPhong + ", PhongConTrong=" + PhongConTrong + ", Gia=" + Gia + '}';
    }
    
    

}
