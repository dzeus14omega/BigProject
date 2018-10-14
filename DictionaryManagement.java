package sourceCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary myDic;
    
    //Constructor
    public DictionaryManagement() {
        this.myDic = new Dictionary();
    }

    //getter
    public List<Word> getMyDicData() {
        return this.myDic.getListWord();
    }

    
    //functions
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
            myDic.addNewWord(newWord);
            
        }
    }
    //cai tien lan 1 - nhap file tu tao
    public void  insertFromFile(){
        try{
            File inFile = new File("C:\\MyDict\\dictionaries.txt");
            if(!inFile.exists()) {
            	System.out.println("Error!");
            	return;
            }
            FileReader fileReader = new FileReader(inFile);
            BufferedReader reader = new BufferedReader(fileReader);
            
            
            String line;
            while ((line= reader.readLine()) !=null){
                String [] sepa= line.split("\t");
                Word word = new Word(sepa[0],sepa[1]);
                myDic.addNewWord(word);
            }
            reader.close();
            System.out.println("Open file complete!");
        }
        catch (Exception e){
        }
    }
    
    //nhap file tu file dien tu Ho Ngoc Duc
//    public void insertFromFileHARD() throws IOException {
//		String fileName = "dict";
//		String content = new String(Files.readAllBytes(Paths.get(fileName)),StandardCharsets.UTF_8);
//		int n = 0,m = 0;
//		
//		String a = new String();
//		String b = new String();
//		for(int i=0 ; i<content.length();i++)
//		{
//			if(content.charAt(i)=='@')
//			{
//				n=i+1;
//			}
//	
//			if(content.charAt(i)==' '&&content.charAt(i+1)=='/')
//			{
//				m = i;
//				a = (content.substring(n, m));
//				//System.out.println(a);
//			}
//			if( content.charAt(i)=='\n' && content.charAt(i+1)=='@' ) {
//				 b = content.substring(m,i);
//				 //System.out.println(b);
//				 	
//			}
//			
//			Word tmp = new Word(a, b);
//			this.myDic.addNewWord(tmp);
//		}
//	}
 // xuất dữ liệu từ điển hiện tại ra files
	public void dictionaryExportToFile() {
	 try {
	         FileWriter file =new FileWriter("C:\\MyDict\\dictionaries.txt");
	        for(int i=0;i<getMyDicData().size();i++)
	        {
	            file.write(getMyDicData().get(i).getWord_target() + "\t" + getMyDicData().get(i).getWord_explain()+"\n");
	        }
	        file.close();
	        System.out.println("Save complete!");
	    }
	 catch (Exception e) {
		// TODO: handle exception
	}
	   
	           
	}
		
		
		
         		

    
    
    
    
    
    //tra cuu phien ban so cap
    //----tra tu nhap lieu
    public void dictionaryLookup() {
    	System.out.print("Tra tu: ");
    	Scanner myScanner = new Scanner(System.in);
        String fword = myScanner.nextLine();
    	for(int i=0;i<this.getMyDicData().size();i++) {
    		if(fword.equals(this.getMyDicData().get(i).getWord_target())) {
    			System.out.println(this.getMyDicData().get(i).getWord_explain());
    			return;
    		}
    	}
    	System.out.println("Khong tim thay!*");
    }
    
    //----Ham tim tu truyen vao bien
    public int dictionaryLookup(String fword) {
    	for(int i=0;i<this.getMyDicData().size();i++) {
    		if(fword.equals(this.getMyDicData().get(i).getWord_target())) {
    			return i;
    		}
    	}
		return -1;
    	
    }
  //----Ham tim tu truyen vao bien (mo rong cho DemoScreen)
    public String Lookup(String fword) {
    	for(int i=0;i<this.getMyDicData().size();i++) {
    		if(fword.equals(this.getMyDicData().get(i).getWord_target())) {
    			return this.getMyDicData().get(i).getWord_explain();
    		}
    	}
		return null;
    	
    }
    
    //Replace: fix tu tieng Anh
    public void rePlaceEWord(String rword,String word) {
    	int tmp = this.dictionaryLookup(rword);
    	if(tmp == -1) {
    		System.out.println("Khong tim thay tu, sua ko thanh cong!**");
    		return;
    	}
    	Word tmpW = getMyDicData().get(tmp);
    	tmpW.setWord_target(word);
    	this.getMyDicData().set(tmp,tmpW);
    }
    //--------fix tu tieng Viet
    public void rePlaceVWord(String rword,String word) {
    	int tmp = this.dictionaryLookup(rword);
    	if(tmp == -1) {
    		System.out.println("Khong tim thay tu, sua ko thanh cong!*");
    		return;
    	}
    	Word tmpW = getMyDicData().get(tmp);
    	tmpW.setWord_explain(word);
    	this.getMyDicData().set(tmp,tmpW);
    }
    
    //Add
    public void SortDictionary() {
		Collections.sort(this.myDic.getListWord());
    }
    public void nWordFromCml() {
    	System.out.println("Nhap tu muon them: ");
    	Word nw = new Word();
    	
    	Scanner myScanner = new Scanner(System.in);
    	String tmp = myScanner.nextLine();
    	nw.setWord_target(tmp);
    	int i = this.dictionaryLookup(tmp);
    	if(i!=-1) {
    		System.out.println("Tu da co trong tu dien");
    		return;
    	}
    	
    	System.out.println("Nhap nghia: ");
    	tmp = myScanner.nextLine();
    	nw.setWord_explain(tmp);
    	this.myDic.addNewWord(nw);
    	
    	this.SortDictionary();
    	System.out.println("Them tu thanh cong!");
    }

	
    
    
}
