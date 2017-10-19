#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define ML 30  //ML=Max word length
#define SIZE 5000 //i use it in function MegethosPinaka() to calculate the number of words that the vocabulary contains.

//Whenever i use free() i release the memory that i have dynamically bind.
//Whenever i use malloc() and realloc() functions i bind dynamically the memory that is needed for vocabulary's operations execution.

int ShowMenu() //With this function i show the menu to the user and let him decide what operation he we want to execute.
{
    int s;

    printf("\nMenu:\n\n");
    printf("1. Eisagogi neou orou sto leksiko.\n");
    printf("2. Tropopoihsi orou.\n");
    printf("3. Diagrafi orou.\n");
    printf("4. Metafrasi leksis.\n");
    printf("5. Metafrasi protasis.\n");
    printf("6. Eksodos.\n");
    printf("\n");
    do
    {
        printf("Ti tha thelate na kanete apo ta parapano?");
        scanf("%d",&s);
        fflush(stdin);
    }
    while(s!=1 && s!=2 && s!=3 && s!=4 && s!=5 && s!=6);

    return s;
}

int MegethosPinaka() //With this function i calculate the number of words that the vocabulary contains.
{
    FILE *fp;
    int count,i;
    char *A;

    A=(char*)malloc(SIZE*sizeof(char));
    count=0;
    fp=fopen("swstoleksiko.txt","r");
    for(i=0;i<SIZE;i++)
    {
        fscanf(fp,"%s",&A[i]);
        count++;
        if(feof(fp))
            break;
    }
    fclose(fp);
    free(A);

    return count;
}

