package com.example.nehalnafady.movieapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ImageAdapter extends ArrayAdapter<Movie> {
    public ImageAdapter(Context context, List<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie=getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_movies , parent , false);
        ImageView Image = (ImageView) convertView.findViewById(R.id.movie_image_item);
        String imageUrl =  movie.getPoster_path() ;
        Picasso.with(getContext()).load(imageUrl).into(Image);
        return  convertView;
    }
}