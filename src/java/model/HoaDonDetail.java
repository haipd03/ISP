/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Ngoc Lan
 */
public class HoaDonDetail {
    private int hoaDonDetailID;
    private int hoaDonID;
    private Date tuNgay;
    private Date denNgay;
    private int tongSo;
    private int heSo;
    private int thanhTien;
    private int dichVuID;

    public HoaDonDetail() {
    }

    public HoaDonDetail(int hoaDonDetailID, int hoaDonID, Date tuNgay, Date denNgay, int tongSo, int heSo, int thanhTien, int dichVuID) {
        this.hoaDonDetailID = hoaDonDetailID;
        this.hoaDonID = hoaDonID;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.tongSo = tongSo;
        this.heSo = heSo;
        this.thanhTien = thanhTien;
        this.dichVuID = dichVuID;
    }
    
    

    public int getHoaDonDetailID() {
        return hoaDonDetailID;
    }

    public void setHoaDonDetailID(int hoaDonDetailID) {
        this.hoaDonDetailID = hoaDonDetailID;
    }

    public int getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(int hoaDonID) {
        this.hoaDonID = hoaDonID;
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

    public int getTongSo() {
        return tongSo;
    }

    public void setTongSo(int tongSo) {
        this.tongSo = tongSo;
    }

    public int getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getDichVuID() {
        return dichVuID;
    }

    public void setDichVuID(int dichVuID) {
        this.dichVuID = dichVuID;
    }

    @Override
    public String toString() {
        return "HoaDonDetail{" + "hoaDonDetailID=" + hoaDonDetailID + ", hoaDonID=" + hoaDonID + ", tuNgay=" + tuNgay + ", denNgay=" + denNgay + ", tongSo=" + tongSo + ", heSo=" + heSo + ", thanhTien=" + thanhTien + ", dichVuID=" + dichVuID + '}';
    }

   
    
    
}
