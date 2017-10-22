#include <stdio.h>
#include <stdlib.h>

float* convolve(float *IS,float *KA,float *S,int c2,int Sl) ;

int main()
{
    int temp,counter1,i,counter2,sl,m ;
    float a ;
    float *InputSignal ;
    float *KroustikiApokrisi ;
    float *Syneliksi ;

    FILE *fp1 ;
    FILE *fp2 ;
    FILE *fp3 ;

    //ksekiname ta coounter me timi 1 giati sto metrima xanetai i teleutaia seira tou arxeiou.
    counter1 = 1 ;
    counter2 = 1 ;

    //metrame poses times periexei to arxeio gia na desmeusoume mnimi me dynamiko tropo.
    fp1 = fopen("inputsignal.txt","r") ;

    if((fp1 = fopen("inputsignal.txt","r")) == NULL )
    {
        printf("Could not open the file.") ;
    }
    else
    {
        while(!feof(fp1))
        {
            temp = fgetc(fp1);
            if(temp == '\n')
            {
                counter1++;
            }
        }
    }

    fclose(fp1) ;

    //desmeuoume dynamika mnimi gia ton pinaka ston opoio tha apothikeutoun oi times tou simatos eisodou.
    InputSignal = (float*) malloc(counter1 * sizeof(float)) ;
    if(InputSignal == NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }

    //pername tis times tou arxeiou ston pinaka
    i = 0 ;
    a = 0 ;

    fp1 = fopen("inputsignal.txt","r") ;

    if((fp1 = fopen("inputsignal.txt","r")) == NULL )
    {
        printf("Could not open the file.") ;
    }
    else
    {
        while(!feof(fp1))
        {
            fscanf(fp1,"%f",&a);
            InputSignal[i] = a ;
            i++ ;
        }
    }

    fclose(fp1) ;

    //Kanoume akrivos to idio gia to arxeio me tis times tis kroustikis apokrisis.
    fp2 = fopen("kroustikiapokrisi.txt","r") ;

    if((fp2 = fopen("kroustikiapokrisi.txt","r")) == NULL )
    {
        printf("Could not open the file.") ;
    }
    else
    {
        while(!feof(fp2))
        {
            temp = fgetc(fp2);
            if(temp == '\n')
            {
                counter2++;
            }
        }
    }

    fclose(fp2) ;

    KroustikiApokrisi = (float*) malloc(counter2 * sizeof(float)) ;
    if(KroustikiApokrisi == NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }

    i = 0 ;
    a = 0 ;

    fp2 = fopen("kroustikiapokrisi.txt","r") ;

    if((fp2 = fopen("kroustikiapokrisi.txt","r")) == NULL )
    {
        printf("Could not open the file.") ;
    }
    else
    {
        while(!feof(fp2))
        {
            fscanf(fp2,"%f",&a);
            KroustikiApokrisi[i] = a ;
            i++ ;
        }
    }

    fclose(fp2) ;

    //desmeuoume dynamika mnimi gia ton pinaka ston opoio tha apothikeutoun oi times tou simatos tis syneliksis.
    sl = counter1 - counter2 + 1 ; //syneliksi length

    Syneliksi = (float*) malloc(sl * sizeof(float)) ;
    if(Syneliksi == NULL)
    {
        puts("Den yparxei diathesimos xwros stin mnimi!");
        exit(1);
    }

    //Klisi synartysis pou ypologizei tin syneliksi.
    Syneliksi = convolve(InputSignal,KroustikiApokrisi,Syneliksi,counter2,sl);

    //Typoma ton diakriton timon tou simatos tis syneliksis se arxeio.
    if ((fp3 = fopen("syneliksi.txt","w"))!= NULL)
    {
        for(m = 0 ; m < sl ; m++)
        {
            if(m == sl-1)
            {
                fprintf(fp3,"%f",Syneliksi[m]) ;
            }
            else
            {
                fprintf(fp3,"%f\n",Syneliksi[m]) ;
            }
        }
        fclose(fp3);
    }
    else
    {
        printf("Could not open the file.") ;

    }

    //Apeleutherosi tis mnimis pou eixame desmeusei dynamika.
    free(InputSignal) ;
    free(KroustikiApokrisi) ;
    free(Syneliksi) ;

    return 0;
}

//Synartysi pou ypologizei tin syneliksi.
float* convolve(float *IS,float *KA,float *S,int c2,int Sl)
{
    int j,k,l ;
    float temporary ;

    temporary = 0 ;

    for(j = 0 ; j < Sl ; j++)
    {
        S[j] = 0 ;
        for(k = 0 , l = j ; k < c2 ; k++ , l++)
        {
            temporary = IS[l] * KA[k] ;
            S[j] = S[j] + temporary ;
        }
    }

    return S ;
}
