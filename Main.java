package sourceCode;

import java.awt.EventQueue;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
    	
        //DictionaryManagement x = new DictionaryManagement() ;
        //x.insertFromCommandline();
        
        DictionaryCommandline myProgram = new DictionaryCommandline() ;
        //myProgram.showAllWords();
        System.out.println("-------------");
        //myProgram.dictionaryBasic();
        
        myProgram.insertFromFile();
        myProgram.SortDictionary();
        myProgram.showAllWords();
        
        
        myProgram.dictionaryAdd();
        myProgram.dictionaryExportToFile();
        myProgram.dictionaryLookup();
        myProgram.dictionarySeacher();
        
//        int[] indexWSearch = myProgram.dictionarySeacher("tra");
//        System.out.println(indexWSearch.length);
//		String[] arrWSearch = new String[indexWSearch.length];
//		for(int i=0;i<arrWSearch.length;i++) {
//			arrWSearch[i] = myProgram.getMyDicData().get(indexWSearch[i]).getWord_target();
//		}
//        for(int i=0;i<arrWSearch.length;i++) {
//        	System.out.println(arrWSearch[i]);
//        }
        
        
        /**
    	 * Launch the application.
    	 */
    	
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					DemoScreen frame = new DemoScreen(myProgram);
    					frame.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
    	
    }
}

/*
4
tradition
tt
traffic
gt
traditional
ttt
cat
meo
dog
wig
toc gia
*/