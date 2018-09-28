package MyDictionary;

//import java.util.Collection;

public class DictionaryCommandline extends Dictionary {
	
	public void showAllWords(){
		System.out.println("No"+"\t"+"| English"+"\t\t"+"| Vietnamese");
		for(int i=1;i<= this.Words.size();i++) {
			System.out.println(i + "\t| "+ this.Words.get(i).getWord_target() + "\t\t| "+this.Words.get(i).getWord_explain());
		}
	}
	
	class DictionaryCommandLine extends DictionaryManagement{
		void dictionaryBasic(){
			this.insertPromCommandline();
			
		}
	}
}
