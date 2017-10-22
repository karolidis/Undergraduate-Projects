package com.example.android.movieslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShowMovie extends AppCompatActivity {

    private DatabaseHelper helper = new DatabaseHelper(this) ;
    String title,year,rating ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movie);

        Intent intent = getIntent();

        title = intent.getStringExtra("title");
        year = intent.getStringExtra("year");
        rating = intent.getStringExtra("rating");

        TextView t1,t2,t3;

        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);

        t1.setText(title);
        t2.setText(year);
        t3.setText(rating);

    }

    public void delete(View view)
    {
        Movie movie = new Movie(title,year,rating);

        helper.deleteMovie(movie);

        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.Toast7), Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(ShowMovie.this, MainActivity.class);
        startActivity(intent);

    }

    public void goEdit(View view)
    {
        Intent intent = new Intent(ShowMovie.this, EditMovie.class);
        intent.putExtra("temp1",title);
        intent.putExtra("temp2",year);
        intent.putExtra("temp3",rating);
        startActivity(intent);

    }


}
