package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        DictionaryManagement x = new DictionaryManagement() ;
        x.insertFromCommandline();

        DictionaryCommandline myProgram = new DictionaryCommandline(x) ;
        myProgram.showAllWords();
        System.out.println("----------------------");
        //myProgram.dictionaryBasic();
    }
}
