package com.example.nehalnafady.movieapplication;

/**
 * Created by Nehal Nafady on 2/3/2016.
 */
public class Movie {
    String id;
    String Title;
    String overview;
    double popularity;
    double vote_avg;
    int vote_count;
    String language;
    String release_date;
    String description ;
    String poster_path ;
    String Runtime;
    String Budget;
    String  Tagline;

    public String getTitle() {
        return Title;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getBudget() {
        return Budget;
    }

    public void setBudget(String budget) {
        Budget = budget;
    }

    public String getTagline() {
        return Tagline;
    }

    public void setTagline(String tagline) {
        Tagline = tagline;
    }

    public String getRuntime() {
        return Runtime;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setTitle(String title) {
        Title = title;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public double getVote_avg() {
        return vote_avg;
    }

    public void setVote_avg(double vote_avg) {
        this.vote_avg = vote_avg;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    String[]genres  ;

}
