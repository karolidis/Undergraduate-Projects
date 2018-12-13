''' ΓΙΑ ΤΗΝ ΕΡΓΑΣΙΑ ΑΥΤΗ ΕΡΓΑΣΤΗΚΑΝ ΟΙ ΦΟΙΤΗΤΕΣ
ΚΑΡΟΛΙΔΗΣ ΘΕΟΔΩΡΟΣ(ΑΕΡΜ 2572)
ΕΜΜΑΝΟΥΗΛ ΣΕΡΑΦΕΙΜ '''

# ----------------------------------------------------------------------------------------------------------------------------------------------------------------

# ΕΙΣΑΓΩΓΗ ΒΙΒΛΙΟΘΗΚΩΝ

import sys
import pickle
import itertools as it
import mylib25722553

# ----------------------------------------------------------------------------------------------------------------------------------------------------------------

# ΠΑΡΑΚΑΤΩ ΓΡΑΦΩ ΤΟΝ ΚΩΔΙΚΑ ΤΩΝ ΣΥΝΑΡΤΗΣΕΩΝ ΠΟΥ ΘΑ ΧΡΗΣΙΜΟΠΟΙΗΣΩ ΣΤΗ "main"

'''η παρακάτω συναρτηση χρησιμοποιειται για να τυπωνει στον παιχτη την αρχικη οθονη-αρχικο μενου.Επισης μεσω της συναρτησης αυτη παιρνουμε σαν εισοδο την ενεργεια
που θελει να πραγματοποιήσει ο χρηστης'''
def print_main_menu():
    initial_screen = '''
--------------------
***** SCRABBLE *****
--------------------
1: Στατιστικά
2: Ρυθμίσεις
3: Νέο Παιχνίδι
q: Έξοδος
--------------------
'''
    print(initial_screen)
    choice = "keno"
    while(choice!= "1" and choice!="2" and choice!="3" and choice!="q"):
        choice  = input("Πατήστε το πλήκτρο της ενέργειας που επιθυμείτε να πραγματοποιήσετε: ")
    return choice

'''με αυτη την συναρτηση βρισκουμε απο το αρχειο των ρυθμισεων ποιο είναι το τρεχων επιπεδο δυσκολιας'''
def find_difficulty_level():
    with open('settings.pkl','rb') as settingsf:
        settings = pickle.load(settingsf)
    if(settings[0]==1):
        level = "Min Letters"
    elif(settings[1]==1):
        level = "Max Letters"
    else:
        level = "Smart"
    return level

'''η παρακατω συναρτηση χρησιμοποιειται οταν ο χρηστης θελει να δει ή να αλλαξει το επιπεδο δυσκολιας'''
def change_settings(current_level):
    settings_screen1='''
1: Αλλαγή επιπέδου δυσκολίας σε \"Max Letters\" και επιστροφή στο αρχικό μενού
2: Αλλαγή επιπέδου δυσκολίας σε \"Smart\" και επιστροφή στο αρχικό μενού
3: Επιστροφή στο αρχικό μενού
'''
    settings_screen2='''
1: Αλλαγή επιπέδου δυσκολίας σε \"Min Letters\" και επιστροφή στο αρχικό μενού
2: Αλλαγή επιπέδου δυσκολίας σε \"Smart\" και επιστροφή στο αρχικό μενού 
3: Επιστροφή στο αρχικό μενού
'''
    settings_screen3='''
1: Αλλαγή επιπέδου δυσκολίας σε \"Min Letters\" και επιστροφή στο αρχικό μενού
2: Αλλαγή επιπέδου δυσκολίας σε \"Max Letters\" και επιστροφή στο αρχικό μενού
3: Επιστροφή στο αρχικό μενού
'''
    if(current_level=="Min Letters"):
        print(settings_screen1)
    elif(current_level=="Max Letters"):
        print(settings_screen2)
    elif(current_level=="Smart"):
        print(settings_screen3)
    choice = "keno"
    while(choice!= "1" and choice!="2" and choice!="3"):
        choice  = input("Πατήστε το πλήκτρο της ενέργειας που επιθυμείτε να πραγματοποιήσετε: ")
    if((current_level=="Min Letters" and choice=="3") or (current_level=="Max Letters" and choice=="1") or (current_level=="Smart" and choice=="1")):
        settings = [1,0,0]
    elif((current_level=="Min Letters" and choice=="1") or (current_level=="Max Letters" and choice=="3") or (current_level=="Smart" and choice=="2")):
        settings = [0,1,0]       
    elif((current_level=="Min Letters" and choice=="2") or (current_level=="Max Letters" and choice=="2") or (current_level=="Smart" and choice=="3")):
        settings = [0,0,1]        
    with open('settings.pkl','wb') as settingsf:
        pickle.dump(settings,settingsf)

