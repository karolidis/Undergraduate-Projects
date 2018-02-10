/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdes;

import java.util.Scanner;

/**
 *
 * @author Theodoros
 */
public class SDES {

    /**
     * in main fucntion i take as input for the user every necessary information
     * for the program execution
     */
    public static void main(String[] args) {
        String userchoice;
        int uc;
        String pt;
        String k;
        String stringtempchar;
        boolean flag, flag1, flag2;
        char tempchar;
        int[] plaintext;
        int[] key;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("You are running a program about Simplified Data Encryption Standard (S-DES Algorithm)");
        System.out.println("Program Operations : 1)Encrypt a message");
        System.out.println("                     2)Decrypt a message");
        System.out.println("                     3)Exit");
        System.out.println("INFO : To decrypt a ciphertext you need to enter the same 10-bit key that was used during the encryption!");
        System.out.print("Enter the number of the operation you want to execute: ");

        do {
            flag = true;
            userchoice = keyboard.nextLine();
            if ((userchoice.equals("1") == false) && (userchoice.equals("2") == false) && (userchoice.equals("3") == false)) {
                flag = false;
                System.out.print("Please enter a valid number(1-2-3): ");
            }
        } while (flag == false);

        uc = Integer.parseInt(userchoice);

        if (uc == 1) {
            System.out.println();
            System.out.println("----------------------------------------------------------------------");
            System.out.println("To encrypt a message you must enter a 8-bit Plaintext and a 10-bit Key");
            System.out.println("----------------------------------------------------------------------");
            do {
                flag1 = false;
                flag2 = true;

                System.out.print("Enter 8-bit Plaintext : ");
                pt = keyboard.nextLine();

                plaintext = new int[pt.length()];

                if (pt.length() == 8) {
                    flag1 = true;
                }

                for (int i = 0; i < pt.length(); i++) {
                    tempchar = pt.charAt(i);
                    stringtempchar = Character.toString(tempchar);
                    if ((stringtempchar.equals("0") == false) && (stringtempchar.equals("1") == false)) {
                        flag2 = false;
                        break;
                    }
                    plaintext[i] = Integer.parseInt(stringtempchar);
                }

                if (flag1 == false && flag2 == false) {
                    System.out.println("The Plaintext must be 8-bit and contain only 0 or 1.");
                } else if (flag1 == false) {
                    System.out.println("The Plaintext must be 8-bit.");
                } else if (flag2 == false) {
                    System.out.println("The Plaintext must contain only 0 or 1.");
                }

            } while (flag1 == false || flag2 == false);

            do {
                flag1 = false;
                flag2 = true;

                System.out.print("Enter 10-bit Key : ");
                k = keyboard.nextLine();

                key = new int[k.length()];

                if (k.length() == 10) {
                    flag1 = true;
                }

                for (int i = 0; i < k.length(); i++) {
                    tempchar = k.charAt(i);
                    stringtempchar = Character.toString(tempchar);
                    if ((stringtempchar.equals("0") == false) && (stringtempchar.equals("1") == false)) {
                        flag2 = false;
                        break;
                    }
                    key[i] = Integer.parseInt(stringtempchar);
                }

                if (flag1 == false && flag2 == false) {
                    System.out.println("The Key must be 10-bit and contain only 0 or 1.");
                } else if (flag1 == false) {
                    System.out.println("The Key must be 10-bit.");
                } else if (flag2 == false) {
                    System.out.println("The Key must contain only 0 or 1.");
                }

            } while (flag1 == false || flag2 == false);

            KeyGeneration KG = new KeyGeneration(key);
            KG.PrintResults();

            Encryption E = new Encryption(plaintext, KG.getK1(), KG.getK2(), 1);
            E.PrintResults();
        } else if (uc == 2) {
            System.out.println();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("To decrypt a message you must enter a 8-bit Ciphertext and a 10-bit Key");
            System.out.println("-----------------------------------------------------------------------");
            do {
                flag1 = false;
                flag2 = true;

                System.out.print("Enter 8-bit Ciphertext : ");
                pt = keyboard.nextLine();

                plaintext = new int[pt.length()];

                if (pt.length() == 8) {
                    flag1 = true;
                }

                for (int i = 0; i < pt.length(); i++) {
                    tempchar = pt.charAt(i);
                    stringtempchar = Character.toString(tempchar);
                    if ((stringtempchar.equals("0") == false) && (stringtempchar.equals("1") == false)) {
                        flag2 = false;
                        break;
                    }
                    plaintext[i] = Integer.parseInt(stringtempchar);
                }

                if (flag1 == false && flag2 == false) {
                    System.out.println("The Ciphertext must be 8-bit and contain only 0 or 1.");
                } else if (flag1 == false) {
                    System.out.println("The Ciphertext must be 8-bit.");
                } else if (flag2 == false) {
                    System.out.println("The Ciphertext must contain only 0 or 1.");
                }

            } while (flag1 == false || flag2 == false);

            do {
                flag1 = false;
                flag2 = true;

                System.out.print("Enter 10-bit Key : ");
                k = keyboard.nextLine();

                key = new int[k.length()];

                if (k.length() == 10) {
                    flag1 = true;
                }

                for (int i = 0; i < k.length(); i++) {
                    tempchar = k.charAt(i);
                    stringtempchar = Character.toString(tempchar);
                    if ((stringtempchar.equals("0") == false) && (stringtempchar.equals("1") == false)) {
                        flag2 = false;
                        break;
                    }
                    key[i] = Integer.parseInt(stringtempchar);
                }

                if (flag1 == false && flag2 == false) {
                    System.out.println("The Key must be 10-bit and contain only 0 or 1.");
                } else if (flag1 == false) {
                    System.out.println("The Key must be 10-bit.");
                } else if (flag2 == false) {
                    System.out.println("The Key must contain only 0 or 1.");
                }

            } while (flag1 == false || flag2 == false);

            KeyGeneration KG = new KeyGeneration(key);
            KG.PrintResults();

            Encryption E = new Encryption(plaintext, KG.getK2(), KG.getK1(), 2);
            E.PrintResults();
        } else if (uc == 3) {
            System.exit(0);
        }

    }

}
