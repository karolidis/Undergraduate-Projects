#include <iostream>
#include <cmath>
#include<stdio.h>
#include<stdlib.h>
#include "State.h"
#include"Stack.h"

#define size 1000

using namespace std;

bool goUp(State s, State &n)
{
    if (s.getY()>0 && s.isFree(s.getX(),s.getY()-1))
    {
        n=s;
        n.setY(n.getY()-1);
        n.addAction("Up");
        return true;
    }
    return false;
}
bool goDown(State s, State &n)
{
    if (s.getY()<HEIGHT && s.isFree(s.getX(),s.getY()+1))
    {
        n=s;
        n.setY(n.getY()+1);
        n.addAction("Down");
        return true;
    }
    return false;
}
bool goLeft(State s, State &n)
{
    if (s.getX()>0 && s.isFree(s.getX()-1,s.getY()))
    {
        n=s;
        n.setX(n.getX()-1);
        n.addAction("Left");
        return true;
    }
    return false;
}
bool goRight(State s, State &n)
{
    if (s.getX()<WIDTH&& s.isFree(s.getX()+1,s.getY()))
    {
        n=s;
        n.setX(n.getX()+1);
        n.addAction("Right");
        return true;
    }
    return false;
}

void expand(const State &s, State* &children, int &num)
{
    State u,d,l,r;
    int i=0;
    children = new State[num];

    num=0;
    if (goUp(s,u))
    {
        children[i++]=u;
        num++;
    }
    if (goDown(s,d))
    {
        children[i++]=d;
        num++;
    }
    if (goLeft(s,l))
    {
        children[i++]=l;
        num++;
    }
    if (goRight(s,r))
    {
        children[i++]=r;
        num++;
    }
}

class Set:private Stack
{
  public:
    Set():Stack()
    {
    }
    bool find (State s)
    {
        node *t=head;
        while (t!=NULL)
        {
            if (t->data.equals(s))
                return true;
            t=t->next;
        }
        return false;
    }
    bool insert(State s)
    {
        if (!find(s))
            return push(s);
        return true;
    }
};

bool BestFirst(Stack &agenda,Set &closed,State &goal,State &solution,int Tx[],int Ty[],int Tm[],int &x)
{
    State s;
    if (agenda.isEmpty())
        return false;
    agenda.pop(s);
    if (s.equals(goal))
    {
        solution = s;
        return true;
    }
    if (!closed.find(s))
    {

        State *children;
        int num;
        expand(s,children,num);

        for(int i=0;i<num;i++)
        {
            Tx[i+1]=children[i].getX();
            Ty[i+1]=children[i].getY();
            Tm[i+1]=abs(children[i].getX()-goal.getX()) + abs(children[i].getY()-goal.getY());
        }

        x=x+num;

        int tempx,tempy,tempm;
        for(int i=1;i<size;i++)
        {
            for(int j=size-1;j>=i;j--)
            {
                if(Tm[j]>Tm[j-1])
                {
                    tempm=Tm[j];
                    Tm[j]=Tm[j-1];
                    Tm[j-1]=tempm;

                    tempx=Tx[j];
                    Tx[j]=Tx[j-1];
                    Tx[j-1]=tempx;

                    tempy=Ty[j];
                    Ty[j]=Ty[j-1];
                    Ty[j-1]=tempy;
                }
            }
        }

        while(!agenda.isEmpty())
        {
            agenda.pop(s);
        }

        for(int m=0;m<x;m++)
        {
            State x(Tx[m],Ty[m]);
            agenda.push(x);
        }

        closed.insert(s);

    }
    return BestFirst(agenda,closed,goal,solution,Tx,Ty,Tm,x);
}

int main()
{
    int Tx[size],Ty[size],Tm[size];
    Tx[0]=1;
    Ty[0]=1;
    Tm[0]=0;
    int x=1;
    Stack agenda;
    Set closed;
    State initial(1,1);
    initial.setFree(1,6,false);
    initial.setFree(2,6,false);
    initial.setFree(3,6,false);
    initial.setFree(4,6,false);
    initial.setFree(4,5,false);
    initial.setFree(4,4,false);
    initial.setFree(5,4,false);
    initial.setFree(6,3,false);
    initial.setFree(5,2,false);
    initial.setFree(5,1,false);
    initial.setFree(4,2,false);
    State goal(6,7);
    agenda.push(initial);
    State solution;
    if((BestFirst(agenda,closed,goal,solution,Tx,Ty,Tm,x))==false)
    {
        cout<<"Den yparxei lysi.";
    }
    else
    {
        cout<<"H lysi einai: "<<endl;
        solution.print();
    }

    return 0;

}
