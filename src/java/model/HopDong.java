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
    private int KhachID;
    private int PhongID;
    private int TienCoc;
    private Date NgayThue;
    private Date NgayTra;
    private int SoKhachThue;
    private String GhiChu;
    private String CCCD;
    private String SDT;
    private String HoVaTen;
    private int TinhTrang;

    public HopDong() {
    }

    public HopDong(int HopDongID, int KhachID, int PhongID, int TienCoc, Date NgayThue, Date NgayTra, int SoKhachThue, String GhiChu, String CCCD, String SDT, String HoVaTen, int TinhTrang) {
        this.HopDongID = HopDongID;
        this.KhachID = KhachID;
        this.PhongID = PhongID;
        this.TienCoc = TienCoc;
        this.NgayThue = NgayThue;
        this.NgayTra = NgayTra;
        this.SoKhachThue = SoKhachThue;
        this.GhiChu = GhiChu;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.HoVaTen = HoVaTen;
        this.TinhTrang = TinhTrang;
    }

    public int getHopDongID() {
        return HopDongID;
    }

    public void setHopDongID(int HopDongID) {
        this.HopDongID = HopDongID;
    }

    public int getKhachID() {
        return KhachID;
    }

    public void setKhachID(int KhachID) {
        this.KhachID = KhachID;
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

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    @Override
    public String toString() {
        return "HopDong{" + "HopDongID=" + HopDongID + ", KhachID=" + KhachID + ", PhongID=" + PhongID + ", TienCoc=" + TienCoc + ", NgayThue=" + NgayThue + ", NgayTra=" + NgayTra + ", SoKhachThue=" + SoKhachThue + ", GhiChu=" + GhiChu + ", CCCD=" + CCCD + ", SDT=" + SDT + ", HoVaTen=" + HoVaTen + ", TinhTrang=" + TinhTrang + '}';
    }

}
