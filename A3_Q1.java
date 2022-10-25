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
        String plainText = "";
        plainText += keyboard.nextLine();
        keyboard.close();
        int textLength = plainText.length();
        System.out.print(textLength);
        int lettercount = 0;
        int mode;
        String swappedString = "";
        char[] textAr = plainText.toCharArray();
        for(int i = 0; i < textLength; i+=1){
            char character = plainText.charAt(i);
            if (Character.isLetter(character)){
                lettercount+=1;
            }
        if (lettercount % 2 == 0){ //mode 0 for even number of characters, mode 1 for odd number of characters
            mode = 0;}
        else mode = 1;
        
        if (mode == 0){
            for (int x=0; x < textLength; x+=1){
                char temp = textAr[x];
                textAr[x] = textAr[x+1];
                textAr[x+1] = temp;
                swappedString+=textAr;
                
            }
        }
        System.out.print(swappedString);

        }

    }
}
