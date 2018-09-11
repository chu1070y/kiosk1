package org.zerock.web.domain;

import lombok.Data;

import java.util.Date;

public class MenuVO {
    private int mno,price;
    private String mname, img;
    private Date regdate;

    @Override
    public String toString() {
        return "MenuVO{" +
                "mno=" + mno +
                ", price=" + price +
                ", mname='" + mname + '\'' +
                ", img='" + img + '\'' +
                ", regdate=" + regdate +
                '}';
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
