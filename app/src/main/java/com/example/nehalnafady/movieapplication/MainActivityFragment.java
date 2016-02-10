package com.example.nehalnafady.movieapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivityFragment extends Fragment {
    GridView gridView;
    private int result_pageNumber = 1;
    private List<Movie> moviesList;
    private ImageAdapter adapter;
    public MainActivityFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        moviesList = new ArrayList<Movie>();
        URL url;
        try {
            RequiredDataUrl Builder = new RequiredDataUrl();
            url = Builder.BuildDiscoverUrl(Settings.sortBypopularity(), result_pageNumber++);
            FatchMoviesInfo fatchMoviesInfo = new FatchMoviesInfo();
            fatchMoviesInfo.execute(url);
        } catch (IOException e)
        {
            Log.e("url_error", e.toString());
        }
        adapter = new ImageAdapter(getActivity(), moviesList);
        gridView = (GridView) rootView.findViewById(R.id.movies_gridview);
        gridView.setAdapter(adapter);
        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (gridView.getLastVisiblePosition() >= gridView.getCount() - gridView.getNumColumns()) {
                    URL url;
                    try {
                        RequiredDataUrl Builder = new RequiredDataUrl();
                        url = Builder.BuildDiscoverUrl(Settings.sortBypopularity(), result_pageNumber++);
                        FatchMoviesInfo fatchMoviesInfo = new FatchMoviesInfo();
                        fatchMoviesInfo.execute(url);
                    } catch (IOException e)
                    {
                        Log.e("url error", e.toString());
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {}});
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ActivityDetails.class);
                intent.putExtra("id", moviesList.get(position).getId());
                startActivity(intent);
            }});

        return rootView;
    }
    public class FatchMoviesInfo extends AsyncTask<URL, Void, Movie[]> {

        @Override
        protected Movie[] doInBackground(URL... params) {
            HttpURLConnection uriconnect = null;
            BufferedReader reader = null;
            Movie[] MovieList;
            try {
                URL url = params[0];
                Log.v("final_url", url.toString());
                uriconnect = (HttpURLConnection) url.openConnection();
                uriconnect.connect();
                InputStream inputStream = uriconnect.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null)
                    return null;
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                String JsonString = buffer.toString();
                JSONParser parser = new JSONParser();
                MovieList = parser.GetInformation(JsonString);
                Log.v("Nehal", "from thread" + MovieList.length);
                return MovieList;} catch (IOException e) {
                Log.e("network", e.toString());
            } catch (JSONException e) {
                Log.e("nehal", e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Movie[] movies) {
            for (int i = 0; i < movies.length; i++) {
                moviesList.add(movies[i]);
            }
            adapter.notifyDataSetChanged();
        }}}