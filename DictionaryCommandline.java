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
