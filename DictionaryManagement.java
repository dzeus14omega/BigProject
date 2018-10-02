package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary myDic;

    public DictionaryManagement() {
        this.myDic = new Dictionary();
    }

    public HashMap<String, String> getMyDicData() {
        return this.myDic.getListWord();
    }

    public void insertFromCommandline() {
        System.out.println("Enter number of words");
        Scanner myScanner = new Scanner(System.in);

        int numberWord = myScanner.nextInt();
        String t = myScanner.nextLine() ;
        for (int i=0; i<numberWord; i++)
        {
            String eWord, vWord ;
            System.out.println("Enter English word: ");
            eWord = myScanner.nextLine() ;

            System.out.println("Enter Vietnamese word: ");
            vWord = myScanner.nextLine() ;

            Word newWord = new Word(eWord, vWord);
            this.myDic.addNewWord(newWord);
        }
        myScanner.close();
    }
    
}
