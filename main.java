package BigProject;

public class main {

	public static void main(String[] args) {
		DictionaryManagement arr = new DictionaryManagement();
		arr.insertFromCommandline();
		DictionaryCommandline show = new DictionaryCommandline(arr);
		show.showAllWords();

	}

}
