#!/bin/bash
echo "How many numbers of the sequence would you like?"	#Το script αυτό μας εμφανίζει όσους αριθμούς της ακολουθίας fibonacci 								επιθυμέι ο χρήστης.Επομένως ο χρήστης πρέπει να δώσει σαν είδοδο έναν ακέραιο 								αριθμό μεγαλύτερο του μηδέν.
read number

while [ $number -lt 1 ] #Αυτο το while loop ενεργοποιείται στην περίπτωση που ο χρήστης δώσει αριθμό μικρότερο ή ίσο με το μηδέ.Τότε 				του ζητάμε επαναληπτικά έναν αριμό,μέχρι ο χρήστης να δώσει αριθμό μεγαλύτερο του μηδέν.  
do
	echo "Please give a number greater than zero!"
	read number
done

#Εδώ ορίζουμε τους πρώτους 2 όρους της ακολουθίας Fibonacci. F(0)=0 kai F(1)=1
f0=0
f1=1

if [ $number -eq 1 ] #Αυτό το if χρησιμοποιείται για την μορφοποίηση της εξόδου.
then
	echo -e -n "First term of Fibonacci sequence is : "
else
	echo -e -n "First $number terms of Fibonacci sequence are : "
fi

temp=$(($number-1))

for(( i=0;i<number;i++ ))
do
	if [ $temp -gt $i ] #Αυτό το if χρησιμοποιείται για την μορφοποίηση της εξόδου.
	then	
		#Υλοποίηση της ακολουθίας Fibonacci.
		echo -n "$f0,"
		fn=$((f0+f1))
		f0=$f1
		f1=$fn
	else
		echo "$f0"
	fi
done
