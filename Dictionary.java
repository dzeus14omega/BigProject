package testSwing;


import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<Word> listWord;
    private double N;
    
    
    //Constructor
    public Dictionary() {
        this.listWord = new ArrayList<>() ;
    	this.N=0;
    }
    public Dictionary(List<Word> _listWord) {
        this.listWord = _listWord;
    }
    
    //getter/settter
    public List<Word> getListWord() {
        return this.listWord;
    }

    public void addNewWord (Word newWord){
        this.listWord.add(newWord);
        this.N++;
    }
	public double size() {
		return N;
	}
	public void setN(double a) {
		this.N = a;
	}

	
}
