package model;

public class Phong1 {
    private int phongID;
    private int soPhong;
    private int khuID;
    private String loaiPhong;
    private int phongConTrong;
    private int gia;

    public Phong1() {}

    public Phong1(int phongID, int soPhong, int khuID, String loaiPhong, int phongConTrong, int gia) {
        this.phongID = phongID;
        this.soPhong = soPhong;
        this.khuID = khuID;
        this.loaiPhong = loaiPhong;
        this.phongConTrong = phongConTrong;
        this.gia = gia;
    }

    public int getPhongID() {
        return phongID;
    }

    public void setPhongID(int phongID) {
        this.phongID = phongID;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public int getKhuID() {
        return khuID;
    }

    public void setKhuID(int khuID) {
        this.khuID = khuID;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getPhongConTrong() {
        return phongConTrong;
    }

    public void setPhongConTrong(int phongConTrong) {
        this.phongConTrong = phongConTrong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
