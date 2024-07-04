/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author vulin
 */
public class DichVuChung {
    private int dichVuChungID;
    private int khuID;
    private String dichVuChungName;
    private String ten;
    private String sdt;
    private int gia;
    private Date tuNgay;
    private Date denNgay;
    private String tinhTrang;
    private String ghiChu;

    public DichVuChung() {
    }

    public DichVuChung(int dichVuChungID, int khuID, String dichVuChungName, String ten, String sdt, int gia, Date tuNgay, Date denNgay, String tinhTrang, String ghiChu) {
        this.dichVuChungID = dichVuChungID;
        this.khuID = khuID;
        this.dichVuChungName = dichVuChungName;
        this.ten = ten;
        this.sdt = sdt;
        this.gia = gia;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.tinhTrang = tinhTrang;
        this.ghiChu = ghiChu;
    }

    public int getDichVuChungID() {
        return dichVuChungID;
    }

    public void setDichVuChungID(int dichVuChungID) {
        this.dichVuChungID = dichVuChungID;
    }

    public int getKhuID() {
        return khuID;
    }

    public void setKhuID(int khuID) {
        this.khuID = khuID;
    }

    public String getDichVuChungName() {
        return dichVuChungName;
    }

    public void setDichVuChungName(String dichVuChungName) {
        this.dichVuChungName = dichVuChungName;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "DichVuChung{" + "dichVuChungID=" + dichVuChungID + ", khuID=" + khuID + ", dichVuChungName=" + dichVuChungName + ", ten=" + ten + ", sdt=" + sdt + ", gia=" + gia + ", tuNgay=" + tuNgay + ", denNgay=" + denNgay + ", tinhTrang=" + tinhTrang + ", ghiChu=" + ghiChu + '}';
    }
}
