package com.example.nehalnafady.movieapplication;

import android.net.Uri;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Nehal Nafady on 2/3/2016.
 */
public class RequiredDataUrl {
    private final String api_key_value         = "ae789d26bd882e28af1b088bc3ed08f4";
    private final String BaseUrl               = "http://api.themoviedb.org/3/" ;
    private final String BaseUrlDiscoverMovies = BaseUrl + "discover/movie?";
    private final String sort_by               = "sort_by";
    private final String api_key               = "api_key";
    private final String page                  = "page" ;
    private final String BaseUrlMovie          = BaseUrl + "movie/";


    public URL BuildDiscoverUrl( String soryBy_param , int pageNum_param ) throws IOException
    {
        Uri uriBuilder = Uri.parse(BaseUrlDiscoverMovies).buildUpon()
                .appendQueryParameter(sort_by, soryBy_param).appendQueryParameter(page , Integer.toString( pageNum_param ))
                .appendQueryParameter(api_key , api_key_value).build();
        URL url = new URL(uriBuilder.toString());
        return url;
    }
    public URL BuildMovie(int page,String way) throws IOException
    {
        Uri uriBuilder=Uri.parse("http://api.themoviedb.org/3/discover/movie?").buildUpon()
                .appendQueryParameter("api_key", "ae789d26bd882e28af1b088bc3ed08f4").appendQueryParameter("sort_by",way)
                .appendQueryParameter("page",Integer.toString(page)).build();
        URL url =new URL(uriBuilder.toString());
        return url;
    }
    public URL BuildMovieByIdUrl(String MovieId) throws IOException
    {
        Uri uriBuilder = Uri.parse(BaseUrlMovie + MovieId ).buildUpon()
                .appendQueryParameter(api_key , BuildConfig.MOVIES_API_KEY)
                .build();

        URL url = new URL(uriBuilder.toString());

        return url;
    }
}