'''με την παρακατω συναρτηση ελεγχουμε αν η λεξη-απαντηση που εδωσε ο χρηστης αποτελειται απο γραμματα που εχει στην κατοχη του'''
def check_apantisi_letters(answer):
    flag = 0
    if(len(answer)==0):
        flag = 1
    if(flag == 0):
        current_letters = player.get_the_letters()[:]
        for i in range(len(answer)):
            counter = 0
            for j in range(len(current_letters)):
                if answer[i]== current_letters[j]:
                    del current_letters[j]
                    counter += 1
                    break
            if(counter == 0):
                flag = 1
                break
    return flag                 

'''με την παρακατω συναρτηση ελεγχουμε αν η λεξη-απαντηση που εδωσε ο χρηστης περιλαμβάνεται στις λεξεις του λεξικου μας'''            
def check_apantisi_dictionary(answer):
    flag = 0
    if answer in lkeys:
        flag = 1
    return flag

'''η παρακατω συναρτηση καλειται οταν καποιος παιχτης θελει να παει πασο.αν ενας παιχτης θελει να παει πασο τοτε πρώτα τραβαμε 7 τυχαια γραμματα
απο το σακουλακι.στην συνεχεια τοποθετουμε πισω στο σακουλακι τα γραμματα που ειχε στην κατοχη του ο παιχτης.τελος δινουμε στον παιχτη τα 7 γραμματα
που τραβηξαμε απο το σακουλακι.'''
def pao_paso(category):
    temporary_letters = mySak.get_letters(7)
    if(category=="player"):
        mySak.put_back_letters(player.get_the_letters())
        player.set_letters(temporary_letters)
    elif(category=="pc"):
        mySak.put_back_letters(pc.get_the_letters())
        pc.set_letters(temporary_letters)

'''η παρακατω συναρτηση συμπληρωνει τα γραμματα του παιχτη μετα απο λεξη-απαντηση.αν για παραδειγμα ο χρηστης εχει 7 αρχικα γραμματα και δωσει μια αποδεκτη
λεξη που αποτελειται απο 4 γραμματα τοτε αυτη η συναρτηση θα αφαιρεσει απο τα 7 αρχικα γραμματα τα 4 γραμματα της λεξης και στην συνεχεια θα δωσει στον παιχτη
3 νεα γραμματα(καθε παιχτης πρεπει να εχει παντα 7 γραμματα)'''        
def replace_letters_after_correct_answer(answer,category):
    if(category=="player"):
        temp_list = player.get_the_letters()
    elif(category=="pc"):
        temp_list = pc.get_the_letters()
    for i in range(len(answer)):
            for j in range(len(temp_list)):
                if answer[i]== temp_list[j]:
                    del temp_list[j]
                    break
    new_letters = mySak.get_letters(7-len(temp_list))
    if(category=="player"):
        player.set_letters(temp_list + new_letters)
    elif(category=="pc"):
        pc.set_letters(temp_list + new_letters) 

