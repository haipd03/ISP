/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author THANH SON
 */
public class KhachThue {

    private int KhachID;
    private String HoVaTen;
    private String CCCD;
    private String SDT;
    private String QueQuan;
    private String TenNguoiThan;
    private String SDTNguoiThan;
    private String QuanHeVoiNguoiThan;
    private int PhongID;

    public KhachThue() {
    }

    public KhachThue(int KhachID, String HoVaTen, String CCCD, String SDT, String QueQuan, String TenNguoiThan, String SDTNguoiThan, String QuanHeVoiNguoiThan, int PhongID) {
        this.KhachID = KhachID;
        this.HoVaTen = HoVaTen;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.QueQuan = QueQuan;
        this.TenNguoiThan = TenNguoiThan;
        this.SDTNguoiThan = SDTNguoiThan;
        this.QuanHeVoiNguoiThan = QuanHeVoiNguoiThan;
        this.PhongID = PhongID;
    }

    public int getKhachID() {
        return KhachID;
    }

    public void setKhachID(int KhachID) {
        this.KhachID = KhachID;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
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

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getTenNguoiThan() {
        return TenNguoiThan;
    }

    public void setTenNguoiThan(String TenNguoiThan) {
        this.TenNguoiThan = TenNguoiThan;
    }

    public String getSDTNguoiThan() {
        return SDTNguoiThan;
    }

    public void setSDTNguoiThan(String SDTNguoiThan) {
        this.SDTNguoiThan = SDTNguoiThan;
    }

    public String getQuanHeVoiNguoiThan() {
        return QuanHeVoiNguoiThan;
    }

    public void setQuanHeVoiNguoiThan(String QuanHeVoiNguoiThan) {
        this.QuanHeVoiNguoiThan = QuanHeVoiNguoiThan;
    }

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int PhongID) {
        this.PhongID = PhongID;
    }

    @Override
    public String toString() {
        return "KhachThue{" + "KhachID=" + KhachID + ", HoVaTen=" + HoVaTen + ", CCCD=" + CCCD + ", SDT=" + SDT + ", QueQuan=" + QueQuan + ", TenNguoiThan=" + TenNguoiThan + ", SDTNguoiThan=" + SDTNguoiThan + ", QuanHeVoiNguoiThan=" + QuanHeVoiNguoiThan + ", PhongID=" + PhongID + '}';
    }
    
}
