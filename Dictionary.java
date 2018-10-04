package BigProject;

import java.util.ArrayList;
import java.util.List;

public class Dictionary  {
	private List<Word> listWord;

	public void add(Word newWord) {
		// TODO Auto-generated method stub
		this.listWord.add(newWord);
	}

	public List<Word> getListWord() {
		return listWord;
	}

	public void setListWord(List<Word> listWord) {
		this.listWord = listWord;
	}

	public Dictionary() {
		
		this.listWord = new ArrayList<>();
	}
	
	 
	
}