'''η παρακατω συναρτηση βρισκει την λεξη-απαντηση που δινει ο Η\Υ. Η λεξη-απαντηση που δινει ο Η/Υ υπολογιζεται απο διαφορετικο αλγοριθμο αναλογα με το επιπεδο δυσκολιας.'''    
def find_pc_answer(current_pc_letters,level):
    pc_answer=""
    if(level == "Min Letters"):
        for i in range (1,7):
            for j in it.permutations(current_pc_letters,i+1):
                pc_answer = "".join(j)
                if pc_answer in lkeys:
                    break
    elif(level == "Max Letters"):
        for i in range(7,1,-1):
            for j in it.permutations(current_pc_letters,i):
                pc_answer = "".join(j)
                if pc_answer in lkeys:
                    break       
    elif(level == "Smart"):
        current_dictionary = {}
        for i in range (1,7):
            for j in it.permutations(current_pc_letters,i+1):
                pc_answer = "".join(j)
                if pc_answer in lkeys:
                    current_dictionary[pc_answer] = dictionary[pc_answer]
        pc_answer = max(current_dictionary, key=lambda key: current_dictionary[key])
    if(pc_answer=="" and len(mySak.letlist)>=7):
        pc_answer="p"
    elif(pc_answer=="" and len(mySak.letlist)<7):
        pc_answer="q"
    return pc_answer

# ----------------------------------------------------------------------------------------------------------------------------------------------------------------

# ΠΑΡΑΚΑΤΩ ΓΡΑΦΩ ΤΟΝ ΚΩΔΙΚΑ ΤΗΣ "main"
   
epilogi = print_main_menu()
while(epilogi!="q"):
    if(epilogi=="1"):
        with open('statistics.pkl','rb') as statisticsf:
            statistics = pickle.load(statisticsf)
        print("\n--------------------------------")
        print("********** ΣΤΑΤΙΣΤΙΚΑ **********")
        print("--------------------------------")
        print("Συνολικός Αριθμός Παιχνιδιών: " + str(statistics[0]))
        print("Νικηφόρα Παιχνίδια: " + str(statistics[1]))
        print("Μέγιστο Σκορ: " + str(statistics[2]))
        print("--------------------------------")
        choice = "keno"
        while(choice!= ""):
            choice  = input("Πατήστε το πλήκτρο Enter για επιστροφή στο αρχικό μενού. ")
        epilogi = print_main_menu()                
    elif(epilogi=="2"):
        level = find_difficulty_level()
        print("\n-------------------------------")
        print("********** ΡΥΘΜΙΣΕΙΣ **********")
        print("-------------------------------")
        print("Τρέχων επίπεδο δυσκολίας: " + level)
        change_settings(level)
        epilogi = print_main_menu()       
    elif(epilogi=="3"):
        with open('dictionary.pkl','rb') as dictionaryf:
            dictionary = pickle.load(dictionaryf)
        lkeys = list(dictionary.keys())
        mySak = mylib25722553.SakClass()
        player = mylib25722553.Player()
        pc = mylib25722553.Player()
        player.set_letters(mySak.get_letters(7))
        pc.set_letters(mySak.get_letters(7))
        counter = 0
        apantisi = 'keno'
        while(len(mySak.letlist)>=7 and apantisi!="q"):
            print("\n------------------------------------------------------------------------------\n")
            print("Στο σακουλάκι υπάρχουν " + str(len(mySak.letlist)) + " γράμματα.")
            if(counter%2 == 0):
                print("Είναι η σειρά σου να παίξεις.")
                print("Τα γράμματα σου είναι: " + str(player.get_the_letters()))
                apantisi = input("Δώσε λέξη: ")
                while(apantisi!="q" and apantisi!="p"):
                    flag = check_apantisi_letters(apantisi)
                    if(flag == 1 ):
                        apantisi = input("Δώσε λέξη που αποτελείται από τα γράμματα που διαθέτεις: ")
                    elif(flag == 0):
                        flag2 = check_apantisi_dictionary(apantisi)
                        if(flag2 == 0):
                            apantisi = input("Η λέξη που έδωσες δεν υπάρχει στο λεξικό.Δώσε άλλη λέξη: ")
                        elif(flag2 == 1):
                            player.set_score(player.get_the_score() + dictionary[apantisi])
                            print("Αποδεκτή Λέξη - Βαθμοί: " + str(dictionary[apantisi]) + " - Σκορ: " + str(player.get_the_score()))
                            replace_letters_after_correct_answer(apantisi,"player")
                            choice = "keno"
                            while(choice!= ""):
                                choice  = input("Πατήστε το πλήκτρο Enter για να συνεχίσετε το παιχνίδι. ")
                            counter += 1
                            break
                if(apantisi == "p"):
                    pao_paso("player")
                    counter +=1
            else:
                level = find_difficulty_level()
                print("Είναι η σειρά του Η/Υ να παίξει.")
                print("Τα γράμματα του Η/Υ είναι: " + str(pc.get_the_letters()))
                apantisi = find_pc_answer(pc.get_the_letters(),level)
                if(apantisi=="p"):
                    print("0 Η/Υ δεν μπόρεσε να βρει λέξη και πήγε πάσο.")
                    pao_paso("pc")
                    counter += 1
                elif(apantisi!="p" and apantisi!="q"):
                    pc.set_score(pc.get_the_score() + dictionary[apantisi])
                    print("Λέξη Η/Υ: " + apantisi + " - Βαθμοί: " + str(dictionary[apantisi]) + " - Σκορ Η/Υ: " + str(pc.get_the_score()))
                    replace_letters_after_correct_answer(apantisi,"pc")
                    counter += 1
        print("\n------------------------------------------------------------------------------\n")
        print("Τέλος παιχνιδιού.")
        if(player.get_the_score() > pc.get_the_score()):
            print("Συγχαρητήρια κέρδισες!!!")
        if(player.get_the_score() < pc.get_the_score()):
            print("Λυπάμαι, έχασες.")
        if(player.get_the_score() == pc.get_the_score()):
            print("Το παιχνίδι τελείωσε με ισσοπαλία.")
        print("Το σκορ που πέτυχες είναι: " + str(player.get_the_score()))
        print("Tο σκορ που πετυχε ο Η/Υ είναι: " + str(pc.get_the_score()))
        with open('statistics.pkl','rb') as statisticsf:
                statistics = pickle.load(statisticsf)
        statistics[0] += 1
        if(player.get_the_score() > pc.get_the_score()):
                statistics[1] += 1
        if(player.get_the_score() > statistics[2]):
            statistics[2] = player.get_the_score()
        with open('statistics.pkl','wb') as statisticsf:
                pickle.dump(statistics,statisticsf)
        choice = "keno"
        while(choice!= ""):
            choice  = input("Πατήστε το πλήκτρο Enter για επιστροφή στο αρχικό μενού. ")
        epilogi = print_main_menu()
                            
