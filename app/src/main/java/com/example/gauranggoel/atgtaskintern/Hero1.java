package com.example.gauranggoel.atgtaskintern;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by gaurang goel on 09-09-2018.
 */

public class Hero1 {
    @SerializedName("page")
        String page;
    @SerializedName("pages")
        String pages;
    @SerializedName("perpage")
        String perpage;
    @SerializedName("total")
        String total;
    @SerializedName("stat")
        String stat;
     @SerializedName("photo")
        ArrayList<Image> img;

    public Hero1() {

    }

    public Hero1(String page, String pages, String perpage, String total, String stat, ArrayList<Image> img) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.stat = stat;
        this.img = img;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPerpage() {
        return perpage;
    }

    public void setPerpage(String perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public ArrayList<Image> getImg() {
        return img;
    }

    public void setImg(ArrayList<Image> img) {
        this.img = img;
    }
}

//"id":"29756116977","owner":"51036032@N08","secret":"5feb6383ac","server":"1892","farm":2,"title":"","ispublic":1,"isfriend":0,
// "isfamily":0,"url_s":"https:\/\/farm2.staticflickr.com\/1892\/29756116977_5feb6383ac_m.jpg","height_s":"180","width_s":"240"}