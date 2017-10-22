package com.example.android.movieslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditMovie extends AppCompatActivity {

    private DatabaseHelper helper = new DatabaseHelper(this) ;
    String title,year,rating ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movie);

        Intent intent = getIntent();

        title = intent.getStringExtra("temp1");
        year = intent.getStringExtra("temp2");
        rating = intent.getStringExtra("temp3");

        EditText et1,et2,et3;

        et1 = (EditText) findViewById(R.id.edit1);
        et2 = (EditText) findViewById(R.id.edit2);
        et3 = (EditText) findViewById(R.id.edit3);

        et1.setText(title);
        et2.setText(year);
        et3.setText(rating);

    }


    public void saveEdit(View view)
    {

        String previous_id = title + year ;

        EditText et_title = (EditText) findViewById(R.id.edit1);
        EditText et_year = (EditText) findViewById(R.id.edit2);
        EditText et_rating= (EditText) findViewById(R.id.edit3);

        String titlestr = et_title.getText().toString();
        String yearstr = et_year.getText().toString();
        String ratingstr = et_rating.getText().toString();

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

        int counter = helper.countSameId(titlestr,yearstr,previous_id);

        if(counter < 2)
        {
            Movie m = new Movie();
            m.setTitle(titlestr);
            m.setYear(yearstr);
            m.setRating(ratingstr);

            helper.updateMovie(m,previous_id);

            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.Toast6), Toast.LENGTH_SHORT);
            toast.show();

            Intent intent = new Intent(EditMovie.this, MainActivity.class);
            startActivity(intent);

        }
        else
        {
            //toast message if there is a movie in database with same title and same year.
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.Toast4), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

    }

}
