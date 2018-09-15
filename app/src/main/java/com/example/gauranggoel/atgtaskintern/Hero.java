package com.example.gauranggoel.atgtaskintern;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaurang goel on 15-09-2018.
 */

public class Hero {
    @SerializedName("photos")
    Hero1 hero;

    public Hero(){
    }

    public Hero1 getHero() {
        return hero;
    }

    public void setHero(Hero1 hero) {
        this.hero = hero;
    }
}
