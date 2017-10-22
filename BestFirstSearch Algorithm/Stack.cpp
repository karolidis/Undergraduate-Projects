#include "Stack.h"

Stack::Stack()
{
    head=NULL;
}

Stack::~Stack()
{
    node *t;
    while (head!=NULL)
    {
        t=head;
        head=head->next;
        delete(t);
    }
}

bool Stack::push(State s)
{
    node *a;
    a = new node;
    if (a==NULL)
        return false;
    a->data=s;
    a->next=head;
    head = a;
    return true;
}

bool Stack::pop(State &s)
{
    if (head==NULL)
        return false;
    s=head->data;
    node *temp = head;
    head= head->next;
    delete temp;
    return true;
}

bool Stack::isEmpty()
{
    return (head==NULL);
}



