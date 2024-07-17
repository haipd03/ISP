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
    private int PhongID;
    private String name;
    private int giaTien;
    private Date tuNgay;
    private Date denNgay;
    private int chiSoCu;
    private int chiSoMoi;
    private String urlAnh;

    public DichVu() {
    }

    public DichVu(int dichVuID, int PhongID, String name, int giaTien, Date tuNgay, Date denNgay, int chiSoCu, int chiSoMoi, String urlAnh) {
        this.dichVuID = dichVuID;
        this.PhongID = PhongID;
        this.name = name;
        this.giaTien = giaTien;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.urlAnh = urlAnh;
    }

    public int getDichVuID() {
        return dichVuID;
    }

    public void setDichVuID(int dichVuID) {
        this.dichVuID = dichVuID;
    }

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int PhongID) {
        this.PhongID = PhongID;
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

    public String getUrlAnh() {
        return urlAnh;
    }

    public void setUrlAnh(String urlAnh) {
        this.urlAnh = urlAnh;
    }

    @Override
    public String toString() {
        return "DichVu{" + "dichVuID=" + dichVuID + ", PhongID=" + PhongID + ", name=" + name + ", giaTien=" + giaTien + ", tuNgay=" + tuNgay + ", denNgay=" + denNgay + ", chiSoCu=" + chiSoCu + ", chiSoMoi=" + chiSoMoi + ", urlAnh=" + urlAnh + '}';
    }

}
