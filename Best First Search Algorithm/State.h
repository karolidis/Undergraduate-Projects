#ifndef STATE_H
#define STATE_H

#include<string>

#define WIDTH  7
#define HEIGHT  7

using namespace std;

class State
{
    int robX,robY;
    bool free[WIDTH][HEIGHT];
    int pathSize=0;
    string *path=NULL;
  public:
    State();
    State(int X, int Y);
   // State (const State &old); //den exei ginei
    void print(); //den exei ginei
    bool equals (State s);
    void setFree(int i, int j, bool f);
    bool isFree(int x,int y);
    int getY();
    int getX();
    void setX(int x);
    void setY(int y);
    void addAction(string movement);
};


#endif // STATE_H
