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
public class Encryption {

    int[] plaintext = new int[8];
    int[] K1 = new int[8];
    int[] K2 = new int[8];
    int[] LH = new int[4];
    int[] RH = new int[4];
    int userchoice;

    //constructor
    public Encryption(int[] pt, int[] k1, int[] k2, int uc) {
        plaintext = pt;
        K1 = k1;
        K2 = k2;
        userchoice = uc;
    }

    //i use this function to call every necessary function and print the results
    public void PrintResults() {
        System.out.println();
        System.out.println("-----------------------------");
        if (userchoice == 1) {
            System.out.println("Encryption Process Starts");
        } else if (userchoice == 2) {
            System.out.println("Decryption Process Starts");
        }

        System.out.println("-----------------------------");

        if (userchoice == 1) {
            System.out.print("Input Plaintext : ");
        } else if (userchoice == 2) {
            System.out.print("Input Ciphertext : ");
        }

        for (int i = 0; i < plaintext.length; i++) {
            System.out.print(plaintext[i]);
        }
        System.out.println();

        InitialPermutation();

        LH4RH4(plaintext);

        //first round with sub-key K1
        int[] round1 = new int[8];
        round1 = FunctionFK(LH, RH, K1);

        //Switch the left half & right half of about output
        int[] switched = new int[8];
        switched = Switch(round1);

        LH4RH4(switched);

        //second round with sub-key K2
        int[] round2 = new int[8];
        round2 = FunctionFK(LH, RH, K2);
        plaintext = round2;

        InverseInitialPermutation();
        if (userchoice == 1) {
            System.out.print("Encrypted Text(ciphertext) : ");
        } else if (userchoice == 2) {
            System.out.print("Decrypted Text(plaintext) : ");
        }

        for (int i = 0; i < plaintext.length; i++) {
            System.out.print(plaintext[i]);
        }
        System.out.println();

    }

    //this function implements Initial Permutation following the rule [2 6 3 1 4 8 5 7]
    private void InitialPermutation() {
        int[] temp = new int[8];

        temp[0] = plaintext[1];
        temp[1] = plaintext[5];
        temp[2] = plaintext[2];
        temp[3] = plaintext[0];
        temp[4] = plaintext[3];
        temp[5] = plaintext[7];
        temp[6] = plaintext[4];
        temp[7] = plaintext[6];

        plaintext = temp;
    }

    //this function implements Inverse Initial Permutation following the rule [4 1 3 5 7 2 8 6]
    private void InverseInitialPermutation() {
        int[] temp = new int[8];

        temp[0] = plaintext[3];
        temp[1] = plaintext[0];
        temp[2] = plaintext[2];
        temp[3] = plaintext[4];
        temp[4] = plaintext[6];
        temp[5] = plaintext[1];
        temp[6] = plaintext[7];
        temp[7] = plaintext[5];

        plaintext = temp;
    }

    //this function is used to take the leftmost 4 bits and rightmost 4bits of  a 8-bit input
    private void LH4RH4(int[] T) {
        LH[0] = T[0];
        LH[1] = T[1];
        LH[2] = T[2];
        LH[3] = T[3];

        RH[0] = T[4];
        RH[1] = T[5];
        RH[2] = T[6];
        RH[3] = T[7];
    }

    //fK(L, R, SK) = (L (XOR) mappingF(R, SK), R)
    int[] FunctionFK(int[] L, int[] R, int[] SK) {
        int[] temp = new int[4];
        int[] out = new int[8];

        temp = mappingF(R, SK);

        //XOR left half with output of mappingF 
        out[0] = L[0] ^ temp[0];
        out[1] = L[1] ^ temp[1];
        out[2] = L[2] ^ temp[2];
        out[3] = L[3] ^ temp[3];

        out[4] = R[0];
        out[5] = R[1];
        out[6] = R[2];
        out[7] = R[3];

        return out;
    }

