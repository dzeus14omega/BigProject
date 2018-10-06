<<<<<<< HEAD
package BigProject;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class  DictionaryManagement  {
	
	public Dictionary myDictionary ;
	
	public DictionaryManagement() {
		super();
		this.myDictionary = new Dictionary();
	}

	public void insertFromCommandline()
	{
		 System.out.println("Enter number of words");
		 Scanner cin = new Scanner(System.in);
		 int n = cin.nextInt(); //nhap vao so luong tu
		 String e = cin.nextLine();
		 for(int i=0;i<n;i++)
		 {
			
			 String a , b;
			 System.out.println(" Enter English word : ");
			 a=cin.nextLine();
			 System.out.println(" Enter VietNam word : ");
			 b=cin.nextLine();
			 Word newWord = new Word(a,b); // tao class word co 2 tu
			 myDictionary.add(newWord);
			 
		 }
	}

	public void  insertFromFile(){
        try{
            File inFile = new File("dictionaries2.txt");
            FileReader fileReader = new FileReader(inFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line= reader.readLine()) !=null){
                String [] sepa= line.split("\t");
                Word word = new Word(sepa[0],sepa[1]);
                myDictionary.add(word);
            }
            reader.close();
        }
        catch (Exception e){
        }
    }

	public ArrayList<Word> getListWord() {
		// TODO Auto-generated method stub
		return null;
	}

	public void dictionaryAdvanced() {
		// TODO Auto-generated method stub
		
	}
}


















=======
package BigProject;

import java.util.ArrayList;
import java.util.Scanner;

public class  DictionaryManagement  {
	
	public Dictionary myDictionary ;
	
	public DictionaryManagement() {
		super();
		this.myDictionary = new Dictionary();
	}

	public void insertFromCommandline()
	{
		 System.out.println("Enter number of words");
		 Scanner cin = new Scanner(System.in);
		 int n = cin.nextInt(); //nhap vao so luong tu
		 String e = cin.nextLine();
		 for(int i=0;i<n;i++)
		 {
			
			 String a , b;
			 System.out.println(" Enter English word : ");
			 a=cin.nextLine();
			 System.out.println(" Enter VietNam word : ");
			 b=cin.nextLine();
			 Word newWord = new Word(a,b); // tao class word co 2 tu
			 myDictionary.add(newWord);
			 
		 }
	}

	public ArrayList<Word> getListWord() {
		// TODO Auto-generated method stub
		return null;
	}
}
>>>>>>> 2cf76a6f94735222a6989ef0e9c86c3d7b7e130c