char **DimiourgiaPinaka(int s)/*With this function i create dynamically a pointers table.Table's  length is equal to number of words that the vocabulary contains.
                                Then every pointer turns dynamically into table.In the new tables i save the vocabulary's words. */
{
    FILE *fp;
    int i,len;
    char **A;

    fp=fopen("swstoleksiko.txt" , "r");
    A=(char**)malloc(s*sizeof(char*));
    if(A==NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }
    for(i=0;i<s;i++)
    {
        A[i]=(char*)malloc(ML*sizeof(char));
        if(A[i]==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
    }
    for(i=0;i<s;i++)
    {
        fscanf(fp,"%s",A[i]);
        len=strlen(A[i]);
        A[i]=(char*)realloc(A[i],(len+1)*sizeof(char));
    }
    fclose(fp);

    return A;
}

char **EisagogiNeouOrou(char **A,int s)/*Withi this function user add a new word to the vocabulary.
                                        There is also a check to see if the word is already in the vocabulary.*/
{
    int i,flag,length;
    char *B,*C;

    printf("\nEisagogi Neou Orou:\n");
    printf("\nDoste tin elliniki leksi pou thelete na prosthesete sto leksiko:");
    B=(char*)malloc(ML*sizeof(char));
    if(B==NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }
    gets(B);
    fflush(stdin);
    length=strlen(B);
    B=(char*)realloc(B,(length+1)*sizeof(char));
    if(B==NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }
    printf("\nDoste tin antistoixi aggliki leksi pou thelete na prosthesete sto leksiko:");
    C=(char*)malloc(ML*sizeof(char));
    if(C==NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }
    gets(C);
    fflush(stdin);
    length=strlen(C);
    C=(char*)realloc(C,(length+1)*sizeof(char));
    if(C==NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }
    for(i=0;i<s;i++)
    {
        flag=strcmp(B,A[i]);
        if(flag==0)
            break;
    }
    if(flag==0)
    {
        printf("\nH leksi pou thelete na prosthesete yparxei idi sto leksiko!\n");
    }
    else
    {
        A=(char**)realloc(A,(s+2)*sizeof(char*));
        if(A==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        for(i=s;i<=s+1;i++)
        {
            A[i]=(char*)malloc(ML*sizeof(char));
            if(A[i]==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
        }
        A[s]=B;
        A[s+1]=C;
        printf("\nI eisagogi tou neou orou oloklirothike me epityxia!\n");
    }
    free(B);
    free(C);

    return A;
}

char **TropopoihshOrou(char **A,int s)/*With this function user can a edit a vocabulary term.*/
{
    char *B,*C,*D;
    int flag,i,length,pos,epilogi;

    printf("\nTropopoihsh Orou:\n");
    printf("\nTon oro pou epithymeite na tropopoihsete thelete na ton dosete ws elliniki i ws aggliki leksi?\n");
    printf("\n1.Tropopoihsh orou dinontas elliniki leksi.\n");
    printf("\n2.Tropopoihsh orou dinontas aggliki leksi.\n");
    do
    {
        printf("\nDialekste ton tropo me ton opoio epithymeite na tropopoihsete ton oro:");
        scanf("%d",&epilogi);
        fflush(stdin);
    }
    while(epilogi!=1 && epilogi!=2);
    if(epilogi==1)
    {
        printf("\nDoste tin elliniki leksi pou epithymeite na tropopoihsete:");
        B=(char*)malloc(ML*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        gets(B);
        fflush(stdin);
        length=strlen(B);
        B=(char*)realloc(B,(length+1)*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        for(i=0;i<s;i=i+2)
        {
            flag=strcmp(B,A[i]);
            if(flag==0)
            {
                pos=i;
                break;
            }
        }
        if(flag!=0)
            flag=1;
        if(flag==1)
        {
            printf("\nH leksi pou epithymeite na tropopoihsete den yparxei sto leksiko!\n");
        }
        else
        {
            printf("\nDoste tin tropoihmeni elliniki leksi:");
            C=(char*)malloc(ML*sizeof(char));
            if(C==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            gets(C);
            fflush(stdin);
            length=strlen(C);
            C=(char*)realloc(C,(length+1)*sizeof(char));
            if(C==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            A[pos]=(char*)realloc(A[pos],(length+1)*sizeof(char));
            if(A[pos]==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            A[pos]=C;
            printf("\nDoste tin antistoixi tropoihmeni aggliki leksi:");
            D=(char*)malloc(ML*sizeof(char));
            if(D==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            gets(D);
            fflush(stdin);
            length=strlen(D);
            D=(char*)realloc(D,(length+1)*sizeof(char));
            if(D==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            A[pos+1]=(char*)realloc(A[pos+1],(length+1)*sizeof(char));
            if(A[pos+1]==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            A[pos+1]=D;
            printf("\nH tropopoihsh tou orou oloklirothike me epityxia!\n");
        }
    }
    else
    {
        printf("\nDoste tin aggliki leksi pou epithymeite na tropopoihsete:");
        B=(char*)malloc(ML*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        gets(B);
        fflush(stdin);
        length=strlen(B);
        B=(char*)realloc(B,(length+1)*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        for(i=1;i<s;i=i+2)
        {
            flag=strcmp(B,A[i]);
            if(flag==0)
            {
                pos=i;
                break;
            }
        }
        if(flag!=0)
        flag=1;
        if(flag==1)
        {
            printf("\nH leksi pou epithymeite na tropopoihsete den yparxei sto leksiko!\n");
        }
        else
        {
            printf("\nDoste tin tropoihmeni elliniki leksi:");
            C=(char*)malloc(ML*sizeof(char));
            if(C==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            gets(C);
            fflush(stdin);
            length=strlen(C);
            C=(char*)realloc(C,(length+1)*sizeof(char));
            if(C==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            A[pos-1]=(char*)realloc(A[pos-1],(length+1)*sizeof(char));
            if(A[pos-1]==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            A[pos-1]=C;
            printf("\nDoste tin antistoixi tropoihmeni aggliki leksi:");
            D=(char*)malloc(ML*sizeof(char));
            if(D==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            gets(D);
            fflush(stdin);
            length=strlen(D);
            D=(char*)realloc(D,(length+1)*sizeof(char));
            if(D==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            A[pos]=(char*)realloc(A[pos],(length+1)*sizeof(char));
            if(A[pos]==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            A[pos]=D;
            printf("\nH tropopoihsh tou orou oloklirothike me epityxia!\n");
        }
    }
    free(B);
    free(C);
    free(D);

    return A;
}

char **DiagrafiOrou(char **A,int s)/*With this function user can delete a term of the vocabulary.*/
{
    char *B;
    int flag,epilogi,length,i,pos;

    printf("\nDiagrafi Orou:\n");
    printf("\nTon oro pou epithymeite na diagrapsete thelete na ton dosete ws elliniki i ws aggliki leksi?\n");
    printf("\n1.Diagrafi orou dinontas elliniki leksi.\n");
    printf("\n2.Diagrafi orou dinontas aggliki leksi.\n");
    do
    {
        printf("\nDialekste ton tropo me ton opoio epithymeite na diagrapsete ton oro:");
        scanf("%d",&epilogi);
        fflush(stdin);
    }
    while(epilogi!=1 && epilogi!=2);
    if(epilogi==1)
    {
        printf("\nDoste tin elliniki leksi pou epithymeite na diagrapsete:");
        B=(char*)malloc(ML*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        gets(B);
        fflush(stdin);
        length=strlen(B);
        B=(char*)realloc(B,(length+1)*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        for(i=0;i<s;i=i+2)
        {
            flag=1;
            flag=strcmp(B,A[i]);
            if(flag==0)
            {
                pos=i;
                break;
            }
        }
        if(flag!=0)
            flag=1;
        if(flag==1)
        {
            printf("\nH leksi pou epithymeite na diagrapsete den yparxei sto leksiko!\n");
        }
        else
        {
            for(i=pos+2;i<s;i++)
            {
                strcpy(A[i-2],A[i]);
            }
            s=s-2;
            A=(char**)realloc(A,s*sizeof(char*));
            if(A==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            printf("\nH diagrafi tou orou oloklirothike me epityxia!\n");
        }
    }
    else
    {
        printf("\nDoste tin aggliki leksi pou epithymeite na diagrapsete:");
        B=(char*)malloc(ML*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        gets(B);
        fflush(stdin);
        length=strlen(B);
        B=(char*)realloc(B,(length+1)*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        for(i=1;i<s;i=i+2)
        {
            flag=1;
            flag=strcmp(B,A[i]);
            if(flag==0)
            {
                pos=i;
                break;
            }
        }
        if(flag!=0)
            flag=1;
        if(flag==1)
        {
            printf("\nH leksi pou epithymeite na diagrapsete den yparxei sto leksiko!\n");
        }
        else
        {
            for(i=pos+1;i<s;i++)
            {
                strcpy(A[i-2],A[i]);
            }
            s=s-2;
            A=(char**)realloc(A,s*sizeof(char*));
            if(A==NULL)
            {
                puts("Den yparxei diathesimos xwros stin mnimi!");
                exit(1);
            }
            printf("\nH diagrafi tou orou oloklirothike me epityxia!\n");
        }
    }
    free(B);

    return A;
}

void MetafrasiLeksis(char **A,int s) /*With this function user can translate a word if this word exists in
                                        the vocabulary*/
{
    char *B;
    int i,length,flag,pos,epilogi;

    flag=1;
    printf("\nMetafrasi Leksis:\n");
    printf("\n1.Metafrasi leksis apo ta ellinika sta agglika.\n");
    printf("\n2.Metafrasi leksis apo ta agglika sta ellinika.\n");
    do
    {
        printf("\nPoia apo tis 2 epiloges tha thelate na pragmatopoihsete:");
        scanf("%d",&epilogi);
        fflush(stdin);
    }
    while(epilogi!=1 && epilogi!=2);
    if(epilogi==1)
    {
        printf("\nDoste tin elliniki leksi pou epithymeite na metafrasete:");
        B=(char*)malloc(ML*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        gets(B);
        fflush(stdin);
        length=strlen(B);
        B=(char*)realloc(B,(length+1)*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        for(i=0;i<s;i=i+2)
        {
            flag=strcmp(B,A[i]);
            if(flag==0)
            {
                pos=i;
                break;
            }
        }
        if(flag!=0)
            flag=1;
        if(flag==1)
            printf("\nH leksi pou epithymeite na metafrasete den yparxei sto leksiko!\n");
        else
            printf("\n%s = %s\n",A[pos],A[pos+1]);
    }
    else
    {
        printf("\nDoste tin aggliki leksi pou epithymeite na metafrasete:");
        B=(char*)malloc(ML*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        gets(B);
        fflush(stdin);
        length=strlen(B);
        B=(char*)realloc(B,(length+1)*sizeof(char));
        if(B==NULL)
        {
            puts("Den yparxei diathesimos xwros stin mnimi!");
            exit(1);
        }
        for(i=1;i<s;i=i+2)
        {
            flag=strcmp(B,A[i]);
            if(flag==0)
            {
                pos=i;
                break;
            }
        }
        if(flag!=0)
            flag=1;
        if(flag==1)

            printf("\nH leksi pou epithymeite na metafrasete den yparxei sto leksiko!\n");
        else
            printf("\n%s = %s\n",A[pos],A[pos-1]);
    }
}

void MetafrasiProtasis(char **A,int s) /*With this function user can translate a sentence word by word.If a sentence's
                                        word don't exist in the vocabulary then the program prints "*" */
{
    char *B,*token;
    const char string[]=" "; /*i use " " as a key to split the sentence's words.*/
    int length,i,pos,flag;

    printf("\nMetafrasi Protasis:\n");
    B=(char*)malloc(SIZE*sizeof(char));
    if(B==NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }
    printf("\nDoste tin protasi pou thelete na metafrasete:");
    gets(B);
    fflush(stdin);
    length=strlen(B);
    B=(char*)realloc(B,(length+1)*sizeof(char));
    if(B==NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }
    token = strtok(B, string);
    while( token != NULL )
    {
        for(i=0;i<s;i++)
        {
            flag=1;
            if(strcmp(token,A[i])==0)
            {
                flag=0;
                pos=i;
                break;
            }
        }
        if (flag==1)
            printf("* ");
        else
        {
            if(pos%2==0)
            {
                printf("%s ",A[pos+1]);
            }
            else
            {
                printf("%s ",A[i-1]);
            }
        }
        token = strtok(NULL, string);
    }
    free(B);
}

void Eksodos(char **A,char **B,int s,int s_arx) /* With this function user exit the program.At the same time he decides
                                                    if you want to save possible changes in the vocabulary.*/
{
    FILE *fp;
    int epilogi,i;

    fp=fopen("swstoleksiko.txt" , "w");
    printf("\nEksodos:\n");
    printf("\nThelete na apothikeusete to pithanon tropoihmeno leksiko?\n");
    printf("\n1.Nai\n");
    printf("\n2.Oxi\n");
    do
    {
        printf("\nPoia apo tis 2 epiloges tha thelate na pragmatopoihsete:");
        scanf("%d",&epilogi);
        fflush(stdin);
    }
    while(epilogi!=1 && epilogi!=2);
    if(epilogi==1)
    {
        for(i=0;i<s-1;i++)
        {
            fprintf(fp,"%s\n",A[i]);
        }
        fprintf(fp,"%s",A[s-1]);
    }
    else
    {
        for(i=0;i<s_arx-1;i++)
        {
            fprintf(fp,"%s\n",B[i]);
        }
        fprintf(fp,"%s",B[s_arx-1]);
    }
    fclose(fp);
}

main()
{
    char **leks,**arx;
    int size,epilogi,i,size_arx;

    size_arx=MegethosPinaka();
    size=MegethosPinaka();
    arx=DimiourgiaPinaka(size);

    leks=DimiourgiaPinaka(size);

    do
    {
        epilogi=ShowMenu();
        switch(epilogi)
        {
            case 1: leks=EisagogiNeouOrou(leks,size);
                    size=size+2;
                    break;
            case 2: leks=TropopoihshOrou(leks,size);
                    break;
            case 3: leks=DiagrafiOrou(leks,size);
                    size=size-2;
                    break;
            case 4: MetafrasiLeksis(leks,size);
                    break;
            case 5: MetafrasiProtasis(leks,size);
                    break;
            case 6: Eksodos(leks,arx,size,size_arx);
                    free(leks);
                    free(arx);
                    break;
        }
    }
    while(epilogi!=6);

    return 0;
}
