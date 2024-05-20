/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author THANH SON
 */
public class HopDong {
    private int HopDongID;
    private int KhanhID;
    private int PhongID;
    private int TienCoc;
    private Date NgayThue;
    private Date NgayTra;
    private int SoKhachThue;
    private String GhiChu;
    private int CCCD;
    private int SDT;
    private String HoVaTen;

    public HopDong() {
    }

    public HopDong(int HopDongID, int KhanhID, int PhongID, int TienCoc, Date NgayThue, Date NgayTra, int SoKhachThue, String GhiChu, int CCCD, int SDT, String HoVaTen) {
        this.HopDongID = HopDongID;
        this.KhanhID = KhanhID;
        this.PhongID = PhongID;
        this.TienCoc = TienCoc;
        this.NgayThue = NgayThue;
        this.NgayTra = NgayTra;
        this.SoKhachThue = SoKhachThue;
        this.GhiChu = GhiChu;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.HoVaTen = HoVaTen;
    }

    public int getHopDongID() {
        return HopDongID;
    }

    public void setHopDongID(int HopDongID) {
        this.HopDongID = HopDongID;
    }

    public int getKhanhID() {
        return KhanhID;
    }

    public void setKhanhID(int KhanhID) {
        this.KhanhID = KhanhID;
    }

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int PhongID) {
        this.PhongID = PhongID;
    }

    public int getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(int TienCoc) {
        this.TienCoc = TienCoc;
    }

    public Date getNgayThue() {
        return NgayThue;
    }

    public void setNgayThue(Date NgayThue) {
        this.NgayThue = NgayThue;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public int getSoKhachThue() {
        return SoKhachThue;
    }

    public void setSoKhachThue(int SoKhachThue) {
        this.SoKhachThue = SoKhachThue;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    @Override
    public String toString() {
        return "HopDong{" + "HopDongID=" + HopDongID + ", KhanhID=" + KhanhID + ", PhongID=" + PhongID + ", TienCoc=" + TienCoc + ", NgayThue=" + NgayThue + ", NgayTra=" + NgayTra + ", SoKhachThue=" + SoKhachThue + ", GhiChu=" + GhiChu + ", CCCD=" + CCCD + ", SDT=" + SDT + ", HoVaTen=" + HoVaTen + '}';
    }
    
}