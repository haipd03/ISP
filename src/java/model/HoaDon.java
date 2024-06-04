/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class HoaDon {

    private int HoaDonID;
    private int HopDongID;
    private Date NgayThanhToan;
    private String TinhTrangThanhToan;
    private Date tuNgay;
    private Date denNgay;
    private int TongTien;

    public HoaDon() {
    }

    public HoaDon(int HoaDonID, int HopDongID, Date NgayThanhToan, String TinhTrangThanhToan, Date tuNgay, Date denNgay, int TongTien) {
        this.HoaDonID = HoaDonID;
        this.HopDongID = HopDongID;
        this.NgayThanhToan = NgayThanhToan;
        this.TinhTrangThanhToan = TinhTrangThanhToan;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.TongTien = TongTien;
    }

    public int getHoaDonID() {
        return HoaDonID;
    }

    public void setHoaDonID(int HoaDonID) {
        this.HoaDonID = HoaDonID;
    }

    public int getHopDongID() {
        return HopDongID;
    }

    public void setHopDongID(int HopDongID) {
        this.HopDongID = HopDongID;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public String getTinhTrangThanhToan() {
        return TinhTrangThanhToan;
    }

    public void setTinhTrangThanhToan(String TinhTrangThanhToan) {
        this.TinhTrangThanhToan = TinhTrangThanhToan;
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

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "HoaDonID=" + HoaDonID + ", HopDongID=" + HopDongID + ", NgayThanhToan=" + NgayThanhToan + ", TinhTrangThanhToan=" + TinhTrangThanhToan + ", tuNgay=" + tuNgay + ", denNgay=" + denNgay + ", TongTien=" + TongTien + '}';
    }

    
}
