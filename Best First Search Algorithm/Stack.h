#ifndef STACK_H
#define STACK_H

#include"node.h"

class Stack
{
    protected:
        node *head;
    public:
        Stack();
        ~Stack();
        bool push(State s);
        bool pop(State &s);
        bool isEmpty();
};

#endif // STACK_H
