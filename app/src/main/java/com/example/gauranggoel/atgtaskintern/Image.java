package com.example.gauranggoel.atgtaskintern;

/**
 * Created by gaurang goel on 15-09-2018.
 */

public class Image {
    String id;
    String owner;
    String secret;
    String farm;
    String title;
    String ispublic;
    String isfriend;
    String isfamily;
    String url_s;
    String height_s;
    String width_s;

    public Image() {

    }

    public Image(String id, String owner, String secret, String farm, String title, String ispublic, String isfriend, String isfamily, String url_s, String height_s, String width_s) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
        this.url_s = url_s;
        this.height_s = height_s;
        this.width_s = width_s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(String isfriend) {
        this.isfriend = isfriend;
    }

    public String getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(String isfamily) {
        this.isfamily = isfamily;
    }

    public String getUrl_s() {
        return url_s;
    }

    public void setUrl_s(String url_s) {
        this.url_s = url_s;
    }

    public String getHeight_s() {
        return height_s;
    }

    public void setHeight_s(String height_s) {
        this.height_s = height_s;
    }

    public String getWidth_s() {
        return width_s;
    }

    public void setWidth_s(String width_s) {
        this.width_s = width_s;
    }
}
