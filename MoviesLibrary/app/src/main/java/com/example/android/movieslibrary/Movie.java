package com.example.android.movieslibrary;

/**
 * Created by Karol on 6/5/2017.
 */

public class Movie
{

    String title,year,rating ;

    public Movie(){}

    public Movie(String s1,String s2,String s3)
    {
        title = s1 ;
        year = s2 ;
        rating = s3 ;
    }

    public void setTitle(String s)
    {
        title = s ;
    }

    public void setYear(String s)
    {
        year = s ;
    }

    public void setRating(String s)
    {
        rating = s ;
    }

    public String getTitle()
    {
        return title ;
    }

    public String getYear()
    {
        return year ;
    }

    public String getRating()
    {
        return rating ;
    }

}