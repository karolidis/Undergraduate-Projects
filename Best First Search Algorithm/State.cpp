#include "State.h"
#include<iostream>

#define WIDTH  7
#define HEIGHT  7

State::State()
{}

State::State(int X, int Y)
{
    robX=X;
    robY=Y;
    for (int i=0;i<WIDTH;i++)
        for (int j=0;j<HEIGHT;j++)
            free[i][j]=true;
}

void State::print()
{
    for(int i=0;i<pathSize-1;i++)
        cout<<i+1<<". "<<path[i]<<endl;
}

bool State::equals(State s)
{
    if (robX==s.robX && robY==s.robY)
            return true;
        return false;

}

void State::setFree(int i, int j, bool f)
{
    free[i][j]=f;
}

bool State::isFree(int x,int y)
{
    if(free[x][y]==true)
        return true;
    else
        return false;
}

int State::getX()
{
    return robX;
}

int State::getY()
{
    return robY;
}

void State::setX(int newX)
{
    robX=newX;
}

void State::setY(int newY)
{
    robY=newY;
}

void State::addAction (string a)
{
    string *temp;
    int i;
    pathSize++;
    temp = new string[pathSize];
    for(i=0;i<pathSize-1;i++)
        temp[i]=path[i];
    temp[i]=a;
    delete path;
    path=temp;
}
