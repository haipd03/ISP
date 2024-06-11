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
public class DichVu {

    private int dichVuID;
    private int soPhong;
    private String name;
    private int giaTien;
    private Date tuNgay;
    private Date denNgay;
    private int chiSoCu;
    private int chiSoMoi;

    public DichVu() {
    }

    public DichVu(int dichVuID, int soPhong, String name, int giaTien, Date tuNgay, Date denNgay, int chiSoCu, int chiSoMoi) {
        this.dichVuID = dichVuID;
        this.soPhong = soPhong;
        this.name = name;
        this.giaTien = giaTien;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
    }

    public int getDichVuID() {
        return dichVuID;
    }

    public void setDichVuID(int dichVuID) {
        this.dichVuID = dichVuID;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
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

    public int getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(int chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public int getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(int chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    @Override
    public String toString() {
        return "DichVu{" + "dichVuID=" + dichVuID + ", soPhong=" + soPhong + ", name=" + name + ", giaTien=" + giaTien + ", tuNgay=" + tuNgay + ", denNgay=" + denNgay + ", chiSoCu=" + chiSoCu + ", chiSoMoi=" + chiSoMoi + '}';
    }

}