<<<<<<< HEAD
package BigProject;

import java.io.File;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		//DictionaryManagement arr = new DictionaryManagement();
		//arr.insertFromCommandline();
		DictionaryCommandline show = new DictionaryCommandline();
		//show.dictionaryBasic();
		show.dictionaryAdvanced();
		

	
}
}
=======
package BigProject;

public class main {

	public static void main(String[] args) {
		DictionaryManagement arr = new DictionaryManagement();
		arr.insertFromCommandline();
		DictionaryCommandline show = new DictionaryCommandline(arr);
		show.showAllWords();

	}

}
>>>>>>> 2cf76a6f94735222a6989ef0e9c86c3d7b7e130c
