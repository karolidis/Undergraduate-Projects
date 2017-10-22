#!/bin/bash

#Παναγιωτάτος Γεώργιος ΑΕΜ:2627
#Καρολίδης Θεόδωρος ΑΕΜ:2572
#Άνδρας Αντώνης ΑΕΜ:2557
#Σεραφείμ Εμμανουήλ ΑΕΜ:2553

#Στο αρχείο "output.txt" είναι αποθηκευμένα τα στατιστικά χωρίς να ανοίξουμε χειροκίνητα κάποιο επιπλέον site.
#Στο αρχείο "out.txt" είναι αποθηκευμένα τα στατιστικά ανοίγοντας χειροκίνητα 2 επιπλέον site.

initialize(){
	
	if [ -s url.in ] #Ελέγχουμε αν το αρχείο "url.in" είναι άδειο.
	then
		counter=0
	
		for t in `pgrep chromium`;    #Ελέγχουμε αν υπάρχουν ανοιχτές διεργασίες στον chromium.Αν υπάρχουν ανοιχτές 						      διεργασίες τις τερματίζουμε.Επιπλέον δημιουργόυμε το αρχείο εξόδου("output.txt")   						      στο οποίο θα αποθηκεύουμε τα στατιστικά.
		do 		               
		counter=$(($counter+1))    
		done
	
		if [ $counter -gt 0 ]
		then
			pkill -f -9 chromium
		fi	
		
		echo "Terminal Messages" > terminalmessages.txt
		echo "	       Statistics" > output.txt
		echo "Time NumberOfChromiumProcesses 	  VMRSS" >> output.txt	
	else
		echo "The url.in file is empty."
		exit
	fi
	
}

statistics(){
	sleep 0.05
	
	declare -a pid #Δημιουργούμε τον πίνακα "pid".
	
	timestamp=0
	timestamp=`echo $timestamp + 0.5 | bc` #Με τη μεταβλητή "timestamp" μετράμε τον χρόνο καταγραφής των στατιστικών.
	
	pids=$(ps -C chromium-browser -o pid=) #Αποθηκεύουμε στην μεταβλητή "pids" τα pid των διεργασιών του chromium.
	
	#Αυτό το while loop θα τρέχεο όσο υπάρχουν ανοιχτές διεργασίες στον chromium.
	while [ -n "$pids" ]
	do
		m=0 #στην μεταβλητή "m" κρατάμε το πλύθος των διεργασιών.
		
		for g in `pgrep chromium`; #Με αυτό το for loop για όλες τις διεργασίες του chromium κάνουμε τα εξής: 1)Για κάθε 						   διεργασία βάζουμε το pid της στον πίνακα "pid".2)Αυξάνουμε το πλήθος των διεργασιών κατα 1.
		do      
			pid[$m]=${g}
			m=$(($m+1)) 
		done
		
		echo -e -n "\n$timestamp s		$m		" >> output.txt  #Τυπώνουμε στο αρχείο εξόδου("output.txt") 							  τον χρόνο καταγραφής και το πλύθος των διεργασιών την συγκεκριμένη χρονική στιγμή.

		echo " " > results.txt #Δημιουργόυμε το αρχείο "results.txt".Στο αρχείο αυτό,για κάθε χρονική στιγμή της καταγραφής 					       των στατιστικών,αποθηκεύουμε πόση μνήμη(σε kilobytes) δεσμεύει η κάθε διεργασία chromium.(Για 					       κάθε χρονική στιγμή το αρχείο "results.txt" δημιουργείται από την αρχή.)
		
		#Με αυτό το for loop τυπώνουμε στο αρχείο "results.txt" πόση μνήμη(σε kilobytes) δεσμεύει η κάθε διεργασία chromium 			τη χρονική στιγμή της καταγραφής των στατιστικών.
		for ((i=0;i<m;i++));    

		do     
 			cat /proc/${pid[$i]}/status | grep RSS  | awk ' { print $2 } ' >> results.txt 
			#Η παραπάνω εντολή χωρίζεται σε τρια μέρη.Στο πρώτο μέρος(cat /proc/${pid[$i]}/status) παίρνουμε όλα τα 		στατιστικά της διεργασίας.Στο δεύτερο μέρος(grep RSS) από όλα τα στατιστικά της διεργασίας χρησμιποιώντας ως 			"κλειδι αναζήτησης" το "RSS" δεσμεύουμε την ζητούμενη γραμμή με το VMRSS.Στο τρίτο μέρος                            			(awk ' { print $2 } ' >> results.txt ) διαλέγουμε την 2 "στήλη" της γραμμής VMRSS,η οποία περιέχει στην ουσία τα   			kilobytes που δεμεύει η διεργασία και τα τυπώνουμε στο αρχείο "results.txt"
		done
		
		sum=0 #Σε αυτή την μεταβλητή θα κρατήσουμε το συνολικό μέγεθος της μνήμης(σε kilobytes) που δεσμεύουν όλες οι 			      διεργασίες του chromium μαζί,τη χρονική στιγμή της καταγραφής των στατιστικών.
		
		for y in `cat results.txt`;
		do      
			sum=$(($sum+$y))  
		done
		
		echo -n $(bc<<<"scale=2; $sum/1024") >> output.txt #Τυπώνουμε στο αρχείο εξόδου("output.txt") το μέγεθος της          			μνήμης(σε Mb) που δεσμεύουν όλες οι διεργασίες του chromium μαζί,τη χρονική στιγμή της καταγραφής των στατιστικών.
		
		echo " MB" >> output.txt
		
		sleep 0.5				
		
		timestamp=`echo $timestamp + 0.5 | bc`
		pids=$(ps -C chromium-browser -o pid=)	#Ανανεώνουμε τη συνθήκη του while loop.		   					
	done
}

openurls(){
	statistics &	#Τρέχουμε την συνάρτηση statistics στο background. 
	chromium-browser &
	
	for l in `cat url.in`; #Με αυτό το for loop ανοίουμε τα sites που είναι γραμμένα στο αρχείο "url.in". 
	do		
		chromium-browser ${l} &
		sleep 10
	done
}

closeurls(){
	peds=$(ps -C chromium-browser -o pid=) #Αποθηκεύουμε στην μεταβλητή "pids" τα pid των διεργασιών του chromium.
	
	#Με αυτό το while loop όσο υπάρχουν ανοιχτές διεργασίες στον chromium,κλείνουμε κάθε φορά την πιο πρόσφατη.
	while [ -n "$peds" ]
	do
		pkill -n -f chromium
		sleep 10
		peds=$(ps -C chromium-browser -o pid=)
	done
}

initialize 
openurls >> terminalmessages.txt 2>&1 #Ανακατευθύνει τα μηνύματα που θα εμφανίζονταν στο terminal,στο αρχείο "terminalmessages.txt".
sleep 30
closeurls
rm -f results.txt #Με αυτή την εντολή διαγράφουμε το αρχείο "results.txt" γιατί δεν μας είναι απαραίτητο στο τέλος.
exit
