package com.example.android.movieslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllMovies extends AppCompatActivity {

    private DatabaseHelper helper = new DatabaseHelper(this) ;
    private ArrayList<Movie> movies ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);

        Intent intent = getIntent();

        ListView listView = (ListView) findViewById(R.id.listView);

        movies = helper.getListContents();

        if(movies.size() == 0)
        {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.Toast8), Toast.LENGTH_SHORT);
            toast.show();
        }

        CustomAdapter adapter = new CustomAdapter(this , R.layout.list_item , movies);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String temp1 = movies.get(position).getTitle();
                String temp2 = movies.get(position).getYear();
                String temp3 = movies.get(position).getRating();
                Intent intent = new Intent(AllMovies.this, ShowMovie.class);
                intent.putExtra("title",temp1);
                intent.putExtra("year",temp2);
                intent.putExtra("rating",temp3);
                startActivity(intent);
            }

        });

    }
}
