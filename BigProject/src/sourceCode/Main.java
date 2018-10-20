package sourceCode;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;

import sourceCode.GoogleAPI.LANGUAGE;


public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException, ParseException {
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
        
        
//        myProgram.dictionaryAdd();
//        myProgram.dictionaryExportToFile();
//        myProgram.dictionaryLookup();
//        myProgram.dictionarySeacher();
        
//        GoogleAPI translator = new GoogleAPI();
//        translator.setSrcLang(LANGUAGE.ENGLISH);
//        translator.setDestLang(LANGUAGE.VIETNAMESE);
//        String data = translator.translate("Hello Java");
//        System.out.println(data);
        
        
        
        
        
        
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