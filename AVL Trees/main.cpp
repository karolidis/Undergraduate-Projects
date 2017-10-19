#include <iostream>
#include<cctype>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <fstream>
#include <string.h>
#include "ClassInvertedIndex.h"

using namespace std;

int main()
{
	int a,b,temp,j,i=0,n,meg=0,tempmeg=0;
	string A;
	char B[11];
	ifstream f1,f2,f3,f4;
	int size=0;
	FILE *fp;

	ClassInvertedIndex *AVL = new ClassInvertedIndex();

    cout<<"Diavazontai ta dedomena tou arxeiou 'input.txt'. \n";

    f1.open("commands.txt");

    f2.open("input.txt");

    if(f2)
    {
        while(!f2.eof())
        {
            f2>>a>>b ;
            size++ ;
        }
    }
    else
    {
        cout<<"Could not open the file"<<endl;
        return 1;
    }
    f2.close();

    nodeptr Mroot=NULL;
    nodeptr* root = new nodeptr[size];
    int* counter = new int[size];

    for (j=0;j<size+1;j++)
    {
        root[j] = NULL;
        counter[j] = 0;
    }

    cout<<"\nDimiourgountai ta AVL dentra.\n";

    if(f1)
    {
        while (!f1.eof())
        {
            getline(f1,A);

            if(A=="READ_DATA input.txt")
            {
                f3.open("input.txt");
                if(f3)
                {
                    while (!f3.eof())
                    {
                        f3>>a>>b ;

                        if ( a >= b)
                        {
                            tempmeg = a ;
                        }
                        else
                        {
                            tempmeg = b ;
                        }

                        if(tempmeg > meg)
                        {
                            meg = tempmeg ;
                        }

                        if(temp!=a)
                        {
                            i++;
                            temp=a;
                            AVL-> Eisagogi(b,root[temp]);
                            n++;
                        }
                        else
                        {
                            AVL-> Eisagogi(b,root[temp]);
                        }

                        AVL->Eisagogi(a,Mroot);
                        AVL->Eisagogi(b,Mroot);

                        counter[temp]++;
                    }
                    f3.close();
                }
                else
                {
                    cout<<"Could not open the file"<<endl;
                    return 1;
                }
            }
        }
    }
    else
    {
        cout<<"Could not open the file"<<endl;
        return 1;
    }

    f1.close();

    fp=fopen("commands.txt","r");

    while (!feof(fp))
    {
        fscanf(fp,"%s%d%d",B,&a,&b);

        if(strcmp(B,"DELETE_LINK")==0)
        {
            int z=0;
            AVL[a].Diagrafi(b,root[a],z);
            if(z!=1)
            {
                counter[a]-- ;
            }
        }
        if(strcmp(B,"INSERT_LINK")==0)
        {
            AVL[a].Eisagogi(b,root[a]);
            counter[a]++;
        }
    }

    fclose(fp);

    f4.open("commands.txt");

    if(f4)
    {
        while (!f4.eof())
        {
            getline(f4,A);

            if(A=="WRITE_INDEX output.txt")
            {
                cout<<"\nTa stoixeia typonontai sto arxeio 'output.txt'.";
                cout<<"\n";

                ofstream out;
                out.open("output.txt",ios::out);

                for(a=0;a<meg+1;a++)
                {
                    int x = 0;
                    out<<a<<"\t";
                    out<<counter[a]<<"\t";
                    AVL[a].Inorder(root[a],out,x);
                    if(x == 0)
                    {
                        out<<"Den yparxoun geitonikoi komvoi";
                    }
                    out<<"\n";
                }
            }
        }
    }
    else
    {
        cout<<"Could not open the file"<<endl;
        return 1;
    }

    f4.close();

    cout<<"\nI diadikasia oloklirothike me epityxia!!!";
    cout<<"\n";

    return 0;
}
