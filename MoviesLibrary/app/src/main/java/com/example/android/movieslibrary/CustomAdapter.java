package com.example.android.movieslibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Karol on 7/5/2017.
 */

public class CustomAdapter extends ArrayAdapter<Movie>
{
    private Context myContext;
    private int myResource;

    public CustomAdapter(Context context, int resource , ArrayList<Movie> movies)
    {
        super(context,resource,movies);
        myContext = context;
        myResource = resource;
    }

    @Override
    public View getView(int position, View customView, ViewGroup parent)
    {
        //get movie information
        String title = getItem(position).getTitle();
        String year = getItem(position).getYear();
        String rating = getItem(position).getRating();

        //create movie object
        Movie m = new Movie(title,year,rating);

        LayoutInflater inflater = LayoutInflater.from(myContext);

        customView = inflater.inflate(myResource, parent , false);

        TextView tvTitle =(TextView) customView.findViewById(R.id.tv1);
        TextView tvYear =(TextView) customView.findViewById(R.id.tv2);
        TextView tvRating =(TextView) customView.findViewById(R.id.tv3);

        tvTitle.setText(title);
        tvYear.setText(year);
        tvRating.setText(rating);

        return customView;

    }

}