    //arguments R = 4-bit right-half of plaintext & SK = 8-bit subkey
    int[] mappingF(int[] R, int[] SK) {
        int[] temp = ExpansionPermutation(R);

        // Bit by bit XOR with sub-key
        temp[0] = temp[0] ^ SK[0];
        temp[1] = temp[1] ^ SK[1];
        temp[2] = temp[2] ^ SK[2];
        temp[3] = temp[3] ^ SK[3];
        temp[4] = temp[4] ^ SK[4];
        temp[5] = temp[5] ^ SK[5];
        temp[6] = temp[6] ^ SK[6];
        temp[7] = temp[7] ^ SK[7];

        // S-Boxes
        final int[][] S0 = {{1, 0, 3, 2}, {3, 2, 1, 0}, {0, 2, 1, 3}, {3, 1, 3, 2}};
        final int[][] S1 = {{0, 1, 2, 3}, {2, 0, 1, 3}, {3, 0, 1, 0}, {2, 1, 0, 3}};

        int fhb1 = temp[0]; //fhb1 = first half bit 1 
        int fhb4 = temp[3]; //fhb4 = first half bit 4
        int rowS0 = BinaryToDecimalFor2BitNumbers(fhb1, fhb4); // for input in s-box S0

        int fhb2 = temp[1]; //fhb2 = first half bit 2
        int fhb3 = temp[2]; //fhb3 = first half bit 3     
        int colS0 = BinaryToDecimalFor2BitNumbers(fhb2, fhb3); // for input in s-box S0

        int S0outDecimal = S0[rowS0][colS0];
        int[] S0outBinary = DecimalToBinaryFor2BitNumbers(S0outDecimal);

        int shb1 = temp[4]; //shb1 = second half bit 1 
        int shb4 = temp[7]; //shb4 = second half bit 4
        int rowS1 = BinaryToDecimalFor2BitNumbers(shb1, shb4); // for input in s-box S1

        int shb2 = temp[5]; //shb2 = second half bit 2
        int shb3 = temp[6]; //shb3 = second half bit 3     
        int colS1 = BinaryToDecimalFor2BitNumbers(shb2, shb3); // for input in s-box S0

        int S1outDecimal = S1[rowS1][colS1];
        int[] S1outBinary = DecimalToBinaryFor2BitNumbers(S1outDecimal);

        int[] Sout = new int[4];
        Sout[0] = S0outBinary[0];
        Sout[1] = S0outBinary[1];
        Sout[2] = S1outBinary[0];
        Sout[3] = S1outBinary[1];

        int[] FinalSout = PermutationP4(Sout);

        return FinalSout;
    }

    //this function implements expansion permutation following the rule [4 1 2 3 2 3 4 1]
    private int[] ExpansionPermutation(int[] T) {
        int[] temp = new int[8];

        temp[0] = T[3];
        temp[1] = T[0];
        temp[2] = T[1];
        temp[3] = T[2];
        temp[4] = T[1];
        temp[5] = T[2];
        temp[6] = T[3];
        temp[7] = T[0];

        return temp;
    }

    /**
     * this function is used to convert a 2-bit binary number to an int number
     * possible 2-bit binary numbers (00) (01) (10) (11) int number is returned
     */
    private int BinaryToDecimalFor2BitNumbers(int x1, int x2) {
        int sum = 0;

        if (x1 == 1) {
            sum = sum + 2;
        }
        if (x2 == 1) {
            sum = sum + 1;
        }

        return sum;
    }

    /**
     * this function is used to convert an int number to a 2-bit binary number
     * possible int numbers (0) (1) (2) (3) 2-bit binary number is returner as
     * an int[2] array
     */
    private int[] DecimalToBinaryFor2BitNumbers(int x) {
        int result[] = new int[2];

        switch (x) {
            case 0:
                result[0] = 0;
                result[1] = 0;
                break;
            case 1:
                result[0] = 0;
                result[1] = 1;
                break;
            case 2:
                result[0] = 1;
                result[1] = 0;
                break;
            default:
                result[0] = 1;
                result[1] = 1;
                break;
        }

        return result;
    }

    /**
     * this function implements permutation P4 on 4-bit input.the rule for
     * permutation P4[ 2 4 3 1 ]
     */
    private int[] PermutationP4(int[] T) {
        int[] temp = new int[4];

        temp[0] = T[1];
        temp[1] = T[3];
        temp[2] = T[2];
        temp[3] = T[0];

        return temp;
    }

    //this function interchanges the left and right 4 bits 
    private int[] Switch(int[] T) {
        int[] temp = new int[8];

        temp[0] = T[4];
        temp[1] = T[5];
        temp[2] = T[6];
        temp[3] = T[7];

        temp[4] = T[0];
        temp[5] = T[1];
        temp[6] = T[2];
        temp[7] = T[3];

        return temp;
    }

}
