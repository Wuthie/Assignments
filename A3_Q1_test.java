// -------------------------------------------------------
// Assignment A3_Q1
// Written by: Wuthie PANHA 40245548
// For COMP 248 Section P – Fall 2022
// -------------------------------------------------------

// program take in plain text and shows the encrypted version to the user

import java.util.Scanner;
public class A3_Q1_test {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the 3D-Space Encryption-Decryption Program:" + 
                         "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++" + 
                         "\n\nPlease enter your plain text below: ");
        char [] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.println(letters);
        String plainText = keyboard.nextLine();
        plainText.toCharArray();
        keyboard.close();
        // String result = new String("");
        String encryptedText="";
        for(int count =0; count < plainText.length(); count += 1){
            char character = plainText.charAt(count);
            for(int i =0; i < letters.length; i+=1){
                if(letters[i]==character){
                    encryptedText += letters[(i+1)%26];
                }
            }
                } System.out.print(encryptedText);
            }
        }
        
    