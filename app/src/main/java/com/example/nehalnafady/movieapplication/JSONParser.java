package com.example.nehalnafady.movieapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nehal Nafady on 2/10/2016.
 */
public class JSONParser {
    public Movie[] GetInformation(String JSONstring)throws JSONException
    {
        JSONObject jsonObject=new JSONObject(JSONstring);
        JSONArray  Result = jsonObject.getJSONArray("results");
        Movie[] ListMovie  = new Movie[  Result.length() ];
        for (int i=0; i<Result.length(); i++)
        {
            JSONObject ReturnedData=Result.getJSONObject(i);
            Movie movie=new Movie();
            movie.setId(ReturnedData.getString("id"));
            movie.setLanguage(ReturnedData.getString("original_language"));
            movie.setOverview(ReturnedData.getString("overview"));
            movie.setPopularity(ReturnedData.getDouble("popularity"));
            movie.setRelease_date(ReturnedData.getString("release_date"));
            movie.setTitle(ReturnedData.getString("title"));
            movie.setVote_avg(ReturnedData.getDouble("vote_average"));
            movie.setVote_count(ReturnedData.getInt("vote_count"));
            movie.setPoster_path("http://image.tmdb.org/t/p/w185/"+ReturnedData.getString("poster_path"));
            ListMovie[i]=movie;
        }
        return ListMovie;
    }
    public Movie getMovieObject(String jsonString) throws JSONException
    {
        JSONObject movieInfo = new JSONObject(jsonString);
        Movie movie = new Movie();
        movie.setId(movieInfo.getString("id"));
        movie.setTitle(movieInfo.getString("title"));
        movie.setDescription(movieInfo.getString("overview"));
        movie.setRelease_date(movieInfo.getString("release_date"));
        movie.setPoster_path("http://image.tmdb.org/t/p/w185/" + movieInfo.getString("poster_path"));
        movie.setVote_avg(movieInfo.getDouble("vote_average"));
        movie.setVote_count(movieInfo.getInt("vote_count"));
        movie.setBudget(movieInfo.getString("budget"));
        movie.setTagline(movieInfo.getString("tagline"));
        JSONArray Jsongenres = movieInfo.getJSONArray("genres");
        String[] genres = new String[Jsongenres.length()] ;
        for(int i=0 ; i < genres.length ; i++)
        {
            JSONObject genre = Jsongenres.getJSONObject(i);
            genres[i] = genre.getString("name");
        }
        movie.setGenres(genres);
        return movie;
    }
}
