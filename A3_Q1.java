// -------------------------------------------------------
// Assignment A3_Q1
// Written by: Wuthie PANHA 40245548
// For COMP 248 Section P – Fall 2022
// -------------------------------------------------------

// program take in plain text and shows the encrypted version to the user

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
public class A3_Q1 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the 3D-Space Encryption-Decryption Program:" + 
                         "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++" + 
                         "\n\nPlease enter your plain text below: ");
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String plainText = keyboard.nextLine();
        keyboard.close();
        System.out.print(plainText.charAt(2));
        int count = 0;
        String encryptedText[] = {} ;
        for(count =0; count == plainText.length(); count += 1){
            char character = plainText.charAt(count);
            if (Character.isLetter(character)){
                char i = (char)((character + 1)%26);
            }
        }
    }
}