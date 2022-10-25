// -------------------------------------------------------
// Assignment A3_Q1
// Written by: Wuthie PANHA 40245548
// For COMP 248 Section P – Fall 2022
// -------------------------------------------------------

// program take in plain text and shows the encrypted version to the user

import java.util.Scanner;
public class A3_Q1 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the 3D-Space Encryption-Decryption Program:" + 
                         "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++" + 
                         "\n\nPlease enter your plain text below: ");
        String plainText = keyboard.nextLine();
        String encryptedText;
        keyboard.close();
        int lengthString = plainText.length();
        int count;
        for (count = 0; count <= lengthString; count += 1){
            char character = plainText.charAt(count);
            if(Character.isLetter(character)){
                char shifted = char(character )
            }
        }
        System.out.print(count);
        
    }
}