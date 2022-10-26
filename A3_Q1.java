import java.util.Scanner;

import javax.print.DocPrintJob;

// -------------------------------------------------------
// Assignment A3_Q1
// Written by: Wuthie PANHA 40245548
// For COMP 248 Section P – Fall 2022
// -------------------------------------------------------

// program take in plain text and shows the encrypted version to the user

public class A3_Q1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the 3D-Space Encryption-Decryption Program:" + 
                         "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++" + 
                         "\n\nPlease enter your plain text below: ");
        String plainText = keyboard.nextLine();
        char[] plainChar = plainText.toCharArray(); 
        //System.out.print(plainChar[0]);
        keyboard.close();
        int i;
        char checker;
        //need a do while loop? to validate user input
        do{
            for(int x = 0; x < plainChar.length; x++){
                checker = plainChar[x];}
        }
        while (!(checker.isletter)) 
        for (i = 0; i < plainChar.length-1; i++){ 
            if (i%2 == 0 && plainChar.length % 2 == 0){
                char temp = plainChar[i];
                plainChar[i] = plainChar[i+1];
                plainChar[i+1] = temp;
                new String(plainChar);
            }
            else if (i%2 != 0 && plainChar.length % 2 != 0){
                char temp = plainChar[i];
                plainChar[i] = plainChar[i+1];
                plainChar[i+1] = temp;
                new String(plainChar);
            }
        }
        System.out.print(new String(plainChar));
        }
        

        }

    
