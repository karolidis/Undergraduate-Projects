package com.example.android.movieslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add_new_movie(View view)
    {
        Intent intent = new Intent(this, AddMovie.class);
        startActivity(intent);
    }

    public void show_all_movies(View view)
    {
        Intent intent = new Intent(this, AllMovies.class);
        startActivity(intent);
    }

    public void show_best3_movies(View view)
    {
        Intent intent = new Intent(this,Best3.class);
        startActivity(intent);
    }

    public void show_worst3_movies(View view)
    {
        Intent intent = new Intent(this,Worst3.class);
        startActivity(intent);
    }

}
