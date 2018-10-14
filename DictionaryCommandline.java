package sourceCode;

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
    
    public void dictionarySeacher() {
    	System.out.println("Su dung tim kiem mo rong - Nhap tu: ");
    	Scanner myScanner = new Scanner(System.in);
    	String tmp =  myScanner.nextLine();
    	int k = this.dictionaryLookup(tmp);						//su dung DictionaryLookup-> cai tien dictionaryLookup de tim kiem nhanh hon
    	if(k==-1) {
    		k++;
    	}
    	myScanner.close();
    	int seachlist[] = new int[20];
    	int l = tmp.length();
    	int count=0;
    	while(k < this.getMyDicData().size()) {
    		if(this.getMyDicData().get(k).getWord_target().length() < l) {
    			k+=1;
    			continue;
    		}
    		if(this.getMyDicData().get(k).getWord_target().substring(0, l).equals(tmp)) {
    			seachlist[count] = k+1;
    			count++;
    		}
    		k+=1;
    	}
    	
    	System.out.println("danh sach id cac tu khop: ");
    	for(int i=0;i<count;i++) {
    		System.out.print(seachlist[i]+" ");
    	}
    }
    
    public  int[] dictionarySeacher(String tmp) {
    	
    	
    	int k = this.dictionaryLookup(tmp);						//su dung DictionaryLookup-> cai tien dictionaryLookup de tim kiem nhanh hon
    	if(k==-1) {
    		k++;
    	}
    	int seachlistTmp[] = new int[20];
    	int l = tmp.length();
    	int count=0;
    	while(k < this.getMyDicData().size()) {
    		if(this.getMyDicData().get(k).getWord_target().length() < l) {
    			k+=1;
    			continue;
    		}
    		if(this.getMyDicData().get(k).getWord_target().substring(0, l).equals(tmp)) {
    			seachlistTmp[count] = k;
    			count++;
    		}
    		k+=1;
    	}
    	int[] seachlist = new int[count];
    	for(int i=0;i<count;i++) {
    		seachlist[i] = seachlistTmp[i];
    	}
    	return seachlist;
    }
    
    
    
    
}
