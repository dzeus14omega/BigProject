public class Word {
	String word_target;
	String Word_explain;
	public String getWord_target() {
		return word_target;
	}
	public void setWord_target(String word_target) {
		this.word_target = word_target;
	}
	public String getWord_explain() {
		return Word_explain;
	}
	public void setWord_explain(String word_explain) {
		Word_explain = word_explain;
	}
	public Word(String word_target, String word_explain) {
		super();
		this.word_target = word_target;
		Word_explain = word_explain;
	}
	
}
