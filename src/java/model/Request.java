/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Request {
    private int RequestID;
    private int AccountID;
    private String Title;
    private Date SubmittedAt;
    private String RequestText;
    private String TinhTrang;
    private int AccountNhan;

    public Request() {
    }

    public Request(int RequestID, int AccountID, String Title, Date SubmittedAt, String RequestText, String TinhTrang, int AccountNhan) {
        this.RequestID = RequestID;
        this.AccountID = AccountID;
        this.Title = Title;
        this.SubmittedAt = SubmittedAt;
        this.RequestText = RequestText;
        this.TinhTrang = TinhTrang;
        this.AccountNhan = AccountNhan;
    }
    public Request(int AccountID, String Title, String RequestText, String TinhTrang, int AccountNhan) {
        this.AccountID = AccountID;
        this.Title = Title;
        this.RequestText = RequestText;
        this.TinhTrang = TinhTrang;
        this.AccountNhan = AccountNhan;
    }

    public int getRequestID() {
        return RequestID;
    }

    public void setRequestID(int RequestID) {
        this.RequestID = RequestID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public Date getSubmittedAt() {
        return SubmittedAt;
    }

    public void setSubmittedAt(Date SubmittedAt) {
        this.SubmittedAt = SubmittedAt;
    }

    public String getRequestText() {
        return RequestText;
    }

    public void setRequestText(String RequestText) {
        this.RequestText = RequestText;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public int getAccountNhan() {
        return AccountNhan;
    }

    public void setAccountNhan(int AccountNhan) {
        this.AccountNhan = AccountNhan;
    }

    @Override
    public String toString() {
        return "Request{" + "RequestID=" + RequestID + ", AccountID=" + AccountID + ", Title=" + Title + ", SubmittedAt=" + SubmittedAt + ", RequestText=" + RequestText + ", TinhTrang=" + TinhTrang + ", AccountNhan=" + AccountNhan + '}';
    }

 
    
}