else:
    print("\n--- Το Scrabble τερματίστηκε ---")
    sys.exit()
# ----------------------------------------------------------------------------------------------------------------------------------------------------------------

# ΜΕ ΤΟΝ ΠΑΡΑΚΑΤΩ ΚΩΔΙΚΑ ΠΡΑΓΜΑΤΟΠΟΙΗΘΗΚΕ Η ΔΗΜΙΟΥΡΓΙΑ ΤΩΝ DEFAULT PICKLE ΑΡΧΕΙΩΝ ΓΙΑ ΤΑ ΣΤΑΤΙΣΤΙΚΑ ΚΑΙ ΤΙΣ ΡΥΘΜΙΣΕΙΣ 
# DEFAULT ΑΡΧΕΙΟ ΣΤΑΤΙΣΤΙΚΩΝ : ΣΥΝΟΛΙΚΟΣ ΑΡΙΘΜΟΣ ΠΑΙΧΝΙΔΙΩΝ = 0 , ΝΙΚΗΦΟΡΑ ΠΑΙΧΝΙΔΙΑ = 0 , ΜΕΓΙΣΤΟ ΣΚΟΡ ΠΑΙΧΤΗ = 0 
# DEFAULT ΑΡΧΕΙΟ ΡΥΘΜΙΣΕΩΝ : MIN LETTERS = 1 , MAX LETTERS = 0 , SMART = 0 

