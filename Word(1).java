package MyDictionary;

public class Word {
	private String word_target;
	private String word_explain;
	public String getWord_target() {
		return word_target;
	}
	public void setWord_target(String word_target) {
		this.word_target = word_target;
	}
	public String getWord_explain() {
		return word_explain;
	}
	public void setWord_explain(String word_explain) {
		this.word_explain = word_explain;
	}
	
	//Constructor
	Word(String word,String meaning){
		this.word_target = word;
		this.word_explain = meaning;
	}
	Word(){
		this.word_explain = "null";
		this.word_target = "null";
	}
}