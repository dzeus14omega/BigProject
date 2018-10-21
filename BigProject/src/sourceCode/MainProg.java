package sourceCode;

import java.awt.EventQueue;
import java.io.IOException;

import org.json.simple.parser.ParseException;


//import java.net.MalformedURLException;

//import org.json.simple.parser.ParseException;

//import sourceCode.GoogleAPI.LANGUAGE;


public class MainProg {

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
        //myProgram.showAllWords();
        
        
//        myProgram.dictionaryAdd();
//        myProgram.dictionaryExportToFile();
//        myProgram.dictionaryLookup();
//        myProgram.dictionarySeacher();
        
        
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