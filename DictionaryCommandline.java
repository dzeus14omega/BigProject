<<<<<<< HEAD
package BigProject;

import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class DictionaryCommandline{
	private DictionaryManagement myDic;
	
	public DictionaryManagement getMyDic() {
		return myDic;
	}

	public void setMyDic(DictionaryManagement mD) {
		this.myDic = mD;
	}
	
	public   DictionaryCommandline() {
		this.myDic = new DictionaryManagement();
		
	}
	public DictionaryCommandline(DictionaryManagement arr) {
		super();
		this.myDic = arr;
	}
	
	public void showAllWords()
	{
		System.out.println("No\t| English\t\t Vietnamese");
		for(int i=0;i<myDic.myDictionary.getListWord().size();i++)
		{
			int number = i + 1;
			System.out.println(number + "\t|" + myDic.myDictionary.getListWord().get(i).getWord_target() + "\t\t\t|" + myDic.myDictionary.getListWord().get(i).getWord_explain() );
		}
		
	}
	public void dictionaryBasic(){
		this.myDic.insertFromCommandline();
		this.showAllWords();
	}
	public void dictionaryAdvanced()
	{
		this.myDic.insertFromFile();
		this.showAllWords();
		
	}
	
}
=======
package BigProject;

import java.util.ArrayList;

public class DictionaryCommandline{
	private Dictionary myDic;
	
	public Dictionary getMyDic() {
		return myDic;
	}

	public void setMyDic(Dictionary myDic) {
		this.myDic = myDic;
	}
	
	public   DictionaryCommandline() {
		this.myDic = new Dictionary();
		
	}
	public DictionaryCommandline(DictionaryManagement arr) {
		super();
		this.myDic = arr.myDictionary;
	}
	
	public void showAllWords()
	{
		System.out.println("No\t| English\t\t Vietnamese");
		for(int i=0;i<myDic.getListWord().size();i++)
		{
			int number = i + 1;
			System.out.println(number + "\t|" + myDic.getListWord().get(i).getWord_target() + "\t\t\t|" + myDic.getListWord().get(i).getWord_explain() );
		}
		
	}
}
>>>>>>> 2cf76a6f94735222a6989ef0e9c86c3d7b7e130c
