package MyDictionary;

import java.util.Scanner;



public class DictionaryManagement extends Dictionary {
	
	void insertPromCommandline(){
		System.out.println("Nhap tu: ");
		
		Scanner inp = new Scanner(System.in);
		String newWord = inp.nextLine();
		String mean = inp.nextLine();
		inp.close();
		
		Word tmp = new Word(newWord,mean);
		this.Words.add(tmp);
	}
	
	
	
	
	
	
}
