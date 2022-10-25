import java.util.Scanner;

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
        keyboard.close();
        int textLength = plainText.length();
        for(int i = 0; i < textLength; i+=1){
            char character = plainText.charAt(i);
            if (Character.isLetter(character)){

            }

        }

    }
}
