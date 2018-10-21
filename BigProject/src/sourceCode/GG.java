package sourceCode;
import com.darkprograms.speech.translator.GoogleTranslate;

import java.io.IOException;

public class GG {
    public String getMean(String sourceLan,String transLan, String text) throws IOException {
        String tmp = null;
        tmp = GoogleTranslate.translate(sourceLan,transLan,text);
        return  tmp;
    }
}