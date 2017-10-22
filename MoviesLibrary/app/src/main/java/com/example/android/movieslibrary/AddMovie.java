package com.example.android.movieslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddMovie extends AppCompatActivity
{

    private DatabaseHelper helper = new DatabaseHelper(this) ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        Intent intent = getIntent();

    }

    public void save(View view)
    {

        EditText title = (EditText) findViewById(R.id.et1);
        EditText year = (EditText) findViewById(R.id.et2);
        EditText rating= (EditText) findViewById(R.id.et3);

        String titlestr = title.getText().toString();
        String yearstr = year.getText().toString();
        String ratingstr = rating.getText().toString();

        if( titlestr.equals("") || yearstr.equals("") || ratingstr.equals(""))
        {
            //toast message if a field is not completed.
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.Toast1), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        int vathmos = Integer.parseInt(ratingstr);

        if(vathmos<0 || vathmos >10)
        {
            //toast message if rating is out of bounds 0-10.
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.Toast2), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        boolean flag = helper.searchId(titlestr , yearstr);

        if(flag == true)
        {
            //toast message if there is a movie in database with same title and same year.
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.Toast4), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        //insert movie to the database.
        Movie m = new Movie();
        m.setTitle(titlestr);
        m.setYear(yearstr);
        m.setRating(ratingstr);

        helper.insertMovie(m);

        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.Toast3), Toast.LENGTH_SHORT);
        toast.show();

    }

}

