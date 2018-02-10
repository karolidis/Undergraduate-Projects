/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdes;

/**
 *
 * @author Theodoros
 */
public class KeyGeneration {

    int[] key = new int[10];
    int[] key1 = new int[8];
    int[] key2 = new int[8];

    //constructor
    public KeyGeneration(int[] k) {
        key = k;
    }

    ////i use this function to call every necessary function and print the results
    public void PrintResults() {
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Key Generation Process Starts");
        System.out.println("-----------------------------");

        System.out.print("Input Key : ");
        for (int i = 0; i < key.length; i++) {
            System.out.print(key[i]);
        }
        System.out.println();

        PermutationP10();

        LS1();

        key1 = PermutationP8();
        System.out.print("Subkey K1 : ");
        for (int i = 0; i < key1.length; i++) {
            System.out.print(key1[i]);
        }
        System.out.println();

        LS2();

        key2 = PermutationP8();
        System.out.print("Subkey K2 : ");
        for (int i = 0; i < key2.length; i++) {
            System.out.print(key2[i]);
        }
        System.out.println();

    }

    /**
     * this function implements permutation P10 on 10-bit key P10(k1, k2, k3,
     * k4, k5, k6, k7, k8, k9, k10) = (k3, k5, k2, k7, k4, k10, k1, k9, k8, k6)
     */
    private void PermutationP10() {
        int[] temp = new int[10];

        temp[0] = key[2];
        temp[1] = key[4];
        temp[2] = key[1];
        temp[3] = key[6];
        temp[4] = key[3];
        temp[5] = key[9];
        temp[6] = key[0];
        temp[7] = key[8];
        temp[8] = key[7];
        temp[9] = key[5];

        key = temp;
    }

    /**
     * this function implements a circular left shift (LS-1), or rotation,
     * separately on the first five bits and the second five bits.*
     */
    private void LS1() {
        int[] temp = new int[10];

        temp[0] = key[1];
        temp[1] = key[2];
        temp[2] = key[3];
        temp[3] = key[4];
        temp[4] = key[0];

        temp[5] = key[6];
        temp[6] = key[7];
        temp[7] = key[8];
        temp[8] = key[9];
        temp[9] = key[5];

        key = temp;
    }

    /**
     * this function implements permutation P8 on 10-bit key.this function picks
     * out and permutes 8 of the 10 bits of key.the rule for permutation P8[ 6 3
     * 7 4 8 5 10 9 ] , 8-bit subkey is returned*
     */
    private int[] PermutationP8() {
        int[] temp = new int[8];

        temp[0] = key[5];
        temp[1] = key[2];
        temp[2] = key[6];
        temp[3] = key[3];
        temp[4] = key[7];
        temp[5] = key[4];
        temp[6] = key[9];
        temp[7] = key[8];

        return temp;
    }

    /**
     * this function implements a circular left shift of 2 bit positions,
     * separately on the first five bits and the second five bits.*
     */
    private void LS2() {
        int[] temp = new int[10];

        temp[0] = key[2];
        temp[1] = key[3];
        temp[2] = key[4];
        temp[3] = key[0];
        temp[4] = key[1];

        temp[5] = key[7];
        temp[6] = key[8];
        temp[7] = key[9];
        temp[8] = key[5];
        temp[9] = key[6];

        key = temp;
    }

    //this is a getter function to get Subkey K1
    public int[] getK1() {
        return key1;
    }

    //this is a getter function to get Subkey K2
    public int[] getK2() {
        return key2;
    }

}