##statistics = [0,0,0]
##settings = [1,0,0]
##with open('statistics.pkl','wb') as statisticsf:
##    pickle.dump(statistics,statisticsf)
##with open('settings.pkl','wb') as settingsf:
##    pickle.dump(settings,settingsf)

# ----------------------------------------------------------------------------------------------------------------------------------------------------------------

# ΜΕ ΤΟΝ ΠΑΡΑΚΑΤΩ ΚΩΔΙΚΑ ΠΡΑΓΜΑΤΟΠΟΙΗΘΗΚΕ Η ΔΗΜΙΟΥΡΓΙΑ ΤΟΥ PICKLE ΑΡΧΕΙΟΥ ΠΟΥ ΑΦΟΡΑ ΤΟ ΛΕΞΙΚΟ
# ΑΡΧΙΚΑ ΕΧΟΥΜΕ ΤΟ ΑΡΧΕΙΟ greek.txt ΠΟΥ ΠΕΡΙΛΑΜΒΑΝΕΙ 350 ΧΙΛΙΑΔΕΣ ΕΛΛΗΝΙΚΕΣ ΛΕΞΕΙΣ
# ΔΙΑΒΑΖΟΥΜΕ ΟΛΕΣ ΤΙΣ ΛΕΞΕΙΣ ΤΟΥ ΑΡΧΕΙΟΥ greek.txt ΚΑΙ ΓΡΑΦΟΥΜΕ ΣΤΟ ΑΡΧΕΙΟ greek7.txt ΟΛΕΣ ΤΙΣ ΛΕΞΕΙΣ ΠΟΥ ΕΧΟΥΝ ΜΕΧΡΙ ΚΑΙ 7 ΓΡΑΜΜΑΤΑ
# ΕΠΕΙΤΑ ΔΙΑΒΑΖΟΥΜΕ ΤΟ ΑΡΧΕΙΟ greek7.txt
# ΓΙΑ ΚΑΘΕ ΛΕΞΗ ΤΟΥ ΑΡΧΕΙΟΥ greek7.txt ΥΠΟΛΟΓΙΖΟΥΜΕ ΠΟΣΟΥΣ ΒΑΘΜΟΥΣ ΔΙΝΕΙ
# ΕΠΕΙΤΑ ΚΑΘΕ ΖΕΥΓΑΡΙ ΠΟΥ ΠΡΟΚΥΠΤΕΙ (ΛΕΞΗ-ΒΑΘΜΟΣ) ΤΑ ΒΑΖΟΥΜΕ ΣΕ ΜΙΑ ΔΟΜΗ ΛΕΞΙΚΟΥ {key:value} ΩΣ ΕΞΗΣ : KEY = Η ΛΕΞΗ , VALUE = ΒΑΘΜΟΙ ΠΟΥ ΔΙΝΕΙ Η ΛΕΞΗ
# ΤΕΛΟΣ ΤΗΝ ΔΟΜΗ ΤΟΥ ΛΕΞΙΚΟΥ ΤΗΝ ΑΠΟΘΗΚΕΥΟΥΜΕ ΣΕ ΕΝΑ ΑΡΧΕΙΟ PICKLE

##import mylib
##import pickle
##mySak = mylib.SakClass()
##with open('greek.txt','r',encoding="utf-8") as greekf:
##    with open('greek7.txt','w') as greek7f:
##        for line in greekf:
##            if len(line)<9:
##                greek7f.write(line)
##dictionary = {}
##with open('greek7.txt','r') as greek7f:
##    for line in greek7f:
##        vathmoi_leksis = 0
##        leksi = line.strip('\n')
##        for gramma in leksi:
##            vathmoi_leksis = vathmoi_leksis + mySak.lets[gramma][1]
##        dictionary[leksi] = vathmoi_leksis
##with open('dictionary.pkl','wb') as dictionaryf:
##    pickle.dump(dictionary,dictionaryf)

# ----------------------------------------------------------------------------------------------------------------------------------------------------------------
