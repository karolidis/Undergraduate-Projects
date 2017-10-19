#ifndef CLASSINVERTEDINDEX_H
#define CLASSINVERTEDINDEX_H
#include <iostream>
#include <fstream>

struct node
{
	int element;
	node *left;
	node *right;
	int height;
};
typedef struct node *nodeptr;


class ClassInvertedIndex
{
    public:
		void Eisagogi(int,nodeptr &);
		void Diagrafi(int, nodeptr &,int &x);
		int DiagrafiElaxistou(nodeptr &);
		void Inorder(nodeptr p,std::ofstream & ofs,int &x);
		int max(int,int);
		int YpsosAVL(nodeptr);
		nodeptr AristeriPeristrofi(nodeptr &);
		nodeptr DipliAristeri(nodeptr &);
		nodeptr DeksiaPeristrofi(nodeptr &);
		nodeptr DipliDeksia(nodeptr &);

};

#endif // CLASSINVERTEDINDEX_H
