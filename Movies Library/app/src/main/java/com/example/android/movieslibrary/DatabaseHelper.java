package com.example.android.movieslibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Karol on 6/5/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION = 1 ;
    private static final String DATABASE_NAME = "movies.db" ;
    private static final String TABLE_NAME = "movies" ;
    private static final String COLUMN_ID = "id" ;
    private static final String COLUMN_TITLE = "title" ;
    private static final String COLUMN_YEAR = "year" ;
    private static final String COLUMN_RATING = "rating" ;
    SQLiteDatabase db ;

    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    private static final String TABLE_CREATE = "create table movies (id text primary key , " +
            "title text not null , year text not null , rating text not null)";

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        this.db = db ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME ;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertMovie(Movie m)
    {
        String tempstr = m.getTitle()+m.getYear();
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID , tempstr);
        values.put(COLUMN_TITLE , m.getTitle());
        values.put(COLUMN_YEAR , m.getYear());
        values.put(COLUMN_RATING , m.getRating());

        db.insert(TABLE_NAME , null , values);

    }

    public boolean searchId(String temp1, String temp2)
    {
        db = this.getReadableDatabase();

        String possibleid = temp1+temp2 ;

        String query = "select id from " + TABLE_NAME ;
        Cursor cursor = db.rawQuery(query , null);

        String tempid;
        boolean flag = false ;

        if(cursor.moveToFirst())
        {
            do
            {
                tempid =cursor.getString(0);

                if(tempid.equals(possibleid))
                {
                    flag = true ;
                    break;
                }

            }
            while (cursor.moveToNext());
        }

        return flag ;

    }

    public ArrayList<Movie> getListContents()
    {
        ArrayList<Movie> list = new ArrayList<>();
        db = this.getWritableDatabase();
        Cursor cursor = db.query("movies", null,null, null, null, null, null);
        // looping through all rows and adding to list
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                Movie m = new Movie(cursor.getString(1), cursor.getString(2), cursor.getString(3));
                list.add(m);
            }
        }
        return list;
    }

    public int updateMovie(Movie m,String pid)
    {
        String temp1 = m.getTitle();
        String temp2 = m.getYear();
        String temp3 = m.getRating();

        db = this.getWritableDatabase();
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put(DatabaseHelper.COLUMN_ID,temp1+temp2);
        updatedValues.put(DatabaseHelper.COLUMN_TITLE, temp1);
        updatedValues.put(DatabaseHelper.COLUMN_YEAR, temp2);
        updatedValues.put(DatabaseHelper.COLUMN_RATING, temp3);

        return db.update(DatabaseHelper.TABLE_NAME, updatedValues, DatabaseHelper.COLUMN_ID + " = ?", new String[]{String.valueOf(pid)});
    }


    public ArrayList<Movie> Best3()
    {
        ArrayList<Movie> list = new ArrayList<>();

        list = this.getListContents();

        Collections.sort(list, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                return  Integer.valueOf(m1.getRating()).compareTo(Integer.valueOf(m2.getRating()));
            }

        });

        ArrayList<Movie> top3 = new ArrayList<>();

        int listsize = list.size();

        if(listsize == 0)
        {
            return top3;
        }
        else if(listsize == 1)
        {
            top3.add(list.get(0));
            return top3;
        }
        else if(listsize == 2)
        {
            top3.add(list.get(1));
            top3.add(list.get(0));
            return top3;
        }
        else
        {
            top3.add(list.get(listsize-1));
            top3.add(list.get(listsize-2));
            top3.add(list.get(listsize-3));

            return top3;
        }

    }

    public ArrayList<Movie> Worst3()
    {
        ArrayList<Movie> list = new ArrayList<>();

        list = this.getListContents();

        Collections.sort(list, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                return  Integer.valueOf(m1.getRating()).compareTo(Integer.valueOf(m2.getRating()));
            }

        });

        ArrayList<Movie> worst3 = new ArrayList<>();

        int listsize = list.size();

        if(listsize == 0)
        {
            return worst3;
        }
        else if(listsize == 1)
        {
            worst3.add(list.get(0));
            return worst3;
        }
        else if(listsize == 2)
        {
            worst3.add(list.get(0));
            worst3.add(list.get(1));
            return worst3;
        }
        else
        {
            worst3.add(list.get(0));
            worst3.add(list.get(1));
            worst3.add(list.get(2));

            return worst3;
        }

    }

    public int countSameId(String s1,String s2,String pid)
    {
        int counter = 0 ;

        db = this.getReadableDatabase();

        String possibleid = s1+s2 ;

        if(!(possibleid.equals(pid)))
        {
            counter = 1;
        }

        String query = "select id from " + TABLE_NAME ;
        Cursor cursor = db.rawQuery(query , null);

        String tempid;

        if(cursor.moveToFirst())
        {
            do
            {
                tempid =cursor.getString(0);

                if(tempid.equals(possibleid))
                {
                    counter = counter + 1 ;
                }

            }
            while (cursor.moveToNext());
        }

        return counter;
    }

    public void deleteMovie(Movie m)
    {
        String id = m.getTitle()+m.getYear();

        db = this.getWritableDatabase();
        db.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
        db.close();
    }

}

