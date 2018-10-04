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
