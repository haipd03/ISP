/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ngoc Lan
 */
public class ThietBi {

    private int ThietBiID;
    private int PhongID;
    private String Name;
    private int SoLuong;
    private String TinhTrang;
    private int Gia;

    public ThietBi() {
    }

    public ThietBi(int PhongID) {
        this.PhongID = PhongID;
    }

    public ThietBi(int ThietBiID, int PhongID, String Name, int SoLuong, String TinhTrang, int Gia) {
        this.ThietBiID = ThietBiID;
        this.PhongID = PhongID;
        this.Name = Name;
        this.SoLuong = SoLuong;
        this.TinhTrang = TinhTrang;
        this.Gia = Gia;
    }

    public int getThietBiID() {
        return ThietBiID;
    }

    public void setThietBiID(int ThietBiID) {
        this.ThietBiID = ThietBiID;
    }

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int PhongID) {
        this.PhongID = PhongID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
        return "ThietBi{" + "ThietBiID=" + ThietBiID + ", PhongID=" + PhongID + ", Name=" + Name + ", SoLuong=" + SoLuong + ", TinhTrang=" + TinhTrang + ", Gia=" + Gia + '}';
    }

}