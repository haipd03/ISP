/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Accounts {
    private int AccountID;
    private String TaiKhoan;
    private String Password;
    private int Role;
    private String HoVaTen;
    private String Email;
    private int CCCD;
    private String DiaChi;

    public Accounts() {
    }

    public Accounts(int id, String TaiKhoan, String Password, int Role, String HoVaTen, String Email, int CCCD, String DiaChi) {
        this.AccountID = id;
        this.TaiKhoan = TaiKhoan;
        this.Password = Password;
        this.Role = Role;
        this.HoVaTen = HoVaTen;
        this.Email = Email;
        this.CCCD = CCCD;
        this.DiaChi = DiaChi;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int id) {
        this.AccountID = id;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    @Override
    public String toString() {
        return "Accounts{" + "id=" + AccountID + ", TaiKhoan=" + TaiKhoan + ", Password=" + Password + ", Role=" + Role + ", HoVaTen=" + HoVaTen + ", Email=" + Email + ", CCCD=" + CCCD + ", DiaChi=" + DiaChi + '}';
    }
    
    
}
