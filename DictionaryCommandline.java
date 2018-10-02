package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DictionaryCommandline {
    private DictionaryManagement myDicManger ;

    public DictionaryCommandline(){
    	this.myDicManger = new DictionaryManagement();
    }
    public DictionaryCommandline(DictionaryManagement x) {
        this.myDicManger = x ;
    }

    public void showAllWords(){
        System.out.println("No  | English       | Vietnamese ") ;
        
        HashMap<String, String> myArr = this.myDicManger.getMyDicData() ;
        Set<Entry<String, String>> set = myArr.entrySet();
        
        // Lay mot iterator
        Iterator<Entry<String, String>> i = set.iterator();
        
        int j=1;
        
        // Hien thi cac phan tu
        while(i.hasNext()) {
           Entry<String, String> me = i.next();
           System.out.println(j + "\t| "+ me.getKey() + "\t\t\t| "+ me.getValue());
           j++;
        }
        
        
        
    }
	public void dictionaryBasic() {
		// TODO Auto-generated method stub
		this.myDicManger.insertFromCommandline();
		this.showAllWords();
		
	}


}
