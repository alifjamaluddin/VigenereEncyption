/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenereencyption;

/**
 *
 * @author Alif
 */
import java.util.Scanner;
public class VigenereEncyption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String keyword = "LEMON";
        int[] numA = new int[text.length()];
        int[] numkey = new int[text.length()];
        char[] key = new char[text.length()];
        int option = 0;
        
        System.out.println("Please insert you text");
        text = input.nextLine();
        System.out.println("Please insert your key");
        keyword=input.nextLine();
        System.out.println("Insert [1] Encryption [2] Decryption");
        option=input.nextInt();
        
        
        //get num for every letter in text and store it in int array
        for(int i = 0;  i < numA.length;i++ ){
            char chartemp = text.charAt(i);
            numA[i] =  Character.getNumericValue(chartemp)-10;
            //System.out.println(chartemp + " = "+numA[i]);
        }
        
        //get num for every letter for keyword and store it in int array
        int y=0;
        for(int i = 0;  i < numkey.length;i++ ){
           
            if(y==keyword.length()){
                y=0;
                key[i] = keyword.charAt(y);
                y++;
            }else{
                key[i] = keyword.charAt(y);
                y++;
            }
            
            //System.out.print(key[i]);
        }
        //System.out.println("");
        
        //get numeric value of char in key
        for(int i = 0;  i < numkey.length;i++ ){
            char chartemp = key[i];
            numkey[i] =  Character.getNumericValue(chartemp)-10;
            
            //System.out.println(chartemp + " = "+numkey[i]);
        }
        
        
        switch(option){
            case 1:  VigenereEncyption.encryption(numkey,numA);break;
            case 2:  VigenereEncyption.decryption(numkey,numA);break;
            default: System.out.println("Wrong input");
        }
     
        
    }
    
    static void encryption(int[] key, int[] text){
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] encnum = new int[text.length];
        char[] encytext = new char[text.length];
        System.out.println("Encryption");
        for(int a=0; a<text.length;a++){
            encnum[a] = (text[a] + key[a])%26;
            encytext[a] = letter.charAt(encnum[a]);
            System.out.print(encytext[a]);   
        }
        System.out.println("");
    }
    
    static void decryption(int[] key, int[] text){
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] encnum = new int[text.length];
        char[] encytext = new char[text.length];
        System.out.println("Decryption");
        for(int a=0; a<text.length;a++){
            encnum[a] = (text[a] - key[a])%26;
            if(encnum[a]<0) encnum[a]+=26;
            encytext[a] = letter.charAt(encnum[a]);
            System.out.print(encytext[a]);  
        }
        System.out.println("");
    }  
}
