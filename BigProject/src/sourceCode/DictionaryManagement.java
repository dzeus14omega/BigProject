package sourceCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        myScanner.close();
    }
    
    public  void insert_FromFile() throws IOException {
        if(this.myDic.getListWord().isEmpty()==true){        
            InputStream input = new FileInputStream("C:\\MyDictionary\\Dictionaries.txt");
            Scanner sc = new Scanner(new InputStreamReader(input)).useDelimiter("\\s*\t\\s*");
            while (sc.hasNext()) {
                String a = sc.next();
                String v = sc.nextLine();
                v = v.substring(1);
                this.myDic.addNewWord(new Word(a, v));
            }
            sc.close();
        }
    }
    
    
    
    
    //cai tien lan 1 - nhap file tu tao
    public void  insertFromFile() throws IOException{
        
            File inFile = new File("C:\\Users\\Admin\\Desktop\\AnhVietdict.txt");
            FileInputStream fileTmp = new FileInputStream(inFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileTmp, "UTF8"));
            reader.readLine();
//            
            String line;
//            while ((line= reader.readLine()) !=null){
//                String [] sepa= line.split("\t");
//                Word word = new Word(sepa[0],sepa[1]);
//                myDic.addNewWord(word);
//            }
//            reader.close();
//            System.out.println("Open file complete!");
            ArrayList<String> target = new ArrayList<String>();
            ArrayList<String> explain = new ArrayList<String>();
         //   explain.add("");
            String mean="" ;
            int i=-1;
            while((line = reader.readLine()) !=null){
                if(line.charAt(0)!=' '){
                    if(i>=0)
                        explain.add(mean);
                    i++ ;
                    target.add(line);
                    mean = "" ;
                }
                else{
                    mean += line;
                    mean +='\n';
                }
            }
            explain.add(mean);  // add last object
            reader.close();

            for(int j=0; j<target.size(); j++)
            {
                Word word = new Word();
                word.setWord_target(target.get(j));
                word.setWord_explain(explain.get(j));
                this.myDic.addNewWord(word);
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
	public void dictionaryExportToFile() throws IOException {
		File Fout = new File("dictionary.txt");
		FileOutputStream fileTmp = new FileOutputStream(Fout);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileTmp, "UTF8"));
		writer.write("");
		
		for(int i=0;i<this.myDic.size();i++) {
			writer.write(this.myDic.getListWord().get(i).getWord_target() + "\t");
			writer.write(this.myDic.getListWord().get(i).getWord_explain() + "\n");
		}
	    writer.close();
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
    			myScanner.close();
    			return;
    		}
    	}
    	System.out.println("Khong tim thay!*");
    	myScanner.close();
    }
    //---Ham tim tu truyen vao bien
    //--------su dung binarySearch
    public int dictionaryLookup(String input ){
        int left = 0, right = myDic.getListWord().size();
        while(left<=right){
            int mid = (left+right)/2 ;
            if(myDic.getListWord().get(mid).getWord_target().compareTo(input)==0){
                return mid;
            }
            if(myDic.getListWord().get(mid).getWord_target().compareTo(input)<0){
                left = mid +1;
            }
            if(myDic.getListWord().get(mid).getWord_target().compareTo(input)>0){
                right = mid -1;
            }
        }
        return -1;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    //----Ham tim tu truyen vao bien
//    public int dictionaryLookup(String fword) {
//    	for(int i=0;i<this.getMyDicData().size();i++) {
//    		if(fword.equals(this.getMyDicData().get(i).getWord_target())) {
//    			return i;
//    		}
//    	}
//		return -1;
//    }
    
    
    
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
    	this.myDic.getListWord().get(tmp).setWord_explain(word);
    }
    
    //Add
    public void SortDictionary() {
		Collections.sort(this.myDic.getListWord());
    }
    public void nWordFromCml(String word,String mean) {
    	Word nw = new Word();
    	nw.setWord_target(word);
    	//int i = this.dictionaryLookup(mean);
    	nw.setWord_explain(mean);
    	this.myDic.addNewWord(nw);
    	
    	this.SortDictionary();
    	System.out.println("Them tu thanh cong!");
    }

	
    
    
}
