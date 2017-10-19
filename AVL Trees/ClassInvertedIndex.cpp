#include "ClassInvertedIndex.h"
#include <iostream>
#include<cctype>
#include <stdlib.h>
#include <conio.h>
#include <fstream>

using namespace std;

void ClassInvertedIndex::Eisagogi(int x,nodeptr &p)
{
	if (p == NULL)
	{
		p = new node;
		p->element = x;
		p->left=NULL;
		p->right = NULL;
		p->height=0;

	}
	else
	{
		if (x<p->element)
		{
			Eisagogi(x,p->left);
			if ((YpsosAVL(p->left) - YpsosAVL(p->right))==2)
			{
				if (x < p->left->element)
				{
					p=AristeriPeristrofi(p);
				}
				else
				{
					p = DipliAristeri(p);
				}
			}
		}
		else if (x>p->element)
		{
			Eisagogi(x,p->right);
			if ((YpsosAVL(p->right) - YpsosAVL(p->left))==2)
			{
				if (x > p->right->element)
				{
					p=DeksiaPeristrofi(p);
				}
				else
				{
					p = DipliDeksia(p);
				}
			}
		}
}
int m,n,d;
m=YpsosAVL(p->left);
n=YpsosAVL(p->right);
d=max(m,n);
p->height = d + 1;
}

int ClassInvertedIndex::max(int value1, int value2)
{
	return ((value1 > value2) ? value1 : value2);
}

int ClassInvertedIndex::YpsosAVL(nodeptr p)
{
	int t;
	if (p == NULL)
	{
		return -1;
	}
	else
	{
		t = p->height;
		return t;
	}
}

nodeptr ClassInvertedIndex:: AristeriPeristrofi(nodeptr &p1)
{
	nodeptr p2;
	p2 = p1->left;
	p1->left = p2->right;
	p2->right = p1;
	p1->height = max(YpsosAVL(p1->left),YpsosAVL(p1->right)) + 1;
	p2->height = max(YpsosAVL(p2->left),p1->height) + 1;
	return p2;
}

nodeptr ClassInvertedIndex:: DeksiaPeristrofi(nodeptr &p1)
{
	nodeptr p2;
	p2 = p1->right;
	p1->right = p2->left;
	p2->left = p1;
	p1->height = max(YpsosAVL(p1->left),YpsosAVL(p1->right)) + 1;
	p2->height = max(p1->height,YpsosAVL(p2->right)) + 1;
	return p2;
}

nodeptr ClassInvertedIndex:: DipliAristeri(nodeptr &p1)
{
	p1->left=DeksiaPeristrofi(p1->left);
	return AristeriPeristrofi(p1);
}

nodeptr ClassInvertedIndex::DipliDeksia(nodeptr &p1)
{
	p1->right = AristeriPeristrofi(p1->right);
	return DeksiaPeristrofi(p1);
}

void ClassInvertedIndex::Inorder(nodeptr p, ofstream & out, int & x)
{
	if (p!=NULL)
	{
	    x++;
		Inorder(p->left,out,x);
		out<<p->element<<"\t";
		Inorder(p->right,out,x);
	}
}

int ClassInvertedIndex::DiagrafiElaxistou(nodeptr &p)
{
	int c;
	if (p->left == NULL)
	{
		c=p->element;
		p=p->right;
		return c;
	}
	else
	{
		c=DiagrafiElaxistou(p->left);
		return c;
	}
}

void ClassInvertedIndex::Diagrafi(int x,nodeptr &p,int & z)
{
	nodeptr d;
	if (p==NULL)
    {
        z=1;
    }
	else if ( x < p->element)
	{
		Diagrafi(x,p->left,z);
	}
	else if (x > p->element)
	{
		Diagrafi(x,p->right,z);
	}
	else if ((p->left == NULL) && (p->right == NULL))
	{
		d=p;
		free(d);
		p=NULL;
	}
	else if (p->left == NULL)
	{
		d=p;
		free(d);
		p=p->right;
	}
	else if (p->right == NULL)
	{
		d=p;
		p=p->left;
		free(d);
	}
	else
	{
		p->element = DiagrafiElaxistou(p->right);
	}
}
