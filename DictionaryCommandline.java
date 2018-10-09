package testSwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {
    
    
    //Constructor
    public DictionaryCommandline(){
    	super();
    }
    
    //function
    
    public void showAllWords(){
        System.out.println("No\t| English\t\t\t| Vietnamese ") ;
        List<Word> myArr = this.getMyDicData() ;

        for (int i=0; i<myArr.size() ;i++)
        {
            Word word = myArr.get(i);
            int number = i+1;
            System.out.println(number+ "\t| " + word.getWord_target() + "\t\t\t | " + word.getWord_explain());
        }
    }

    public void dictionaryBasic(){
    	this.insertFromCommandline();
    	this.showAllWords();
    }
    public void dictionaryAdvanced() {
    	this.insertFromCommandline();
    	this.SortDictionary();
    	this.showAllWords();
    	this.dictionaryLookup();
    }
    public void dictionaryAdd() {
    	this.nWordFromCml();
    	this.showAllWords();
    }
    
    public  int[] dictionarySeacher() {
    	Scanner myScanner = new Scanner(System.in);
    	String tmp =  myScanner.nextLine();
    	int k = this.dictionaryLookup(tmp);						//su dung DictionaryLookup-> cai tien dictionaryLookup de tim kiem nhanh hon
    	if(k==-1) {
    		k++;
    	}
    	int seachlist[] = new int[20];
    	int l = tmp.length();
    	int count=0;
    	while(k < this.getMyDicData().size()) {
    		if(this.getMyDicData().get(k).getWord_target().length() < l) {
    			continue;
    		}
    		if(this.getMyDicData().get(k).getWord_target().substring(0, l).equals(tmp)) {
    			seachlist[count] = k;
    			count++;
    		}
    		k+=1;
    	}
    	
    	return seachlist;
    }
    
    
    
    
    
}
