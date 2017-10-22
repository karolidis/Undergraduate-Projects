package com.example.android.csd_game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int tries = 5 ;
    int random_number ;
    String temp_string;
    int temp_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
        {
            random_number = savedInstanceState.getInt("i4");
            tries = savedInstanceState.getInt("i5");

            TextView tv1 = (TextView) findViewById(R.id.r_tries);
            TextView tv2 = (TextView) findViewById(R.id.help_message);
            EditText et = (EditText) findViewById(R.id.edit_text);

            String temp1 = savedInstanceState.getString("i1");
            String temp2 = savedInstanceState.getString("i2");
            String temp3 = savedInstanceState.getString("i3");

            tv1.setText(temp1);
            tv2.setText(temp2);
            et.setText(temp3);
        }
        else
        {
            Random rand = new Random();
            random_number = rand.nextInt(100-1) + 1 ;

            TextView tv = (TextView) findViewById(R.id.r_tries);
            tv.setText(getString(R.string.remaining_tries) + " " + tries);
        }
    }

    public void check(View view)
    {
        if(tries > 0 )
        {
            EditText et = (EditText) findViewById(R.id.edit_text);
            temp_string = et.getText().toString();

            if(temp_string.equals("") == true)
            {
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.wrong_message_1), Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            temp_number = Integer.parseInt(temp_string);

            if(temp_number < 1 || temp_number > 100)
            {
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.wrong_message_2), Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if(temp_number == random_number)
            {
                TextView tv1 = (TextView) findViewById(R.id.r_tries);
                tv1.setText(getString(R.string.win_message));

                TextView tv2 = (TextView) findViewById(R.id.help_message);
                tv2.setText("");

                tries = 0 ;
            }
            else
            {
                tries = tries - 1 ;

                if(tries <= 0)
                {
                    TextView tv1 = (TextView) findViewById(R.id.r_tries);
                    tv1.setText(getString(R.string.lose_message) + " " + random_number + "." );

                    TextView tv2 = (TextView) findViewById(R.id.help_message);
                    tv2.setText("");

                    return;
                }

                if(temp_number < random_number)
                {
                    TextView tv1 = (TextView) findViewById(R.id.r_tries);
                    tv1.setText(getString(R.string.remaining_tries)+ " " + tries);

                    TextView tv2 = (TextView) findViewById(R.id.help_message);
                    tv2.setText(getString(R.string.help_message_1));

                    return;
                }

                if(temp_number > random_number)
                {
                    TextView tv1 = (TextView) findViewById(R.id.r_tries);
                    tv1.setText(getString(R.string.remaining_tries)+ " " + tries);

                    TextView tv2 = (TextView) findViewById(R.id.help_message);
                    tv2.setText(getString(R.string.help_message_2));

                    return;
                }

            }
        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.restart_message), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
    }

    public void restart(View view)
    {
        Random rand = new Random();
        random_number = rand.nextInt(100-1) + 1 ;

        tries = 5 ;

        String ts = getString(R.string.remaining_tries);

        TextView tv1 = (TextView) findViewById(R.id.r_tries);
        tv1.setText(ts + " " + tries);

        TextView tv2 = (TextView) findViewById(R.id.help_message);
        tv2.setText("");

        EditText et = (EditText) findViewById(R.id.edit_text);
        et.setText("");

    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);

        TextView tv1 = (TextView) findViewById(R.id.r_tries);
        TextView tv2 = (TextView) findViewById(R.id.help_message);
        EditText et = (EditText) findViewById(R.id.edit_text);

        String temp1 = tv1.getText().toString();
        String temp2 = tv2.getText().toString();
        String temp3 = et.getText().toString();

        bundle.putString("i1",temp1);
        bundle.putString("i2",temp2);
        bundle.putString("i3",temp3);
        bundle.putInt("i4",random_number);
        bundle.putInt("i5",tries);

    }

}
