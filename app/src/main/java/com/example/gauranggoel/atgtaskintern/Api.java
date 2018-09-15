package com.example.gauranggoel.atgtaskintern;

/**
 * Created by gaurang goel on 09-09-2018.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://api.flickr.com";

    @GET("/services/rest/?method=flickr.photos.getRecent&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
    Call<Hero> getHeroes();

    @GET("/services/rest/?method=flickr.photos.search&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
    Call<Hero> call_articles(
            @Query("text")String source
    );

}


