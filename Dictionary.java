package com.company;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> listWord;
    
    public Dictionary() {
    	this.listWord = new HashMap<>();
    }

    public Dictionary(HashMap<String, String> x) {
        this.listWord = x;
    }

    public HashMap<String, String> getListWord() {
        return this.listWord;
    }

    public void addNewWord (Word newWord){
    	
    	this.listWord.put(newWord.getWord_target(), newWord.getWord_explain());
    }
}