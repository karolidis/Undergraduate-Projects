    #include <iostream>
    #include <vector>
    #include <algorithm>
    #include <iterator>
    #include <sstream>
    #include <unistd.h>
    #include <string.h>
    #include <sys/wait.h>
    #include <sys/types.h>
    #include <csignal>

    /*
        PANAGIOTATOS GEORGIOS AEM 2627
        KAROLIDIS THEODOROS AEM 2572
        ANDRAS ANTONIS AEM 2557
        SERAFEIM EMMANOYIL AEM 2553
    */

    using namespace std;

    // this function is called to terminate the current running process on the foreground when Ctrl+C is pressed.
    void signalHandler( int signum )
    {
        cout<<"Process will be terminated!!"<<endl;
        killpg(signum,0);
    }

    // this function get as argument a String that include the command that we want to execute in the terminal
    void run (string a)
    {
        pid_t pid1, pid;
        int p;
        int m,t;
        unsigned int i ;
        bool k=false;

        //with the following code we divide the String that include the command into words and we store it in a vector.
        vector<string> vec;

        istringstream iss(a);
            copy(istream_iterator<string>(iss),
                     istream_iterator<string>(),
                     back_inserter(vec));

        std::vector<char *> argv(vec.size() + 1);

        m=vec.size()-1;



        // with this if statement we terminate the program when the first word of the command is 'exit'.
        if(strcmp(vec[0].c_str(),"exit")==0)
        {
            exit(0);
        }

        // with this if statement we import the words of the command that we have stored in a vector 'vec' into the char* array argv', because the function execvp get as arguments char* array
        if( strcmp(vec[m].c_str(), "&")== 0)
        {
            k=true;

            //in this case we save all the words of the command except of the last one,because the last word is '&' that means to execute the process in the background

            for(i=0;i<vec.size()-1;i++)
            {
                argv[i]=&vec[i][0];
            }
        }
        else
        {
            //in this case we save all the words of the command
            for(i=0;i<vec.size();i++)
            {
                argv[i]=&vec[i][0];
            }
        }

        if(strcmp(vec[0].c_str(), "cd")==0) // with this if statement we check if the first word of the command is 'cd'.
        {
            t=chdir(argv[1] ); //with this command we execute the cd process.if the process is completed,0 will be returned.
            if(t!=0)
            {
                cout<<"FAILED CHANGE DIRECTORY. Check path again!!"<<endl;
            }

        }
        else //we execute the following code when the first word of the command is not 'cd'.
        {
            pid=fork();

            if (pid==0)
            {
                if (k==false) // if k is false it means that we will execute the process in the foreground.
                {
                    execvp (argv[0],argv.data());  // with this command we execute the command.
                    cout<< "No such command"<<endl;
                    exit(0);
                }
                else // if k is true it means that the command includes '&' at the end so we will execute the process in the background
                {
                    //in this case we create a new pid to use it for execute the command on the background

                    pid1=fork();

                    if (pid1==0)
                    {
                        execvp (argv[0],argv.data() ) ; // with this command we execute the command.
                        cout<< "No such command"<<endl;
                        exit(0);
                    }

                    if(pid1>0) //when the process that we execute in the background is completed,there are still some remaining processes running in the background,that were created by this process.
                    {          //with this if statement we terminate all that remaining processes
                        p=getpid();
                        kill(p, SIGKILL);
                    }

                    if(pid1<0)
                    {
                        cout<<"Error with command"<<endl;
                    }
                }
            }

            if (pid>0 ) // with this if statement we wait the process that running on the foreground to complete.
            {
                wait(0);
            }

            if (pid<0)
            {
                cout<<"Error with command"<<endl;
            }
        }

    }

    // in the main function we perform an infinite loop that prints 'MyShell$: ' ,get a String-command from the keyboard(till the String-command is not empty)
    // and call the function 'run' passing as argument the String-command.
    int main()
    {
        signal(SIGINT, signalHandler);
        string comm;
        while(1 )
        {
            cout<<"MyShell$: " ;
            std::getline (std::cin,comm);

            if(comm.find_first_not_of(' ') != std::string::npos)
            {
                run(comm);
            }
        }

        return 0;

    }




